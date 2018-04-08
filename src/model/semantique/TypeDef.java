package model.semantique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNom;
import model.erreur.ErreurAttributSuperTypeRedefini;
import model.execution.ECode;
import model.execution.ETypeObjet;
import model.execution.EUniversDef;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeDef extends Element implements Reference {
	public boolean isAbstract = false;

	private String nom;
	public boolean multiple;
	public String superModule;
	public String superType;
	public List<Champ> champs = new ArrayList<>();
	Map<String, TypeLiteral> map;

	public String superType() {
		if (superModule != null) {
			return superModule + "$" + superType;
		}
		return superType;
	}



	public void donnerModules(Set<String> modules) {
		for (Champ c : champs) {
			c.donnerModules(modules);
		}

	}

	public void assignerModule(String nom) {
		if (superModule == null) {
			superModule = nom;
		}
		for (Champ c : champs) {
			c.assignerModule(nom);
		}

	}

	public TypeDef(String nom) {
		this.nom = nom;
	}

	public String afficher() {
		return "Type " + this.nom();
	}

	public String nom() {
		if (multiple) {

			return "@" + nom;
		}
		return nom;

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (isAbstract) {
			sb.append("asbtract ");
		}
		sb.append("type ");

		sb.append(nom());
		if (superType != null) {
			sb.append(":");
			if (superModule != null) {
				sb.append(superModule);
				sb.append("$");
			}
			sb.append(superType);
		}
		sb.append("{ ");
		for (Champ c : champs) {
			sb.append(c);
			sb.append(" ");
		}
		sb.append(" }");
		return sb.toString();

	}

	public void init(Univers u) {
		if (u.donnerType(nom().toString()) != null) {
			u.erreurs.add(new DoublonDeNom(nom(), this));
		}

		if (this.multiple) {
			if (u.donnerType(nom()) != null) {
				u.erreurs.add(new DoublonDeNom(nom(), this));
			}

			TypeDef vide = new TypeDef(nom);
			vide.nom = nom;
			vide.multiple = false;
			vide.superModule = superModule;
			vide.superType = superType;
			superType = nom;
			if (u.donnerType(vide.nom) != null) {
				u.erreurs.add(new DoublonDeNom(vide.nom, this));
			}
			u.ajouterType(vide.nom, vide);
			Champ champ  = new Champ("next", new TypeSimple(vide.nom,null));
			this.champs.add(champ);

		}

		u.ajouterType(nom(), this);

	}

	public void verifierSemantique(Univers u) {

		TypeDef superTypeDef = null;
		if (superType != null) {
			superTypeDef = u.donnerType(superModule, superType);

			if (superTypeDef == null) {
				u.erreurs.add(new ObjetInconnu(this));
			}
		}

		for (Champ c : champs) {

			if (superTypeDef != null
					&& u.champs(superType).get(c.nom()) != null) {
				u.erreurs.add(new ErreurAttributSuperTypeRedefini(c));
			}
			c.type.verifierSemantique(u);

		}
		u.champs(this.nom());

	}

	@Override
	public String nomRef() {
		return this.superType();
	}

	@Override
	public void compiler(String nomModule, EUniversDef machine, Univers u) {
		String nomComplet = null;
		if (nomModule == null) {
			nomComplet = nom;
		} else {
			nomComplet = nomModule+"$"+nom;
		}
		
		if (multiple) {

			nomComplet = "@" + nomComplet;
		}
		machine.donnerType(nomComplet, u);
		
	}

	
}
