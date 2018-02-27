package model;

public class DoublonDeNom extends ErreurSemantique {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Element elt;
	public String nom;
	public DoublonDeNom(String nom,Element elt) {
		this.elt=elt;
		this.nom = nom;
		
	}
	public String toString() {
		return " doublons "+nom;
	}

}
