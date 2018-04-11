package model.execution;

public class EContext {
	public EUniversDef univers;
	public ECode code;
	public void calculer() {
		code = code.calculSymbolic(univers);
	}
	public void calculerSymbolic() {
		code = code.calculSymbolic(univers);
	}
	public String toString() {
		return code.afficher(univers);
	}

}
