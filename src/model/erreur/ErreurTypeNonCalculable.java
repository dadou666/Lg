package model.erreur;

import model.semantique.Si;

public class ErreurTypeNonCalculable extends ErreurSemantique {
	public Si si;
	public ErreurTypeNonCalculable(Si si) {
		this.si=si;
	}
	public String toString() {
		return "ErreurTypeNonCalculable dans "+element.afficher()+" "+si;
		
	}
}
