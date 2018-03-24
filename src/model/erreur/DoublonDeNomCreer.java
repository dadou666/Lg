package model.erreur;

import model.semantique.Attribut;
import model.semantique.Objet;

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
