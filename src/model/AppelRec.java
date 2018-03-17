package model;

import java.util.Map;
import java.util.Set;

import model.erreur.ErreurNonFonction;
import model.erreur.ErreurTypeIncompatiblePourFonction;

public class AppelRec extends AppelBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 229116752894134972L;
	public AppelBase appel;

	public void assignerModule(String nom) {
		appel.assignerModule(nom);

		param.assignerModule(nom);

	}

	public void donnerModules(Set<String> modules) {
		appel.donnerModules(modules);

		param.donnerModules(modules);

	}

	public String nom() {

		return appel.nom();
	}

	public String toStringRec() {
		StringBuilder sb = new StringBuilder();
		sb.append(appel.toStringRec());

		sb.append(param);
		sb.append(" ");

		return sb.toString();
	}



	public TypeFunction verifierSemantiqueRec(Univers u,
			Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		TypeFunction tf = appel.verifierSemantiqueRec(u, variables, locals);
		if (tf == null) {
			u.erreurs.add(new ErreurNonFonction(appel));
			return null;

		}
		param.verifierSemantique(u, variables, locals);
		TypeLiteral tl = param.typeRetour(u, variables, locals);
		TypeLiteral tyFct = tf.param;
		if (!tyFct.peutAccepter(u, tl)) {
			u.erreurs.add(new ErreurTypeIncompatiblePourFonction(param));

		}
		typeRetour = tf.retour;
		if (tf.retour instanceof TypeFunction) {
		
			return (TypeFunction) tf.retour;
		}
		return null;

	}
}
