package model.execution;

public class EObjet extends ECode {
	public EType type;
	public ECode attributes[];
	public ECode calculer(ECode[] vars) {
		EObjet r = new EObjet();
		r.type =type;
		r.attributes = new EObjet[attributes.length];
		for(int i=0; i < r.attributes.length;i++) {
			r.attributes[i]= attributes[i].calculer(vars);
		}
		return r;
		
		
		
	}
	public ECode getAttribute(int adr) {
		return attributes[adr];
	}
	public EType type() {
		return type;
	}
}
