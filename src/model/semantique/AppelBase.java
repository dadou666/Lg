package model.semantique;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppelBase extends Code {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5822263846028517415L;
	public Code param;


	public String nom() {

		return null;
	}

	public String toStringRec() {
		return null;
	}

	public String toString() {
		return this.toStringRec() + ")";
	}

	public void verifierSemantique(Univers u,
			Map<String, TypeLiteral> variables) {
		this.verifierSemantiqueRec(u, variables);
	}

	public TypeFunction verifierSemantiqueRec(Univers u,
			Map<String, TypeLiteral> variables) {
		return null;
	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables) {
		return typeRetour;

	}

	public Code reduire(Univers u, Map<String, Code> variables,
			Map<String, FonctionLocal> locals) {
		Code r = this.reduire(u, variables, locals, new ArrayList<Code>());
		if (r == null) {
			return this;
		}
		return r;

	}
	
	public Code reduire(Univers u, Map<String, Code> variables,
			Map<String, FonctionLocal> locals,List<Code> args) {
		return null;

	}
	

}
