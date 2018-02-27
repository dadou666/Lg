package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Champ {
	public TypeLiteral type;
	private String nom;

	public Champ(String nom, TypeLiteral type) {
		this.nom = nom;
		this.type = type;
	}

	public String nom() {

		return nom;
	}

	public String toString() {
		return type.toString() + ":" + nom();
	}

}
