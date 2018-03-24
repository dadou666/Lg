package model.semantique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.erreur.DoublonDeNomParam;

public class FonctionDef extends Code {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124708719741759950L;
	public List<Champ> params = new ArrayList<Champ>();
	public Code code;
	public TypeLiteral tlReturn;
	
	public void assignerModule(String nom) {
	
		code.assignerModule(nom);
	
		for(Champ c:params) {
			c.assignerModule(nom);
		}
		
	}
	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables) {
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {
			if (map.get(c.nom()) != null) {
				u.erreurs.add(new DoublonDeNomParam(c));
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}
	
		code.verifierSemantique(u, map);

	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#{");
		for (Champ champ : params) {
			sb.append(champ);
			sb.append(" ");
		}
		sb.append("|");
		sb.append(code);
		sb.append(" ");
	
		sb.append("}");
		return sb.toString();

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables) {
	
		if (typeRetour != null) {
			return typeRetour;
		}
	
		Map<String,TypeLiteral> tmpVariables = new HashMap<>();
		for(Champ c:this.params) {
			tmpVariables.put(c.nom(), c.type);
		}
		
		typeRetour= typeFunction(u, tmpVariables);
		return typeRetour;
		
	}
	public TypeFunction typeFunction(Univers u) {
		
		Map<String,TypeLiteral> tmpVariables = new HashMap<>();
		for(Champ c:this.params) {
			tmpVariables.put(c.nom(), c.type);
		}
		
		return typeFunction(u, tmpVariables);
		
	}
	public TypeFunction typeFunction(Univers u,Map<String, TypeLiteral> variables) {
		return typeFunction(0,u,variables);

	}

	public TypeFunction typeFunction(int i,Univers u,Map<String, TypeLiteral> variables
			) {
		TypeFunction r = new TypeFunction();
		r.param = params.get(i).type;
		if (i == params.size() - 1) {

			r.retour = code.typeRetour(u, variables);;
			tlReturn =r.retour;

		} else {
			r.retour = typeFunction(i + 1,u,variables);
		}
		return r;

	}
	public Code reduire(Univers u,Map<String,Code> variables) {
		return this;
	}
	
}
