package model.erreur;

import model.AppelBase;

public class ErreurNonFonction extends ErreurSemantique {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6223696124246001941L;
	public AppelBase ab;
	public ErreurNonFonction(AppelBase ab) {
		this.ab=ab;
	}
	public String toString() {
		return "ErreurNonFonction attendu "+ab+" dans "+element.afficher();
	}

}
