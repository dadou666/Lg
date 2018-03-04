package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FonctionLocal extends Element {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8282379615738670283L;

	private String nom;

	public List<Champ> params = new ArrayList<>();
	public Code code;
	public TypeLiteral tlReturn;
	public boolean defType = false;
	public FonctionLocal(String nom) {
		this.nom= nom;
	}
	public String afficher() {
		return "Fonction "+nom;
	}
public void assignerModule(String nom) {
			for(Champ c:params) {
				c.assignerModule(nom);
			}
			code.assignerModule(nom);
			if (tlReturn != null) {
			tlReturn.assignerModule(nom);
			}
		
	}
	public TypeLiteral tl(Univers u, Map<String, FonctionLocal> locals) {
		if (tlReturn != null) {
			return tlReturn;
		}
		if (defType) {
			return null;
		}
		defType = true;
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {

			map.put(c.nom(), c.type);
		}
		tlReturn= code.typeRetour(u, map, locals);
		return tlReturn;

	}

	public String nom() {
		return nom;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom());
		sb.append("=");
		for (Champ champ : params) {
			sb.append(champ);
			sb.append(" ");
		}
		sb.append("|");
		sb.append(code);
		return sb.toString();
	}

	public void init(Univers u) {
		if (u.donnerFonction(nom()) != null) {
			u.erreurs.add(new DoublonDeNom(nom(), this));
		}
		u.ajouterFonction(nom, this);
	}

	public void verifierSemantique(Univers u){
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {
			if (map.get(c.nom()) != null) {
				u.erreurs.add(new DoublonDeNomParam(c));
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}

		code.verifierSemantique(u, map);
		tlReturn = code.typeRetour(u, map, null);
	}

}
