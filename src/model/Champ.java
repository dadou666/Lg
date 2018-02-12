package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Champ {
	public TypeLiteral type;
	private  String nom;
	public TerminalNode tn;
	public String nom() {
		if (nom == null) {
			nom = tn.getText();
		}
		return nom;
	}
	public String toString() {
		return type.toString()+":"+nom;
	}

}
