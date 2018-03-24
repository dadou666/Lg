package model.execution;

public class EFonctionAnonyme extends ECode {
	public int numParam;
	public ECode code;
	public EFonctionAnonyme asFonctionAnonyme() {
		return this;
	}
	 public EAppel asAppel(ECode param) {
		 EAppelFonction ar = new EAppelFonction();
		 ar.fonction = this;
		 ar.param = param;
		 ar.numFonctionArgs = ar.fonction.numParam;
		 ar.numAppelArgs = 1;
		 return ar;
	 }
}
