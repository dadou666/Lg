package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeDef extends Element implements Reference {
	public boolean isAbstract = false;
	public TerminalNode tn;
	private String nom;
	public boolean multiple;
	public String superType;
	public List<Champ> champs;
	Map<String, TypeLiteral> map;

	public String nom() {
		if (nom == null) {
			if (multiple) {
				nom = "*" + tn.getText();
			} else {
				nom = tn.getText();
			}

		}
		return nom;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isAbstract) {
			sb.append("asbtract ");
		}
		sb.append("type ");

		sb.append(nom());
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

	public void init(Univers u) {
		if (u.donnerType(nom().toString()) != null) {
			u.erreurs.add(new DoublonDeNom(nom(), this));
		}
		if (this.multiple) {
			if (u.donnerType(nom()) != null) {
				u.erreurs.add(new DoublonDeNom(nom(), this));
			}

			TypeDef vide = new TypeDef();
			vide.nom = tn.getText();
			vide.multiple = false;
			vide.superType = superType;
			superType = tn.getText();
			if (u.donnerType(vide.nom) != null) {
				u.erreurs.add(new DoublonDeNom(vide.nom, this));
			}
			u.ajouterType(vide.nom, vide);

		}
		u.ajouterType(nom(), this);

	}

	public void verifierSemantique(Univers u) {
		map = new HashMap<String, TypeLiteral>();
		TypeDef superTypeDef = null;
		if (superType != null) {
			superTypeDef = u.donnerType(superType);

			if (superTypeDef == null) {
				u.erreurs.add(new ObjetInconnu(this));
			}
		}
		for (Champ c : champs) {
			if (map.get(c.nom()) != null) {
				u.erreurs.add(new DoublonDeNomParam(c));
			}
			if (superTypeDef != null && u.typeChamp(superType, c.nom()) != null) {
				u.erreurs.add(new ErreurAttributSuperTypeRedefini(c));
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return superType;
	}

}
