package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreerObjet extends Code {

	public TypeBasic type;
	public List<Attribut> attributs = new ArrayList<>();

	public CreerObjet() {

	}

	public CreerObjet(String module, String nom, String champ,
			List<Code> codes, int idx) {
		if (codes.size() == idx) {
			type = new TypeSimple(nom, module);
			return;

		}
		type = new TypeMultiple(nom, module);
		attributs.add(new Attribut(champ, codes.get(idx)));
		attributs.add(new Attribut("next", new CreerObjet(module, nom, champ,
				codes, idx + 1)));

	}

	public CreerObjet(String module, String nom, List<List<Attribut>> codes,
			int idx) {
		if (codes.size() == idx) {
			type = new TypeSimple(nom, module);
			return;

		}
		type = new TypeMultiple(nom, module);
		for (Attribut a : codes.get(idx)) {
			attributs.add(a);
		}
		attributs.add(new Attribut("next", new CreerObjet(module, nom, 
				codes, idx + 1)));

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(type);
		sb.append("{ ");
		for (Attribut a : attributs) {
			sb.append(a);
			sb.append(" ");
		}
		sb.append("}");
		return sb.toString();
	}

	public void assignerModule(String nom) {
		type.assignerModule(nom);

	}

	public void donnerModules(Set<String> modules) {
		type.donnerModules(modules);
		for (Attribut a : attributs) {
			a.donnerModules(modules);
		}
	}

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		type.verifierSemantique(u);
		Set<String> noms = new HashSet<String>();
		for (Attribut a : attributs) {
			if (noms.contains(a.nom())) {
				u.erreurs.add(new DoublonDeNomCreer(a));
			} else {
				noms.add(a.nom());
				TypeLiteral tl = a.code.typeRetour(u, variables, null);
				TypeLiteral tlChamp = u.champs(type.toString()).get(a.nom());
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
		TypeDef td = u.donnerType(this.type.toString());
		if (td == null) {
			u.erreurs.add(new ObjetInconnu(type));
			return;
		}
		for (String nom : u.champs(this.type.toString()).keySet()) {
			if (!noms.contains(nom)) {
				ErreurAttributAbsentDansCreer erreur = new ErreurAttributAbsentDansCreer();
				erreur.nom = nom;
				erreur.type = this.type.toString();
				u.erreurs.add(erreur);

			}
		}

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		return type;
	}

	public Code creer(GestionNom gestionNom) {
		CreerObjet r = new CreerObjet();
		r.type = new TypeSimple("creerObjet", "metaModele");
		r.attributs.add(new Attribut("tp", this.type.creer(gestionNom)));
		List<List<Attribut>> attributs = new ArrayList<List<Attribut>>();
		for(Attribut a:this.attributs) {
			List<Attribut> ls = new ArrayList<Attribut>();
			ls.add(new Attribut("nom",gestionNom.donnerNom(a.nom())));
			ls.add(new Attribut("code",a.code.creer(gestionNom)));
			attributs.add(ls);
			
		}
		r.attributs.add(new Attribut("champsCreer", new CreerObjet("metaModele","champsCreer",attributs,0)));

		return r;

	}
}
