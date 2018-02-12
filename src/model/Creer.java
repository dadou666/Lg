package model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Creer extends Code {
	public TypeBasic type;
	public List<Attribut> attributs;

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

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables)
			throws ErreurSemantique {
		type.verifierSemantique(u);
		Set<String> noms = new HashSet<String>();
		for (Attribut a : attributs) {
			if (noms.contains(a.nom())) {
				u.erreurs.add(new DoublonDeNomCreer(a));
			} else {
				noms.add(a.nom());
				TypeLiteral tl = a.code.typeRetour(u, variables, null);
				TypeLiteral tlChamp = u.types.get(type.toString()).map.get(a
						.nom());
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
		for (String nom : u.types.get(this.type.toString()).map.keySet()) {
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
}
