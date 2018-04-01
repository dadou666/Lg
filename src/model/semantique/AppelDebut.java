package model.semantique;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.ErreurNonFonction;
import model.erreur.ErreurTypeIncompatiblePourFonction;
import model.execution.EAppelRec;
import model.execution.ECode;
import model.execution.EFonction;
import model.execution.EFonctionRef;
import model.execution.ELocal;
import model.execution.EUniversDef;

public class AppelDebut extends AppelBase implements Reference {
	public boolean isOp = false;
	private String nom;
	private String module;
	private boolean estLocal = false;

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
			Map<String, TypeLiteral> variables) {
		TypeLiteral tl = variables.get(nom());
		TypeFunction tf = null;
		if (tl != null) {
			if ((tl instanceof TypeFunction)) {
				tf = (TypeFunction) tl;
				estLocal = true;
			}
		}
		if (tf == null) {
			FonctionLocal fl = u.donnerFonction(nom());
			if (fl == null) {

				u.erreurs.add(new ObjetInconnu(this));
				return null;
			}
			fl.tl(u);

			tf = fl.def.typeFunction(u);
		}

		if (tf == null) {
			u.erreurs.add(new ErreurNonFonction(this));
			return null;

		}
		param.verifierSemantique(u, variables);
		tl = param.typeRetour(u, variables);
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



	@Override
	public ECode compiler(Univers u, EUniversDef machine) {
		return this.compilerEAppelRec(u, machine);
	}

	public EAppelRec compilerEAppelRec(Univers u, EUniversDef machine) {
		if (estLocal) {
			int idx = machine.fonctionCourante.map.get(nom);
			EAppelRec al = new EAppelRec();
			al.appel = new ELocal(idx,nom);
			al.param = this.param.compiler(u, machine);
			return al;

		}
		EFonction ef = machine.donnerFonction(nom(), u);
		EAppelRec af = new EAppelRec();
		af.appel = new EFonctionRef(ef.idx);
		af.param = this.param.compiler(u, machine);
		return af;
	}

	public void compiler(Univers u, EUniversDef machine, EAppelRec ar) {
			ar.appel = this.compilerEAppelRec(u, machine);
	}

}
