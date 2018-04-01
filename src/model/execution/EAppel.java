package model.execution;

abstract public class EAppel extends ECode {
	public int numAppelArgs;
	public int numFonctionArgs;

	abstract public EAppel initLocal(ECode[] vars, EUniversDef machine);

	public ECode calculer(ECode vars[], EUniversDef machine) {
		EAppel appel = this.initLocal(vars, machine);

		if (appel.numAppelArgs < appel.numFonctionArgs) {
			return appel;
		}
		return appel.calculer(machine);

	}

	abstract public ECode calculer(EUniversDef machine);

	abstract public void arguments(ECode vars[], int idxVar);

	abstract public EFonction donnerFonction(EUniversDef machine);
	abstract public void afficher(StringBuilder sb,EUniversDef univers) ;

}
