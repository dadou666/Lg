package model.semantique;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import model.execution.ECode;
import model.execution.EUniversDef;

abstract public class Code implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6169982793520176313L;
	public TypeLiteral typeRetour;

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {

	}
	abstract public void donnerModules(Set<String> modules) ;
	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables) {
		return null;

	}

	public TypeLiteral ajouterPourSi(Si si, Map<String, TypeLiteral> variables) {

		return null;
	}

	public void supprimerPourSi(Map<String, TypeLiteral> variables,
			TypeLiteral tl) {

	}

	public void assignerModule(String nom) {

	}
	
	
abstract	public ECode compiler(Univers u,EUniversDef machine);
	
}
