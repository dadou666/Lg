package model;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Appel extends Code implements Reference {
	public boolean isOp = false;
	private String nom;

	public TerminalNode tn;
	public ParserRuleContext pr;
	public List<Code> params;

	public String nom() {
		if (nom == null) {
			if (tn != null) {
				nom = tn.getText();
			} else {
				nom = pr.getText();
			}
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

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables)
			throws ErreurSemantique {
		FonctionLocal fl = u.fonctions.get(nom());
		if (fl == null) {
			u.erreurs.add(new ObjetInconnu(this));
		}
		if (fl.params.size() != params.size()) {
			u.erreurs.add(new NombreParametreIncorrecte(this));
			return;
		}
		int i = 0;
		for (Code code : params) {
			code.verifierSemantique(u, variables);
			TypeLiteral tl = code.typeRetour(u, variables, null);
			TypeLiteral tyFct = fl.params.get(i).type;
			if (!tyFct.peutAccepter(u, tl)) {
				u.erreurs.add(new ErreurTypeIncompatiblePourFonction(code));

			}
			i++;
		}
		;

	}

	public TypeLiteral typeRetour(Univers u, Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		FonctionLocal fl = u.fonctions.get(nom());
		return fl.tl(u,locals);
	}

}
