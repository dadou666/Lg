package model.execution;

public class EObjet extends ECode {
	public int idx;
	public ECode attributes[];

	public ECode calculer(ECode[] vars, EUniversDef machine) {
		EObjet r = new EObjet();
		r.idx = idx;
		r.attributes = new ECode[attributes.length];
		for (int i = 0; i < r.attributes.length; i++) {
			r.attributes[i] = attributes[i].calculer(vars, machine);
		}
		if (attributes.length == 1) {
			if (attributes[0] instanceof EEntier) {
				EEntier entier = new EEntier();
				EEntier tmp = (EEntier) attributes[0];
				entier.idx = idx;
				entier.valeur = tmp.valeur + 1;
				return entier;

			}

		}
		return r;

	}

	public ETypeObjet type(EUniversDef machine) {
		return machine.typeArray[idx];
	}

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		return attributes[adr];
	}

	@Override
	public String afficher(EUniversDef univers) {
		ETypeObjet eto = univers.typeArray[idx];
		StringBuilder sb = new StringBuilder();
		sb.append(eto.nom);
		sb.append("{ ");
		for (int i = 0; i < this.attributes.length; i++) {
			sb.append(eto.attributs[i].nom);
			sb.append("=");
			sb.append(attributes[i].afficher(univers));
			sb.append(" ");

		}
		sb.append("}");
		return sb.toString();
	}
}
