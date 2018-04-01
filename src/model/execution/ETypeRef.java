package model.execution;

public class ETypeRef extends EType {
	public int idx;
	public ETypeRef(int idx) {
		this.idx =idx;
	}

	@Override
	String afficher(EUniversDef univers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void afficher(StringBuilder sb, EUniversDef univers) {
		// TODO Auto-generated method stub
		
		sb.append("] ->");
		sb.append(univers.typeArray[idx].nom);
		

	}

}
