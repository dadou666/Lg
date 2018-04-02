package model.semantique;

import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.ErreurNonFonction;
import model.erreur.ErreurTypeIncompatiblePourFonction;
import model.execution.EAppelRec;
import model.execution.ECode;
import model.execution.EUniversDef;

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
			Map<String, TypeLiteral> variables) {

		TypeFunction tf = appel.verifierSemantiqueRec(u, variables);
		if (tf == null) {
			u.erreurs.add(new ErreurNonFonction(appel));
			return null;

		}
		param.verifierSemantique(u, variables);
		TypeLiteral tl = param.typeRetour(u, variables);
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



	@Override
	public ECode compiler(Univers u, EUniversDef machine) {
		EAppelRec ar = new EAppelRec();
		this.appel.compiler(u, machine, ar);
		ar.param = param.compiler(u, machine);
		return ar;
	}

}
