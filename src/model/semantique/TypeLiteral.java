package model.semantique;

import java.util.Set;

public class TypeLiteral implements Reference {
	public void verifierSemantique(Univers u) {

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {

		return false;

	}

	public TypeLiteral typeUnion(TypeLiteral tl, Univers u) {
		return null;
	}

	public void assignerModule(String nom) {

	}

	public void donnerModules(Set<String> modules) {

	}

	public Code creer(GestionNom gestionNom) {
		return null;

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
