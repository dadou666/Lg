package model.semantique;

import java.util.Map;
import java.util.Set;

import model.execution.ECode;
import model.execution.EEntier;
import model.execution.ETypeObjet;
import model.execution.EUniversDef;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Entier extends Code implements Reference {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6492955326184315539L;
	public String type;
	public String module;
	public int valeur;

	public String type(boolean isZero) {
		String tmp = type;
		if (!isZero) {
			tmp = "@"+type;
		}
		if (module != null) {
			return module + "$" + tmp;
		}
		return tmp;
	}

	public Entier(String type, String module, int valeur) {
		this.type = type;
		this.module = module;
		this.valeur = valeur;
	}

	public Entier(TerminalNode tn) {

		String txt = tn.getText();

		int idx = 0;
		while (idx < txt.length() && Character.isDigit(txt.charAt(idx))) {
			idx++;
		}

		type = txt.substring(idx);
		int idxModule = type.indexOf("$");
		if (idxModule >= 0) {
			module = type.substring(0, idxModule);
			type = type.substring(idxModule + 1);
		}
		valeur = Integer.parseInt(txt.substring(0, idx));
	}

	public String toString() {
		if (module != null) {
			return valeur + module + "$" + type;
		}
		return valeur + type;

	}

	public void donnerModules(Set<String> modules) {
		if (module != null) {
			modules.add(module);
		}
	}

	public void assignerModule(String nom) {
		if (module == null) {
			module = nom;
		}

	}

	public TypeLiteral typeRetour(Univers u, Map<String, TypeLiteral> variables) {
		if (typeRetour != null) {
			return typeRetour;
		}
		if (valeur > 0) {
			typeRetour = new TypeMultiple(type, module);

			return typeRetour;
		}
		typeRetour = new TypeSimple(type, module);

		return typeRetour;

	}

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		this.typeRetour(u, variables);
		if (u.donnerType(type(true)) == null) {
			u.erreurs.add(new ObjetInconnu(this));
			return;

		}
		if (u.donnerType(type(false)) == null) {
			u.erreurs.add(new ObjetInconnu(this));
			return;

		}

		if (u.champs(type(false)).isEmpty()) {
			return;
		}

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return type(true);
	}

	@Override
	public ECode compiler(Univers u, EUniversDef machine) {
		// TODO Auto-generated method stub
		EEntier r = new EEntier();
		ETypeObjet eto = machine.donnerType(this.typeRetour.toString(), u);
		r.idx = eto.idx;
		r.valeur = this.valeur;

		return r;
	}

}
