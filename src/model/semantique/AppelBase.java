package model.semantique;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.execution.EAppelRec;
import model.execution.ECode;
import model.execution.EUniversDef;

abstract public class AppelBase extends Code {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5822263846028517415L;
	


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


	public void compiler(Univers u, EUniversDef machine,EAppelRec ar) {
		
	}

	
	

}
