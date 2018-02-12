package model;

import java.util.Map;

public class Var extends Code implements Reference {
	public String nom;

	public String toString() {
		return nom;
	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		TypeLiteral tl = variables.get(nom);
		if (tl != null) {
			return tl;
		}

		Const c = u.constantes.get(nom);
		if (c == null) {
			u.erreurs.add(new ObjetInconnu(this));
			return null;
		}
		return c.tl(u);

	}
}
