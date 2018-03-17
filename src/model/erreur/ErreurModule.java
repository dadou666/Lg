package model.erreur;

public class ErreurModule extends ErreurSemantique {

	private static final long serialVersionUID = 463816571158217498L;
	public String nomModuleCourant;
	public String nom;
	
	public enum TypeErreur {
		Inconnu,
		Cycle,
		Semantique,
		Syntaxe
		
		
	}
	public TypeErreur typeErreur;

	public ErreurModule(String nom,String nomModuleCourant,TypeErreur typeErreur) {
		this.nom = nom;
		this.nomModuleCourant=nomModuleCourant;
		this.typeErreur = typeErreur;
	}

	public String toString() {
		return "Module "+typeErreur +"  "+ nom +  " - "+nomModuleCourant;
	}

}
