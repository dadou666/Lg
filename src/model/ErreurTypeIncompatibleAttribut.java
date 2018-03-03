package model;

public class ErreurTypeIncompatibleAttribut extends ErreurSemantique {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8601618198241156953L;
	public TypeLiteral typeAttendu;
	public TypeLiteral typeFourni;
	public Attribut att;
	public String toString() {
		return "ErreurTypeIncompatibleAttribut attendu "+ typeAttendu+" fourni "+typeFourni+" attribut "+att.nomRef()+" dans "+element.afficher();
	}
	
	
	
	

}
