package model;

import grammaire.lgParser.TypeBaseContext;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeSimple extends TypeBasic {
	public ParserRuleContext tn;
	private String nom;

	public TypeSimple(ParserRuleContext tn) {
		this.tn = tn;
	}

	public void nom(String nom) {
		this.nom = nom;
	}

	public String toString() {
		return nom();
	}

	public String nom() {
		if (nom == null) {
			nom = tn.getText();
		}
		return nom;
	}

	public void verifierSemantique(Univers u) throws ErreurSemantique {
		if (u.types.get(nom()) != null) {
			throw new ObjetInconnu(this);
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
				td = u.types.get(tp);
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

}
