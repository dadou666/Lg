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
import model.execution.EAttribut;
import model.execution.ECode;
import model.execution.EObjet;
import model.execution.ETypeObjet;
import model.execution.EUniversDef;

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


	

	@Override
	public ECode compiler(Univers u, EUniversDef machine) {
		EObjet eo = new EObjet();
		eo.attributes = new ECode[this.attributs.size()];
		ETypeObjet to = machine.donnerType(this.typeRetour.toString(), u);
		eo.idx = to.idx;
		for(Map.Entry<String, Attribut> e:this.attributs.entrySet()) {
			eo.attributes[to.map.get(e.getKey()).adr] = e.getValue().code.compiler(u, machine); 
			
		}
		
		
		return eo;
	}



}
