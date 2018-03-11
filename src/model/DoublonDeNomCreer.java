package model;

public class DoublonDeNomCreer extends ErreurSemantique {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Objet elt;
	public Attribut att;
	public DoublonDeNomCreer(Attribut att) {
		this.att=att;
		
		
	}

}
