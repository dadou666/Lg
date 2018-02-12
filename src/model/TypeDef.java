package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TypeDef extends Element implements Reference{
	public boolean isAbstract = false;
	public TypeBasic nom;
	public String superType;
	public List<Champ> champs;
	Map<String, TypeLiteral> map;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isAbstract) {
			sb.append("asbtract ");
		}
		sb.append("type ");
		sb.append(nom);
		if (superType != null) {
			sb.append(":");
			sb.append(superType);
		}
		sb.append("{ ");
		for (Champ c : champs) {
			sb.append(c);
			sb.append(" ");
		}
		sb.append(" }");
		return sb.toString();

	}

	public void init(Univers u) throws DoublonDeNom {
		if (u.types.get(nom.toString()) != null) {
			throw new DoublonDeNom(nom.toString(), this);
		}
		if (nom.estMultiple()) {
			if (u.types.get(nom.nom()) != null) {
				throw new DoublonDeNom(nom.nom(), this);
			}

			TypeDef vide = new TypeDef();
			vide.nom = new TypeSimple(null);
			vide.nom.nom( nom.nom());
			vide.superType = superType;
			superType = nom.nom();
			u.types.put(nom.nom(), vide);
			u.types.put(nom.toString(), this);

		} else {
			u.types.put(nom.nom(), this);

		}

	}

	public void verifierSemantique(Univers u) throws ErreurSemantique {
		map = new HashMap<String, TypeLiteral>();
		for (Champ c : champs) {
			if (map.get(c.nom()) != null) {
				throw new DoublonDeNomParam(c);
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}
		if (u.types.get(superType) == null) {
			u.erreurs.add(new ObjetInconnu(this));
		}

	}

}
