package model.semantique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNomParam;
import model.execution.ECode;
import model.execution.EFonction;
import model.execution.EFonctionRef;
import model.execution.EType;
import model.execution.ETypeObjet;
import model.execution.EUniversDef;

public class FonctionDef extends Code {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124708719741759950L;
	public List<Champ> params = new ArrayList<Champ>();
	public Code code;


	public void assignerModule(String nom) {
		if (code != null) {
			code.assignerModule(nom);
		}
		for (Champ c : params) {
			c.assignerModule(nom);
		}

	}

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {
			if (map.get(c.nom()) != null) {
				u.erreurs.add(new DoublonDeNomParam(c));
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}
		if (code != null) {
			code.verifierSemantique(u, map);
			code.typeRetour(u, map);
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#{");
		for (Champ champ : params) {
			sb.append(champ);
			sb.append(" ");
		}
		sb.append("|");
		sb.append(code);
		sb.append(" ");

		sb.append("}");
		return sb.toString();

	}

	public TypeLiteral typeRetour(Univers u, Map<String, TypeLiteral> variables) {

		if (typeRetour != null) {
			return typeRetour;
		}

		Map<String, TypeLiteral> tmpVariables = new HashMap<>();
		for (Champ c : this.params) {
			tmpVariables.put(c.nom(), c.type);
		}

		typeRetour = typeFunction(u, tmpVariables);
		return typeRetour;

	}

	public TypeFunction typeFunction(Univers u) {

		Map<String, TypeLiteral> tmpVariables = new HashMap<>();
		for (Champ c : this.params) {
			tmpVariables.put(c.nom(), c.type);
		}

		return typeFunction(u, tmpVariables);

	}

	public TypeFunction typeFunction(Univers u, Map<String, TypeLiteral> variables) {
		return typeFunction(0, u, variables);

	}

	public TypeFunction typeFunction(int i, Univers u, Map<String, TypeLiteral> variables) {
		TypeFunction r = new TypeFunction();
		r.param = params.get(i).type;
		if (i == params.size() - 1) {

			r.retour = code.typeRetour(u, variables);
			;
			typeRetour = r.retour;

		} else {
			r.retour = typeFunction(i + 1, u, variables);
		}
		return r;

	}

	public ECode compiler(Univers u, EUniversDef machine) {

		EFonction ef = this.compiler(u, machine, null);
		EFonctionRef efr = new EFonctionRef(ef.idx);
		return efr;
	}

	public EFonction compiler(Univers u, EUniversDef machine, String nom) {
		EFonction ef = new EFonction();
		ef.nom = nom;
		for (int i = 0; i < this.params.size(); i++) {
			ef.map.put(params.get(i).nom(), i);
		}
		ef.params = new EType[params.size()];
		for (int i = 0; i < ef.params.length; i++) {
			ef.params[i] = params.get(i).type.compiler(machine, u);
		}
		EFonction oldFonction = machine.fonctionCourante;
		machine.fonctionCourante = ef;
		if (code != null) {
			ef.code = code.compiler(u, machine);
		}
		ef.idx = machine.fonctions.size();
		if (nom == null) {
			nom = "#" + ef.idx + "#";
		}
		machine.fonctions.put(nom, ef);

		machine.fonctionCourante = oldFonction;
		return ef;
	}

	@Override
	public void donnerModules(Set<String> modules) {
		for (Champ champ : this.params) {
			champ.donnerModules(modules);
		}
		if (code != null)
			code.donnerModules(modules);
		// TODO Auto-generated method stub

	}

}
