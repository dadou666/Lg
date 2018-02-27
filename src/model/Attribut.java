package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Attribut  implements Reference{
	private String nom;
    public Attribut(String nom,Code code) {
    	this.nom = nom;
    	this.code =code;
    }

	public String nom() {
	
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

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

}
