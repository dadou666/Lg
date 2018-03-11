package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Appel extends Code implements Reference {
	public boolean isOp = false;
	private String nom;
	private String module;

	public Appel(String nom, String module) {
		this.nom = nom;
		this.module = module;
	}

	public void assignerModule(String nom) {
		if (module == null) {
			module = nom;
		}
		for (Code code : this.params) {
			code.assignerModule(nom);
		}

	}

	public void donnerModules(Set<String> modules) {
		if (module != null) {
			modules.add(module);

		}
		for (Code code : this.params) {
			code.donnerModules(modules);
		}
	}

	public List<Code> params;

	public String nom() {

		if (module != null) {
			return module + "$" + nom;
		}

		return nom;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom());
		sb.append("( ");
		for (Code code : params) {
			sb.append(code);
			sb.append(" ");
		}
		sb.append(")");
		return sb.toString();
	}

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		TypeLiteral tl = variables.get(nom());
		if (tl != null) {
			if ((tl instanceof TypeFunction)) {
				TypeFunction tf = (TypeFunction) tl;
				if (tf.params.size() != params.size()) {
					u.erreurs.add(new NombreParametreIncorrecte(this));
					return;

				}
				int i = 0;
				for (Code code : params) {
					code.verifierSemantique(u, variables);
					tl = code.typeRetour(u, variables, null);
					TypeLiteral tyFct = tf.params.get(i);
					if (!tyFct.peutAccepter(u, tl)) {
						u.erreurs.add(new ErreurTypeIncompatiblePourFonction(
								code));

					}
					i++;
				}
				return;
			}

		}

		FonctionLocal fl = u.donnerFonction(nom());
		if (fl == null) {

			u.erreurs.add(new ObjetInconnu(this));
			return;
		}
		if (fl.params.size() != params.size()) {
			u.erreurs.add(new NombreParametreIncorrecte(this));
			return;
		}
		int i = 0;
		for (Code code : params) {
			code.verifierSemantique(u, variables);
			tl = code.typeRetour(u, variables, null);
			TypeLiteral tyFct = fl.params.get(i).type;

			if (!tyFct.peutAccepter(u, tl)) {
				u.erreurs.add(new ErreurTypeIncompatiblePourFonction(code));

			}
			i++;
		}
		;

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		FonctionLocal fl = u.donnerFonction(nom());
		if (fl == null) {
			return null;
		}
		return fl.tl(u, locals);
	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

	public Code creer(GestionNom gestionNom) {
		Objet r = new Objet();
		r.type = new TypeSimple("appel", "metaModele");
		Entier ce = gestionNom.donnerNom(nom());
		r.attributs.add(new Attribut("nom", ce));
		List<Code> codes = new ArrayList<>();
		for (Code code : params) {

			codes.add(code.creer(gestionNom));
		}
		r.attributs.add(new Attribut("codes", new Objet("metaModele",
				"codes", "code", codes, 0)));
		return r;

	}

}
