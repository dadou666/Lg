package model.execution;

public class EEntier extends ECode {
	public EType type;
	public long valeur;

	public ECode getAttribute(int adr) {
		EEntier r = new EEntier();
		r.valeur = this.valeur - 1;
		if (r.valeur == 0) {
			r.type = type.superType;
		} else {
			r.type = type;
		}
		return r;

	}
	public EType type() {
		return type;
	}
}
