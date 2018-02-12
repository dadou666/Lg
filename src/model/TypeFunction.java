package model;

import java.util.List;

public class TypeFunction extends TypeLiteral {
	public TypeLiteral retour;
	public List<TypeLiteral> params;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (TypeLiteral tp : params) {
			sb.append(tp);
			sb.append(" ");
		}
		sb.append("] ->");
		sb.append(retour);
		return sb.toString();

	}

	public void verifierSemantique(Univers u) throws ErreurSemantique {
		retour.verifierSemantique(u);
		for (TypeLiteral tl : params) {
			tl.verifierSemantique(u);
		}

	}

	public boolean peutAccepter(Univers u,TypeLiteral type) {
		if (type instanceof TypeFunction) {
			TypeFunction tf = (TypeFunction) type;
			if (tf.params.size() != params.size()) {
				return false;

			}
			for (int i = 0; i < params.size(); i++) {
				if (params.get(i).peutAccepter(u,tf.params.get(i))) {
					return false;
				}
			}
			if (retour.peutAccepter(u,tf.retour)) {
				return true;
			}

		}

		return false;

	}
	public TypeLiteral typeUnion(TypeLiteral tl, Univers u) {
		return null;
	}

}
