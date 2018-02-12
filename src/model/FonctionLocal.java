package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FonctionLocal extends Element {
	private String nom;
	public TerminalNode tn;
	public ParserRuleContext pr;
	public List<Champ> params;
	public Code code;
	private TypeLiteral tl;
	public boolean defType = false;

	public TypeLiteral tl(Univers u, Map<String, FonctionLocal> locals) {
		if (tl != null) {
			return tl;
		}
		if (defType) {
			return null;
		}
		defType = true;
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {

			map.put(c.nom(), c.type);
		}
		tl= code.typeRetour(u, map, locals);
		return tl;

	}

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
		sb.append(nom);
		sb.append("=");
		for (Champ champ : params) {
			sb.append(champ);
			sb.append(" ");
		}
		sb.append("|");
		sb.append(code);
		return sb.toString();
	}

	public void init(Univers u) throws DoublonDeNom {
		if (u.fonctions.get(nom) != null) {
			u.erreurs.add(new DoublonDeNom(nom, this));
		}
		u.fonctions.put(nom, this);
	}

	public void verifierSemantique(Univers u) throws ErreurSemantique {
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {
			if (map.get(c.nom()) != null) {
				throw new DoublonDeNomParam(c);
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}

		code.verifierSemantique(u, map);
		tl = code.typeRetour(u, map, null);
	}

}
