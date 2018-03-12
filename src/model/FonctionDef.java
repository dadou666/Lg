package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		TypeFunction tf = new TypeFunction();
		for(Champ c:this.params) {
			tmpVariables.put(c.nom(), c.type);
			tf.params.add(c.type);
		}
		
		tf.retour = code.typeRetour(u, tmpVariables, tmpLocals);
		return tf;
		
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
