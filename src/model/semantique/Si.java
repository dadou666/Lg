package model.semantique;

import java.util.Map;
import java.util.Set;

import model.erreur.ErreurTypeNonCalculable;
import model.execution.ECode;
import model.execution.ESi;
import model.execution.EUniversDef;

public class Si extends Code {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3536489143298195965L;
	public Code test;
	public boolean negation = false;
	public TypeBasic type;
	public Code alors;
	public Code sinon;

	public void donnerModules(Set<String> modules) {
		test.donnerModules(modules);
		type.donnerModules(modules);
		alors.donnerModules(modules);
		sinon.donnerModules(modules);
	}

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
			Map<String, TypeLiteral> variables) {
		if (typeRetour != null) {
			return typeRetour;
		}
		test.typeRetour(u, variables);
		TypeLiteral tl = null;
		if (!negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		TypeLiteral tpAlors = alors.typeRetour(u, variables);
		test.supprimerPourSi(variables, tl);
		tl = null;
		if (negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		TypeLiteral tpSinon = sinon.typeRetour(u, variables);
		test.supprimerPourSi(variables, tl);
		if (tpAlors == null && tpSinon == null) {
			return null;

		}

		if (tpAlors == null) {
			typeRetour = tpSinon;
			return tpSinon;
		}

		if (tpSinon == null) {
			typeRetour = tpAlors;
			return tpAlors;
		}

		TypeLiteral tr = tpAlors.typeUnion(tpSinon, u);
		if (tr == null) {
			throw new ErreurTypeNonCalculable(this);
		}
		typeRetour = tr;
		return tr;
	}

	public void verifierSemantique(Univers u,
			Map<String, TypeLiteral> variables) {
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


	@Override
	public ECode compiler(Univers u, EUniversDef machine) {
		ESi esi = new ESi();
		esi.test = this.test.compiler(u, machine);
		
		if (this.negation) {
			esi.alors = this.sinon.compiler(u, machine);
			esi.sinon =this.alors.compiler(u, machine);
		} else{
			esi.alors = this.alors.compiler(u, machine);
			esi.sinon = this.sinon.compiler(u, machine);
		}
		return esi;
	}

	

}
