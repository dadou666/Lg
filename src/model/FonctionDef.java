package model;

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
	public List<FonctionLocal> locals;
	
	public void assignerModule(String nom) {
	
		code.assignerModule(nom);
		for(FonctionLocal fl:locals) {
			fl.assignerModule(nom);
		}
		for(Champ c:params) {
			c.assignerModule(nom);
		}
		
	}
	public void verifierSemantique(Univers u, Map<String, TypeLiteral> variables, Map<String, FonctionLocal> locals) {
		Map<String, TypeLiteral> map = new HashMap<String, TypeLiteral>();
		for (Champ c : params) {
			if (map.get(c.nom()) != null) {
				u.erreurs.add(new DoublonDeNomParam(c));
			}
			c.type.verifierSemantique(u);
			map.put(c.nom(), c.type);
		}
		if (locals == null) {
			locals = new HashMap<>();
		}
		for(FonctionLocal fl:this.locals) {
			locals.put(fl.nom(), fl);
		}
		code.verifierSemantique(u, map,locals);

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
		if (locals != null) {
			for (FonctionLocal local : locals) {

				sb.append(local);
				sb.append(" ");

			}
		}
		sb.append("}");
		return sb.toString();

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		HashMap<String, FonctionLocal> tmpLocals = new HashMap<>();
		if (locals != null) {
			tmpLocals.putAll(locals);
		}
		for (FonctionLocal fl : this.locals) {
			tmpLocals.put(fl.nom(), fl);
		}
		Map<String,TypeLiteral> tmpVariables = new HashMap<>();
		
		return typeFunction(u, tmpVariables, tmpLocals);
		
	}
	public TypeFunction typeFunction(Univers u,Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		return typeFunction(0,u,variables,locals);

	}

	public TypeFunction typeFunction(int i,Univers u,Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		TypeFunction r = new TypeFunction();
		r.param = params.get(i).type;
		if (i == params.size() - 1) {

			r.retour = code.typeRetour(u, variables, locals);;

		} else {
			r.retour = typeFunction(i + 1,u,variables,locals);
		}
		return r;

	}
	public Code reduire(Univers u,Map<String,Code> variables,Map<String,FonctionLocal> locals) {
		return this;
	}
	public Code reduire(Univers u,List<Code> args,Map<String,Code> variablesParent,Map<String,FonctionLocal> localsParent) {
		Map<String,Code> variables = new HashMap<>();
		Map<String,FonctionLocal> mapLocals = new HashMap<>();
		for(int i=0;i< args.size();i++) {
			Champ champ = this.params.get(i);
			variables.put(champ.nom(), args.get(i).reduire(u, variablesParent,localsParent));
			
		}
		for(FonctionLocal fl:locals) {
			mapLocals.put(fl.nom(), fl);
		}
				
				
		return code.reduire(u, variables,mapLocals);
		
		
	}
}
