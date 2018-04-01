package model.execution;

public class ELocal extends EAppel {
	public int adr;
	public String nom;
	public ELocal(int adr,String nom) {
		this.adr =adr;
		this.nom = nom;
	}
	
	public ECode calculer(ECode vars[],EUniversDef machine) {
		return vars[adr];

	}

	

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		throw  new Error("getAttribute");
	}

	@Override
	public ETypeObjet type(EUniversDef machine) {
		throw  new Error("type");
	}

	@Override
	public ECode calculer(EUniversDef machine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void arguments(ECode[] vars, int idxVar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EFonction donnerFonction(EUniversDef machine) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public EAppel initLocal(ECode[] vars, EUniversDef machine) {
		// TODO Auto-generated method stub
		return (EAppel) vars[adr];
	}

	@Override
	public void afficher(StringBuilder sb, EUniversDef univers) {
		sb.append(nom);
		sb.append("(");
		
	}

	@Override
	public String afficher(EUniversDef univers) {
		
		return nom;
	}

	

}
