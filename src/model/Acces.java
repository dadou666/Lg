package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Acces extends Code implements Reference {
	public Code objet;
	private String nom;
	public TerminalNode tn;
	public String nom() {
		if (nom == null) {
			nom= tn.getText();
		}
		return nom;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(objet);
		sb.append(".");
		sb.append(nom());
		return sb.toString();
	}

}
