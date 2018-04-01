package model.execution;

public class EObjet extends ECode {
	public int idx;
	public ECode attributes[];
	public ECode calculer(ECode[] vars,EUniversDef machine) {
		EObjet r = new EObjet();
		r.idx =idx;
		r.attributes = new EObjet[attributes.length];
		for(int i=0; i < r.attributes.length;i++) {
			r.attributes[i]= attributes[i].calculer(vars,machine);
		}
		return r;
		
		
		
	}
	public ECode getAttribute(int adr) {
		return attributes[adr];
	}
	public ETypeObjet type(EUniversDef machine) {
		return machine.typeArray[idx];
	}

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		throw new Error("getAttribute");
	}
	@Override
	public String afficher(EUniversDef univers) {
		ETypeObjet eto = univers.typeArray[idx];
		StringBuilder sb = new StringBuilder();
		sb.append(eto.nom);
		sb.append("{ ");
		for(int i=0;i < this.attributes.length;i++) {
			sb.append(eto.attributs[i].nom);
			sb.append("=");
			sb.append(attributes[i].afficher(univers));
			sb.append(" ");
			
		}
		sb.append("}");
		return sb.toString();
	}
}
