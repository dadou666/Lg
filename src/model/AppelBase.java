package model;

import java.util.Map;

public class AppelBase extends Code {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5822263846028517415L;
	public Code param;
	public TypeLiteral typeRetour;

	public String nom() {

		return null;
	}
	public String toStringRec() {
		return null;
	}
	public String toString() {
		return this.toStringRec()+")";
	}
	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		this.verifierSemantiqueRec(u, variables, null);
}
	public TypeFunction verifierSemantiqueRec(Univers u, Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		return null;
	}
	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		return typeRetour;

	}

}
