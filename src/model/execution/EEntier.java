package model.execution;

public class EEntier extends ECode {
	public int idx;
	public int valeur;

	public ECode getAttribute(int adr, EUniversDef machine) {
		EEntier r = new EEntier();
		r.valeur = this.valeur - 1;
		if (r.valeur == 0) {
			r.idx = machine.typeArray[idx].superType.idx;
		} else {
			r.idx = idx;
		}
		return r;

	}

	public ETypeObjet type(EUniversDef machine) {
		return machine.typeArray[idx];
	}

	@Override
	public ECode calculer(ECode[] vars, EUniversDef machine) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String afficher(EUniversDef univers) {
		if (valeur == 0) {
			return ""+valeur + univers.typeArray[idx].nom;
		}
		int superIdx = univers.typeArray[idx].superType.idx;
		return ""+valeur + univers.typeArray[superIdx].nom;
	}

}
