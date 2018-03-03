package model;

public class ErreurAccesSurNonObjet extends ErreurSemantique {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1894319816805824298L;
	public Acces acces;
	public ErreurAccesSurNonObjet(Acces acces) {
		this.acces =acces;
	}
	public String toString() {
		return "ErreurAccesSurNonObjet "+acces.nom()+" dans "+element.afficher();
		
	}
}
