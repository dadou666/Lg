package model.execution;

abstract public class ECode {
	public abstract ECode calculer(ECode vars[],EUniversDef machine) ;
	
	public ECode calculer(EUniversDef machine) {
		return this.calculer(new ECode[0],machine);
	}
	

	abstract public ECode getAttribute(int adr,EUniversDef machine) ;

	public EFonction asFonctionAnonyme() {
		throw new Error("No Fonction");
	}



	abstract public ETypeObjet type(EUniversDef machine) ;
	abstract public String afficher(EUniversDef univers);
	 public ECode calculSymbolic(EUniversDef univers) {
		 return this.calculer(new ECode[0],univers);
	 }

}
