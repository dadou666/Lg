package model.erreur;

import model.Acces;
import model.TypeLiteral;

public class ErreurAccesChampInexistant extends ErreurSemantique {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2769582434778846952L;
	public Acces acces;
	public TypeLiteral tl;
	public ErreurAccesChampInexistant(Acces acces,TypeLiteral tl) {
		this.acces=acces;
		this.tl=tl;
	}
	public String toString() {
		return "ErreurAccesChampInexistant "+acces+" dans "+element.afficher();
		
	}

}
