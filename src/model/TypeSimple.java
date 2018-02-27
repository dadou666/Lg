package model;

import grammaire.lgParser.TypeBaseContext;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeSimple extends TypeBasic {

	private String nom;

	public TypeSimple(String nom) {
		this.nom = nom;
	}

	public void nom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom();
	}

	public String nom() {

		return nom;
	}

	public void verifierSemantique(Univers u)   {
		if (u.donnerType(nom()) == null) {
			u.erreurs.add( new ObjetInconnu(this));
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
