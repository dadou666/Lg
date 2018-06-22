package model.erreur;

import model.semantique.Element;

public class ErreurHeritageTypeAPINonPossible extends ErreurSemantique {
	public String nom;
	public ErreurHeritageTypeAPINonPossible(String nom) {
	
		this.nom = nom;
		
	}
	public String toString() {
		return " impossible d'heriter d'un type API "+nom;
	}
}
