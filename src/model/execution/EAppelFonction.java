package model.execution;

public class EAppelFonction extends EAppel {
	public EFonctionAnonyme fonction;
	public EAppel initLocal(ECode  [] vars) {
		EAppelFonction af = new EAppelFonction();
		af.fonction = fonction;
		af.param = param.calculer(vars);
		af.numFonctionArgs =  fonction.numParam;
		af.numAppelArgs = 1;
		return af;
		
	}
	public EFonctionAnonyme donnerFonctionAnonyme() {
		return fonction;
	}
	public void arguments(ECode vars[] ,int idxVar) {
		vars[idxVar] = param;
	
	}
	public ECode calculer() {
		if ( numAppelArgs == numFonctionArgs) {
			ECode vars[] = new ECode[numFonctionArgs];
			this.arguments(vars, numFonctionArgs);
			EFonctionAnonyme f = this.donnerFonctionAnonyme();
			return f.calculer(vars);
			
		}
		
		return this;
		
	}
	
}
