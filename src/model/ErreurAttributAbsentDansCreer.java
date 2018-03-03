package model;

public class ErreurAttributAbsentDansCreer extends ErreurSemantique {
	public String nom;
	public String type;
public String toString() {
	return "ErreurAttributAbsentDansCreer " + nom +" - "+type + " dans "+element.afficher();
	
}

}
