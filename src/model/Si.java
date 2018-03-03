package model;

import java.util.Map;

public class Si extends Code {
	public Code test;
	public boolean negation = false;
	public TypeBasic type;
	public Code alors;
	public Code sinon;
public void assignerModule(String nom) {
		test.assignerModule(nom);
		type.assignerModule(nom);
		alors.assignerModule(nom);
		sinon.assignerModule(nom);
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("if ");
		sb.append(test);
		sb.append(" is ");
		if (negation) {
			sb.append(" not ");
		}
		sb.append(type);
		sb.append(" then ");
		sb.append(alors);
		sb.append(" else ");
		sb.append(sinon);
		return sb.toString();

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		TypeLiteral tl = null;
		if (!negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		TypeLiteral tpAlors = alors.typeRetour(u, variables, locals);
		test.supprimerPourSi(variables, tl);
		tl = null;
		if (negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		TypeLiteral tpSinon = sinon.typeRetour(u, variables, locals);
		test.supprimerPourSi(variables, tl);
		if (tpAlors == null && tpSinon == null) {
			ErreurTypeNonCalculable e= new ErreurTypeNonCalculable(this);
			u.erreurs.add(e);
			throw e;

		}

		if (tpAlors == null) {
			return tpSinon;
		}

		if (tpSinon == null) {
			return tpAlors;
		}

		TypeLiteral tr= tpAlors.typeUnion(tpSinon, u);
		if (tr == null) {
			throw new ErreurTypeNonCalculable(this);
		}
		return tr;
	}

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		test.verifierSemantique(u, variables);
		TypeLiteral tl = null;
		if (!negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		alors.verifierSemantique(u, variables);
		test.supprimerPourSi(variables, tl);
		if (negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		sinon.verifierSemantique(u, variables);
		test.supprimerPourSi(variables, tl);

	}

}
