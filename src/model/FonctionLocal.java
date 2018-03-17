package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNom;
import model.erreur.DoublonDeNomParam;

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

	public TypeFunction typeFunction() {
		return typeFunction(0);

	}

	public TypeFunction typeFunction(int i) {
		TypeFunction r = new TypeFunction();
		r.param = params.get(i).type;
		if (i == params.size() - 1) {

			r.retour = tlReturn;

		} else {
			r.retour = typeFunction(i + 1);
		}
		return r;

	}

	public boolean defType = false;

	public FonctionLocal(String nom) {
		this.nom = nom;
	}

	public String afficher() {
		return "Fonction " + nom;
	}

	public void donnerModules(Set<String> modules) {
		for (Champ c : params) {
			c.donnerModules(modules);
		}
		code.donnerModules(modules);

	}

	public void assignerModule(String nom) {
		for (Champ c : params) {
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
		tlReturn = code.typeRetour(u, map, locals);
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

	public void verifierSemantique(Univers u, Map<String, FonctionLocal> locals) {
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {
			if (map.get(c.nom()) != null) {
				u.erreurs.add(new DoublonDeNomParam(c));
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}

		code.verifierSemantique(u, map, locals);
		tlReturn = code.typeRetour(u, map, locals);
	}

	public void verifierSemantique(Univers u) {
		this.verifierSemantique(u, new HashMap<String,FonctionLocal>());
	}

	public Code creer(GestionNom gestionNom, String module,
			Map<String, Code> map) {
		Objet r = new Objet("metaModele", "functionDef");
		String nom = this.nom;
		if (module != null) {
			nom = module + "$" + nom;
		}
		r.ajouterAttribut(nom, gestionNom.donnerNom(nom));
		List<List<Attribut>> ls = new ArrayList<List<Attribut>>();
		for (Champ c : this.params) {
			List<Attribut> tmp = new ArrayList<>();
			tmp.add(new Attribut("nom", gestionNom.donnerNom(c.nom())));
			tmp.add(new Attribut("tp", c.type.creer(gestionNom)));

		}
		Objet coChamps = new Objet("metaModele", "champs", ls, 0);

		r.ajouterAttribut("champs", coChamps);
		r.ajouterAttribut("code", code.creer(gestionNom));

		map.put(nom, r);
		return r;

	}

	public Code reduire(Univers u, List<Code> args,
			Map<String, Code> variablesParent,
			Map<String, FonctionLocal> localsParent) {

		return null;

	}

}
