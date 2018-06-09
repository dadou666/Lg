package model.semantique;

import java.util.List;
import java.util.Set;

import model.execution.EType;
import model.execution.EUniversDef;

public class TypeLiteral implements Reference {
	public void verifierSemantique(Univers u) {

	}

	public void AddParamType(List<TypeLiteral> params) {

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {

		return false;

	}

	public TypeLiteral typeRetour() {

		return this;
	}

	public EType compiler(EUniversDef machine, Univers u) {
		return null;
	}

	public TypeLiteral typeUnion(TypeLiteral tl, Univers u) {
		return null;
	}

	public void assignerModule(String nom) {

	}

	public void donnerModules(Set<String> modules) {

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return null;
	}

}
