package model.execution;

public  class ETypeFonction extends EType {
	public EType param;
	public EType retour;
	@Override
	String afficher(EUniversDef univers) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		this.afficher(sb, univers);
		return sb.toString();
		
	}
	@Override
	void afficher(StringBuilder sb, EUniversDef univers) {
		
		sb.append(param.afficher(univers));
		retour.afficher(sb,univers);
		
		
	}
	@Override
	ESymbol symbol(String nom) {
		throw new Error(" Impossible de créer un symbol ");
	}
	



}
