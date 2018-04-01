package model.execution;

public class EContext {
	public EUniversDef univers;
	public ECode code;
	public void calculer() {
		code = code.calculer(new ECode[0],univers);
	}
	public String toString() {
		return code.afficher(univers);
	}

}
