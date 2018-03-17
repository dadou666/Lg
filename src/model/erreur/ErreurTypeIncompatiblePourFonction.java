package model.erreur;

import model.Code;

public class ErreurTypeIncompatiblePourFonction extends ErreurSemantique {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Code code;
	public ErreurTypeIncompatiblePourFonction(Code code) {
		this.code = code;
	}
	public String toString() {
		return "ErreurTypeIncompatiblePourFonction dans "+element.afficher()+" "+code;
		
	}

}
