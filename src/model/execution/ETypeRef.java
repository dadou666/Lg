package model.execution;

public class ETypeRef extends EType {
	public int idx;
	public ETypeRef(int idx) {
		this.idx =idx;
	}

	@Override
	String afficher(EUniversDef univers) {
		// TODO Auto-generated method stub
		return univers.typeArray[idx].nom;
	}

	@Override
	void afficher(StringBuilder sb, EUniversDef univers) {
		// TODO Auto-generated method stub
		
		sb.append("] ->");
		sb.append(univers.typeArray[idx].nom);
		

	}

	@Override
	ESymbol symbol(String nom) {
		// TODO Auto-generated method stub
		 return new ESymbol(nom,idx);
	}

}
