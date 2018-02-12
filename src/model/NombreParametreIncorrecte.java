package model;

public class NombreParametreIncorrecte extends ErreurSemantique {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7638271437009309745L;
	public Appel appel;
	public NombreParametreIncorrecte(Appel appel) {
		this.appel =appel;
	}

}
