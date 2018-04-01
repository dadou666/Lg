package model.semantique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNom;
import model.erreur.DoublonDeNomParam;
import model.execution.EFonction;
import model.execution.EUniversDef;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FonctionLocal extends Element {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8282379615738670283L;

	private String nom;

	public FonctionDef def;

	public boolean defType = false;

	public FonctionLocal(String nom) {
		this.nom = nom;
	}

	public String afficher() {
		return "Fonction " + nom;
	}

	public void donnerModules(Set<String> modules) {

		def.donnerModules(modules);

	}

	public void assignerModule(String nom) {

		def.assignerModule(nom);

	}

	public TypeLiteral tl(Univers u) {
		return def.typeRetour(u, new HashMap<String, TypeLiteral>());

	}

	public String nom() {
		return nom;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nom());
		sb.append(def);
		return sb.toString();
	}

	public void init(Univers u) {
		if (u.donnerFonction(nom()) != null) {
			u.erreurs.add(new DoublonDeNom(nom(), this));
		}
		u.ajouterFonction(nom, this);
	}

	public void verifierSemantique(Univers u) {
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		def.verifierSemantique(u, map);
		def.typeRetour(u, map);
	}




	@Override
	public void compiler(String nomModule, EUniversDef machine, Univers u) {
		String nomComplet = null;
		if (nomModule == null) {
			nomComplet = nom;
		} else {
			nomComplet = nomModule + "$" + nom;
		}

		machine.donnerFonction(nomComplet, u);
		
	}

}
