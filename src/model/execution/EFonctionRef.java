package model.execution;

public class EFonctionRef extends EAppel {
	public int idx;

	public EFonctionRef(int idx) {
		this.idx = idx;
	}

	@Override
	public ECode calculer(ECode[] vars, EUniversDef machine) {
		// TODO Auto-generated method stub
		return this;
	}

	public ECode calculSymbolic(EUniversDef univers) {
		
		EFonction f = univers.fonctionArray[idx];
		ECode[] vars = new ECode[f.params.length];
		String noms[] = f.noms();
		for (int i = 0; i < vars.length; i++) {
			vars[i] = f.params[i].symbol(noms[i]);

		}
		return f.code.calculer(vars, univers);

	}

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		throw new Error("getAttribute");
	}

	@Override
	public ETypeObjet type(EUniversDef machine) {
		throw new Error("type");
	}



	@Override
	public void arguments(ECode[] vars, int idxVar) {
		// TODO Auto-generated method stub

	}

	@Override
	public EFonction donnerFonction(EUniversDef machine) {
		// TODO Auto-generated method stub
		return machine.fonctionArray[idx];

	}

	@Override
	public EAppel initLocal(ECode[] vars, EUniversDef machine) {
		// TODO Auto-generated method stub
		EFonction ef = machine.fonctionArray[this.idx];
		this.numFonctionArgs = ef.params.length;
		this.numAppelArgs = 0;
		return this;
	}

	@Override
	public void afficher(StringBuilder sb, EUniversDef univers) {
		EFonction ef = univers.fonctionArray[this.idx];
		if (ef.nom == null) {
			sb.append(ef.afficher(univers));
		} else {
			sb.append(ef.nom);
		}
		sb.append("(");

	}

	@Override
	public String afficher(EUniversDef univers) {
		EFonction ef = univers.fonctionArray[this.idx];
		if (ef.nom == null) {
			return ef.afficher(univers);
		}
		return ef.nom;
	}

	@Override
	public ECode calculer(EUniversDef machine) {
		// TODO Auto-generated method stub
		return this;
	}

}
