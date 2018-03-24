package model.execution;

public class EFonction extends EFonctionAnonyme {
	public String nom;

	public void initAppel(ECode vars[], ECode param, EAppelRec parent) {
		EAppelFonction ar = new EAppelFonction();
		ar.param = param;
		ar.fonction = this;
		ar.numAppelArgs = 1;
		parent.numAppelArgs++;
		parent.appel = ar;

	}

}
