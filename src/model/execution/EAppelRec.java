package model.execution;

public class EAppelRec extends EAppel {
	public EAppel appel;

	public EAppel initLocal(ECode[] vars) {
		EAppelRec r = new EAppelRec();
		r.param = param.calculer(vars);
		r.appel = appel.initLocal(vars);
		r.numFonctionArgs = r.appel.numFonctionArgs;

		r.numAppelArgs = r.numAppelArgs + 1;
		return r;

	}

	public EFonctionAnonyme donnerFonctionAnonyme() {
		return appel.donnerFonctionAnonyme();
	}

	public void arguments(ECode vars[], int idxVar) {
		vars[idxVar] = param;
		appel.arguments(vars, idxVar - 1);

	}

	public ECode calculer() {
		if (numAppelArgs == numFonctionArgs) {
			ECode vars[] = new ECode[numFonctionArgs];
			this.arguments(vars, numFonctionArgs);
			EFonctionAnonyme f = this.donnerFonctionAnonyme();
			return f.calculer(vars);

		}
		appel = (EAppel) appel.calculer();
		return this;

	}

}
