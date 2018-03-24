package model.execution;

abstract public class EAppel extends ECode {
	public int numAppelArgs;
	public int numFonctionArgs;

	public ECode param;

	public EAppel initLocal(ECode[] vars) {
		return null;

	}

	public ECode calculer(ECode vars[]) {
		EAppel appel = this.initLocal(vars);
		
		if (appel.numAppelArgs < appel.numFonctionArgs) {
			return appel;
		}
		return this.calculer();

	}
	abstract public ECode calculer() ;
	abstract public void arguments(ECode vars[] ,int idxVar);
	
	public EFonctionAnonyme donnerFonctionAnonyme() {
		return null;
	}

	public EAppel asAppel(ECode param) {
		EAppelRec ar = new EAppelRec();
		ar.appel = this;
		ar.param = param;
		ar.numFonctionArgs = ar.appel.numFonctionArgs;
		ar.numAppelArgs = ar.numAppelArgs + 1;
		return ar;
	}

}
