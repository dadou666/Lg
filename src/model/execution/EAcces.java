package model.execution;

public class EAcces extends ECode {
	public ECode code;
	public int adr;
	public String nom;
	public ECode getAttribute(int adr,EUniversDef machine) {
		return code.getAttribute(adr,machine);
	}
	@Override
	public ECode calculer(ECode[] vars, EUniversDef machine) {
		
		return code.calculer(vars, machine).getAttribute(adr,machine);
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

}
