package model.execution;

import java.util.HashMap;
import java.util.Map;

import model.semantique.TypeDef;
import model.semantique.Univers;

public class Machine {
	
	public Map<String,EFonction> fonctions= new HashMap<>();
	public Map<String,EType> types= new HashMap<>();
	public Map<String,ECode>  constantes = new HashMap<>();
	
	public EType donnerType(String nom,Univers u) {
		EType type = types.get(nom);
		if (type != null) {
			return type;
		}
		TypeDef td = u.donnerType(nom);
		EType r = new EType();
		EType superEType =  null;
		String nomSuperType = td.superType();
		int idxAttribut = 0;
		if (nomSuperType != null) {
			superEType = this.donnerType(nomSuperType, u);
			r.attributs = new EAttribut[superEType.attributs.length+td.champs.size()];
			for(int i = 0;i < superEType.attributs.length;i++) {
				EAttribut ea= superEType.attributs[i];
				r.attributs [i]=ea;
				r.map.put(superEType.attributs[i].nom, ea);
			}
			idxAttribut = superEType.attributs.length;
		} else {
			r.attributs = new EAttribut[td.champs.size()];
			
		}
		for(int i=idxAttribut;i < td.champs.size();i++) {
			EAttribut ea = new EAttribut();
			ea.nom =td.champs.get(i).nom();
			ea.adr =i;
			r.attributs[i] =ea;
		    r.map.put(ea.nom,ea);
		}
		types.put(nom, r);
		return r;
		
		
		
		
	}
	
	
	

}
