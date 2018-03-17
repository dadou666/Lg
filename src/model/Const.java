package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNom;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Const extends Element {
	public String nom;
	public Code value;
	public Const(String nom,Code value) {
		this.nom = nom;
		this.value = value;
	}
	public void assignerModule(String nom) {
		value.assignerModule(nom);
		
	}
public void donnerModules(Set<String> modules) {
		value.donnerModules(modules);
	}
	public String afficher() {
		return "Constante "+nom;
	}
	public TypeLiteral tl;
	public boolean defType=false;
	public TypeLiteral tl(Univers u) {
		if (tl != null ) {
			return tl;
		}
		if (defType) {
			throw new Error(" constante "+nom);
		}
		defType = true;
		tl = value.typeRetour(u, new HashMap<String,TypeLiteral>(),new HashMap<String,FonctionLocal>());
		return tl;
	}
	public String nom() {
		return nom;
	}
	public String toString() {
		return " const "+nom() +" "+value;
	}
	public void init(Univers u)  {
		if (u.constantes.get(nom()) != null) {
			u.erreurs.add( new DoublonDeNom(nom(), this));
			return;
		}
		u.constantes.put(nom(),this);
		
		
	}
	public void verifierSemantique(Univers u)   {
		
		Map<String,TypeLiteral> map = new HashMap<>();
		Map<String,FonctionLocal> locals = new HashMap<>();
		value.verifierSemantique(u, map, locals);

	}
	
	public Code creer(GestionNom gestionNom, String module,Map<String,Code> map) {
		
		Objet obj = new Objet("metaModele","constante");
		String nom = this.nom;
		if (module != null) {
			nom = module+"$"+this.nom;
		}
		obj.ajouterAttribut("nom", gestionNom.donnerNom(nom));
		obj.ajouterAttribut("code", value.creer(gestionNom));
		
		map.put(nom, obj);
		return obj;
		

	}
}
