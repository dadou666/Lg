package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Attribut  implements Reference{
	private String nom;
	public TerminalNode tn;

	public String nom() {
		if (nom == null) {
			nom = tn.getText();
		}
		return nom;
	}

	public void nom(String nom) {
		this.nom = nom;
	}

	public Code code;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom());
		sb.append("=");
		sb.append(code);
		return sb.toString();
	}

}
