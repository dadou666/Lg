package model.erreur;

import model.Attribut;
import model.Objet;

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
