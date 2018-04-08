package model.execution;

public class ESymbol extends ECode {
	public int idxType;
	public String nom;
	
	public ESymbol(String nom,int idxType) {
	this.nom=nom;
		this.idxType = idxType;
	}

	@Override
	public ECode calculer(ECode[] vars, EUniversDef machine) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ETypeObjet type(EUniversDef machine) {
		// TODO Auto-generated method stub
		return machine.typeArray[idxType];
	}

	@Override
	public String afficher(EUniversDef univers) {
		// TODO Auto-generated method stub
		return nom;
	}

}
