package model;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Acces extends Code implements Reference {
	public Code objet;
	private String nom;
public Acces(Code objet,String nom) {
	this.objet = objet;
	this.nom = nom;
}
	public String nom() {
	
		return nom;
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
	public TypeLiteral typeRetour(Univers u, Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		TypeLiteral tl = objet.typeRetour(u, variables, locals);
		if (!(tl instanceof TypeBasic)) {
			ErreurAccesSurNonObjet erreur = new ErreurAccesSurNonObjet(this);
			u.erreurs.add(erreur);
			return null;
		}
		tl = u.typeChamp(tl.toString(), nom());
		if (tl == null) {
			ErreurAccesChampInexistant erreur = new ErreurAccesChampInexistant(this, tl);
			u.erreurs.add(erreur);
		}
		return tl;
		
	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

}
