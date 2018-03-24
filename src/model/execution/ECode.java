package model.execution;

abstract public class ECode {
	public ECode calculer(ECode vars[]) {
		return this;

	}

	public ECode getAttribute(int adr) {
		throw new Error("No Objet");
	}

	public EFonctionAnonyme asFonctionAnonyme() {
		throw new Error("No Fonction");
	}

	public EAppel asAppel(ECode param) {
		throw new Error(" pas appel");
	}

	public EType type() {
		throw new Error(" Pas objet ");
	}

}
