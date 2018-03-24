package model.semantique;

import java.io.Serializable;
import java.util.Set;


public class Champ implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8424984076157072140L;
	public TypeLiteral type;
	private String nom;

	public Champ(String nom, TypeLiteral type) {
		this.nom = nom;
		this.type = type;
	}
public void assignerModule(String nom) {
		type.assignerModule(nom);
		
	}
public void donnerModules(Set<String> modules) {
	type.donnerModules(modules);
}
	public String nom() {

		return nom;
	}

	public String toString() {
		return type.toString() + ":" + nom();
	}

}
