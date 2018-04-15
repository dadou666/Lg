package model.semantique;

import java.util.Map;
import java.util.Set;

import model.erreur.ErreurAccesChampInexistant;
import model.erreur.ErreurAccesSurNonObjet;
import model.execution.EAcces;
import model.execution.EAppelRec;
import model.execution.EAttribut;
import model.execution.ECode;
import model.execution.EFonction;
import model.execution.EFonctionRef;
import model.execution.ELocal;
import model.execution.ETypeObjet;
import model.execution.EUniversDef;
import model.semantique.Var.TypeVar;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Acces extends AppelBase implements Reference {
	public Code objet;
	private String nom;

	public Acces(Code objet, String nom) {
		this.objet = objet;
		this.nom = nom;
	}

	public String nom() {

		return nom;
	}

	public ECode compiler(Univers u, EUniversDef machine) {
		ETypeObjet etype = machine.donnerType(objet.typeRetour.toString(), u);
		EAcces ea = new EAcces();
		ea.code =  objet.compiler(u, machine);
		ea.adr = etype.map.get(nom).adr;
		ea.nom = nom;
		return ea;
	}

	public void assignerModule(String nom) {
		objet.assignerModule(nom);

	}

	public void donnerModules(Set<String> modules) {
		objet.donnerModules(modules);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(objet);
		sb.append(".");
		sb.append(nom());
		return sb.toString();
	}

	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		objet.verifierSemantique(u, variables);
		objet.typeRetour(u, variables);
		this.typeRetour(u, variables);
	}

	public TypeLiteral typeRetour(Univers u, Map<String, TypeLiteral> variables) {
		if (this.typeRetour != null) {
			return this.typeRetour;
		}
		TypeLiteral tl = objet.typeRetour(u, variables);
		if (!(tl instanceof TypeBasic)) {
			ErreurAccesSurNonObjet erreur = new ErreurAccesSurNonObjet(this);
			u.erreurs.add(erreur);
			return null;
		}
		tl = u.typeChamp(tl.toString(), nom());
		if (tl == null) {
			ErreurAccesChampInexistant erreur = new ErreurAccesChampInexistant(
					this, tl);
			u.erreurs.add(erreur);
		}
		typeRetour = tl;
		return tl;

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}
	public TypeFunction verifierSemantiqueRec(Univers u,
			Map<String, TypeLiteral> variables) {
		TypeLiteral tl = this.typeRetour(u, variables);
		if (tl instanceof TypeFunction) {
			return (TypeFunction) tl;
		}
		return null;
	}
	
	public void compiler(Univers u, EUniversDef machine, EAppelRec ar) {
		ETypeObjet etype = machine.donnerType(objet.typeRetour.toString(), u);
		EAcces ea = new EAcces();
		ea.code =  objet.compiler(u, machine);
		ea.adr = etype.map.get(nom).adr;
		ea.nom = nom;
		ar.appel = ea;
		
	
		
	}

	

}
