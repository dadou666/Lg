package model;

import java.util.Map;
import java.util.Set;

import model.erreur.ErreurTypeNonCalculable;

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
			return null;

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

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		test.verifierSemantique(u, variables, null);
		TypeLiteral tl = null;
		if (!negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		alors.verifierSemantique(u, variables, null);
		test.supprimerPourSi(variables, tl);
		if (negation) {
			tl = test.ajouterPourSi(this, variables);
		}
		sinon.verifierSemantique(u, variables, null);
		test.supprimerPourSi(variables, tl);

	}
	
	public Code creer(GestionNom gestionNom) {
		Objet r = new Objet("metaModele","si");
		r.ajouterAttribut("test", test.creer(gestionNom));
		r.ajouterAttribut("tp", type.creer(gestionNom));
		if (this.negation) {
			r.ajouterAttribut("sinon", alors.creer(gestionNom));
			r.ajouterAttribut("alors", sinon.creer(gestionNom));
			return r;
			
		}
		r.ajouterAttribut("alors", alors.creer(gestionNom));
		r.ajouterAttribut("sinon", sinon.creer(gestionNom));
		return r;
		
		
	}

}
