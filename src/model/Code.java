package model;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

public class Code implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6169982793520176313L;

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {

	}
	public void donnerModules(Set<String> modules) {
		
	}
	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
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
}
