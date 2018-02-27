package model;

import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

public class CreerEntier extends Code implements Reference {
	public TerminalNode tn;
	public String type;
	public int valeur;

	public CreerEntier(TerminalNode tn) {
		this.tn = tn;
		String txt = tn.getText();

		int idx = 0;
		while (idx < txt.length() && Character.isDigit(txt.charAt(idx))) {
			idx++;
		}

		type = txt.substring(idx);
		valeur = Integer.parseInt(txt.substring(0, idx - 1));
	}

	public String toString() {
		return valeur + type;

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		if (valeur > 0) {
			TypeMultiple tm = new TypeMultiple(null);
			tm.nom("*" + type);
			return tm;
		}
		TypeSimple ts = new TypeSimple(null);
		ts.nom(type);

		return ts;

	}

	public void verifierSemantique(Univers u) {
		if (u.donnerType("*" + type) != null) {
			u.erreurs.add(new ObjetInconnu(this));

		}
		if (u.donnerType(type) != null) {
			u.erreurs.add(new ObjetInconnu(this));

		}

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return type;
	}

}
