package model.execution;

public class EAppelLocal extends EAppel {
	public int adr;

	public EAppel initLocal(ECode[] vars) {
		ECode p = param.calculer(vars);

		return vars[adr].asAppel(p);

	}

	public EFonctionAnonyme donnerFonctionAnonyme() {
		throw new Error("Pas de fonction");
	}

	public ECode calculer() {
		throw new Error("Pas de fonction");
	}

	public void arguments(ECode vars[], int idxVar) {
		throw new Error("No args");

	}

}
