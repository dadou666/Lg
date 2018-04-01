package model.semantique;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import model.execution.EUniversDef;

public abstract class Element implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6622887799163372062L;

	public void verifierSemantique(Univers u) {

	}

	public void init(Univers u) {

	}

	public String afficher() {
		return null;
	}

	public void assignerModule(String nom) {

	}

	public void donnerModules(Set<String> modules) {

	}
	abstract  public void compiler(String nomModule,EUniversDef machine,Univers u);

	
}
