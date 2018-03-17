package model;

import java.util.Map;
import java.util.Set;

import model.erreur.ErreurNonFonction;
import model.erreur.ErreurTypeIncompatiblePourFonction;

public class AppelDebut extends AppelBase implements Reference {
	public boolean isOp = false;
	private String nom;
	private String module;

	public AppelDebut(String nom, String module, Code param) {
		this.nom = nom;
		this.module = module;
		this.param = param;
	}

	public void assignerModule(String nom) {
		if (module == null) {
			module = nom;
		}

		param.assignerModule(nom);

	}

	public void donnerModules(Set<String> modules) {
		if (module != null) {
			modules.add(module);

		}

		param.donnerModules(modules);

	}

	public String nom() {

		if (module != null) {
			return module + "$" + nom;
		}

		return nom;
	}

	public String toStringRec() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom());
		sb.append("( ");

		sb.append(param);
		sb.append(" ");

		return sb.toString();
	}

	public TypeFunction verifierSemantiqueRec(Univers u,
			Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		TypeLiteral tl = variables.get(nom());
		TypeFunction tf = null;
		if (tl != null) {
			if ((tl instanceof TypeFunction)) {
				tf = (TypeFunction) tl;
			}
		}
		if (tf == null) {
			FonctionLocal fl = u.donnerFonction(nom());
			if (fl == null) {

				u.erreurs.add(new ObjetInconnu(this));
				return null;
			}
			fl.tl(u, null);

			tf = fl.typeFunction();

		}
		if (tf == null) {
			u.erreurs.add(new ErreurNonFonction(this));
			return null;

		}
		param.verifierSemantique(u, variables, locals);
		tl = param.typeRetour(u, variables, locals);
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
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

}
