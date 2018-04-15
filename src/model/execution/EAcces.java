package model.execution;

public class EAcces extends EAppel {
	public ECode code;
	public int adr;
	public String nom;

	public ECode getAttribute(int adr, EUniversDef machine) {
		throw new Error(" pas objet ");
	}

	@Override
	public ECode calculer(ECode[] vars, EUniversDef machine) {

		ECode r = code.calculer(vars, machine);
		if (r instanceof EObjet || r instanceof EEntier) {
			return r.getAttribute(adr, machine);
		}
		EAcces acces = new EAcces();
		acces.code = r;
		acces.adr = adr;
		acces.nom = nom;
		return acces;

	}

	@Override
	public ETypeObjet type(EUniversDef machine) {
		throw new Error("type");
	}

	@Override
	public String afficher(EUniversDef univers) {
		StringBuilder sb = new StringBuilder();
		sb.append(code.afficher(univers));
		sb.append(".");
		sb.append(nom);
		return sb.toString();
	}

	@Override
	public EAppel initLocal(ECode[] vars, EUniversDef machine) {
		// TODO Auto-generated method stub;
		ECode code = this.calculer(vars, machine);
		return (EAppel) code;
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
		throw new Error("pas une fonction");
	}

	@Override
	public void afficher(StringBuilder sb, EUniversDef univers) {
		// TODO Auto-generated method stub
		
	}

}
