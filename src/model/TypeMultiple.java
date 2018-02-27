package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeMultiple extends TypeBasic {
	public TerminalNode tn;
	String nom;

	public TypeMultiple(TerminalNode tn) {
		this.tn = tn;
	}

	public void nom(String nom) {
		this.nom = nom;
	}

	public String nom() {
		if (nom == null) {
			nom = tn.getText();
		}
		return nom;
	}

	public String toString() {
		return "*" + nom();
	}

	public boolean estMultiple() {
		return true;
	}

	public void verifierSemantique(Univers u)   {
		if (u.donnerType( nom()) == null) {
			u.erreurs.add(new ObjetInconnu(this));

		}

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {

		if (type instanceof TypeMultiple || type instanceof TypeSimple) {
			TypeDef td;

			String tp = type.toString();
			if (this.toString().equals(tp)) {
				return true;
			}
			do {
				td = u.donnerType(tp);
				if (td.superType == null) {
					return false;
				}
				if (td.superType.equals(nom())) {
					return true;
				}
				tp = td.superType;
			} while (true);

		}
		return false;

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}
}
