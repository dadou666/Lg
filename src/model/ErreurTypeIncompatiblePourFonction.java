package model;

public class ErreurTypeIncompatiblePourFonction extends ErreurSemantique {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Code code;
	public ErreurTypeIncompatiblePourFonction(Code code) {
		this.code = code;
	}

}
