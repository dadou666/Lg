package model.execution;

public class EAppelRec extends EAppel {
	public EAppel appel;
	public ECode param;

	public EAppel initLocal(ECode[] vars, EUniversDef machine) {
		EAppelRec r = new EAppelRec();
		r.param = param.calculer(vars, machine);
		r.appel = appel.initLocal(vars, machine);
		r.numFonctionArgs = r.appel.numFonctionArgs;

		r.numAppelArgs = r.appel.numAppelArgs + 1;
		return r;

	}

	public EFonction donnerFonction(EUniversDef machine) {
		return appel.donnerFonction(machine);
	}

	public void arguments(ECode vars[], int idxVar) {
		vars[idxVar] = param;
		appel.arguments(vars, idxVar - 1);

	}

	public ECode calculer(EUniversDef machine) {
		if (numAppelArgs == numFonctionArgs) {
			ECode vars[] = new ECode[numFonctionArgs];
			this.arguments(vars, numFonctionArgs-1);
			EFonction f = this.donnerFonction(machine);
			return f.code.calculer(vars, machine);

		}
		appel = (EAppel) appel.calculer(machine);
		return this;

	}

	@Override
	public ETypeObjet type(EUniversDef machine) {
		throw new Error("type");
	}

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		throw new Error("getAttribute");
	}

	@Override
	public String afficher(EUniversDef univers) {
		StringBuilder sb = new StringBuilder();
		appel.afficher(sb, univers);
		sb.append(" ");
		sb.append(param.afficher(univers));
		sb.append(" )");
		return sb.toString();
	}

	@Override
	public void afficher(StringBuilder sb, EUniversDef univers) {
		appel.afficher(sb, univers);
		sb.append(param.afficher(univers));

	}
}
