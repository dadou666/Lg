package model;

public class ObjetInconnu extends ErreurSemantique {

	public Reference ref;
	public ObjetInconnu(Reference ref) {
		this.ref=ref;
	}
	public String toString() {
		return " objet "+ref.nomRef()+" inconnu dans "+element.afficher();
		
	}

}
