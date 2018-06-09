package model.semantique;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.execution.EType;
import model.execution.ETypeFonction;
import model.execution.EUniversDef;

public class TypeFunction extends TypeLiteral {
	public TypeLiteral retour;
	public TypeLiteral param;

	public void AddParamType(List<TypeLiteral> params) {
		params.add(param);
		retour.AddParamType(params);
	}

	public TypeLiteral typeRetour() {
		return retour.typeRetour();

	}

	public EType compiler(EUniversDef machine, Univers u) {
		ETypeFonction etf = new ETypeFonction();
		etf.retour = retour.compiler(machine, u);
		etf.param = retour.compiler(machine, u);
		return etf;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");

		sb.append(param);
		sb.append(" ");

		sb.append("] ->");
		sb.append(retour);
		return sb.toString();

	}

	public void assignerModule(String nom) {
		retour.assignerModule(nom);
		param.assignerModule(nom);
	}

	public void donnerModules(Set<String> modules) {
		retour.donnerModules(modules);

		param.donnerModules(modules);

	}

	public void verifierSemantique(Univers u) {
		retour.verifierSemantique(u);

		param.verifierSemantique(u);

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {
		if (type instanceof TypeFunction) {
			TypeFunction tf = (TypeFunction) type;

			if (!param.peutAccepter(u, tf.param)) {
				return false;
			}

			if (retour.peutAccepter(u, tf.retour)) {
				return true;
			}

		}

		return false;

	}

	public TypeLiteral typeUnion(TypeLiteral tl, Univers u) {
		return null;
	}

}
