package model.semantique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNomCreer;
import model.erreur.ErreurAttributAbsentDansCreer;
import model.erreur.ErreurTypeIncompatibleAttribut;

public class Objet extends Code {


	private Map<String, Attribut> attributs = new HashMap<>();

	public Objet() {

	}

	public Objet(String module, String nom) {
		typeRetour = new TypeSimple(nom, module);
	}

	public Attribut ajouterAttribut(String nom, Code code) {
		Attribut a = new Attribut(nom, code);
		this.attributs.put(nom, a);
		return a;
	}

	public Attribut donnerAttribut(String nom) {
		return attributs.get(nom);
	}

	public Objet(String module, String nom, String champ, List<Code> codes,
			int idx) {
		if (codes.size() == idx) {
			typeRetour = new TypeSimple(nom, module);
			return;

		}
		typeRetour = new TypeMultiple(nom, module);
		ajouterAttribut(champ, codes.get(idx));
		ajouterAttribut("next", new Objet(module, nom, champ, codes, idx + 1));

	}

	public Objet(String module, String nom, List<List<Attribut>> codes, int idx) {
		if (codes.size() == idx) {
			typeRetour = new TypeSimple(nom, module);
			return;

		}
		typeRetour = new TypeMultiple(nom, module);
		for (Attribut a : codes.get(idx)) {
			attributs.put(a.nom(), a);
		}
		ajouterAttribut("next", new Objet(module, nom, codes, idx + 1));

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(typeRetour);
		sb.append("{ ");
		for (Attribut a : attributs.values()) {
			sb.append(a);
			sb.append(" ");
		}
		sb.append("}");
		return sb.toString();
	}

	public void assignerModule(String nom) {
		typeRetour.assignerModule(nom);

	}

	public void donnerModules(Set<String> modules) {
		typeRetour.donnerModules(modules);
		for (Attribut a : attributs.values()) {
			a.donnerModules(modules);
		}
	}

	public void verifierSemantique(Univers u,
			Map<String, TypeLiteral> variables) {
		typeRetour.verifierSemantique(u);
		Set<String> noms = new HashSet<String>();
		for (Attribut a : attributs.values()) {
			if (noms.contains(a.nom())) {
				u.erreurs.add(new DoublonDeNomCreer(a));
			} else {
				noms.add(a.nom());
				a.code.verifierSemantique(u, variables);
				TypeLiteral tl = a.code.typeRetour(u, variables);
				TypeLiteral tlChamp = u.champs(typeRetour.toString()).get(a.nom());
				if (tlChamp == null) {
					u.erreurs.add(new ObjetInconnu(a));
				} else if (!tlChamp.peutAccepter(u, tl)) {

					ErreurTypeIncompatibleAttribut erreur = new ErreurTypeIncompatibleAttribut();
					erreur.typeAttendu = tlChamp;
					erreur.typeFourni = tl;
					erreur.att = a;
					u.erreurs.add(erreur);

				}

			}
		}
		TypeDef td = u.donnerType(this.typeRetour.toString());
		if (td == null) {
			u.erreurs.add(new ObjetInconnu(typeRetour));
			return;
		}
		for (String nom : u.champs(this.typeRetour.toString()).keySet()) {
			if (!noms.contains(nom)) {
				ErreurAttributAbsentDansCreer erreur = new ErreurAttributAbsentDansCreer();
				erreur.nom = nom;
				erreur.type = this.typeRetour.toString();
				u.erreurs.add(erreur);

			}
		}

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables) {
		return typeRetour;
	}

	public Code creer(GestionNom gestionNom) {
		Objet r = new Objet();
		r.typeRetour = new TypeSimple("objet", "metaModele");
		r.ajouterAttribut("tp", this.typeRetour.creer(gestionNom));
		List<List<Attribut>> attributs = new ArrayList<List<Attribut>>();
		for (Attribut a : this.attributs.values()) {
			List<Attribut> ls = new ArrayList<Attribut>();
			ls.add(new Attribut("nom", gestionNom.donnerNom(a.nom())));
			ls.add(new Attribut("code", a.code.creer(gestionNom)));
			attributs.add(ls);

		}
		r.ajouterAttribut("champsCreer", new Objet("metaModele", "champsCreer",
				attributs, 0));

		return r;

	}



}
