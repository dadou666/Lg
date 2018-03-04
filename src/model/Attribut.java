package model;

import java.io.Serializable;
import java.util.Set;



public class Attribut  implements Reference,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8359866606787672169L;
	private String nom;
    public Attribut(String nom,Code code) {
    	this.nom = nom;
    	this.code =code;
    }
public void donnerModules(Set<String> modules) {
	this.code.donnerModules(modules);	
	}
	public String nom() {
	
		return nom;
	}
public void assignerModule(String nom) {
		code.assignerModule(nom);
		
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
