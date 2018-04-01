package model.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.semantique.Const;
import model.semantique.FonctionLocal;
import model.semantique.TypeDef;
import model.semantique.Univers;

public class EUniversDef {
	
	public Map<String,EFonction> fonctions= new HashMap<>();
	public Map<String,ETypeObjet> types= new HashMap<>();
	public Map<String,ECode>  constantes = new HashMap<>();
	public EFonction [] fonctionArray;
	public ETypeObjet [] typeArray;

	public EFonction fonctionCourante;
	public EFonction donnerFonction(String nom,Univers u) {
		EFonction ef = fonctions.get(nom);
		if (ef != null) {
			return ef;
		}
		FonctionLocal fl = u.donnerFonction(nom);
		 ef = fl.def.compiler(u, this, nom);
		
	
		return ef;
	}
	public ECode donnerConstante(String nom,Univers u) {
		ECode valeur = this.constantes.get(nom);
		if (valeur != null) {
			return valeur;
		}
		Const c = u.donnerConstante(nom);
		valeur = c.value.compiler(u, this);
		this.constantes.put(nom, valeur);
		return valeur;
		
	}
	
	public ETypeObjet donnerType(String nom,Univers u) {
		ETypeObjet type = types.get(nom);
		if (type != null) {
			return type;
		}
		TypeDef td = u.donnerType(nom);
		ETypeObjet r = new ETypeObjet();
		r.nom = nom;
		ETypeObjet superEType =  null;
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
			ea.type=td.champs.get(i).type.compiler(this, u);
			r.attributs[i] =ea;
		    r.map.put(ea.nom,ea);
		}
		r.idx = types.size();
		types.put(nom, r);
		return r;
		
		
		
		
	}
	public void init() {
		fonctionArray= new EFonction[this.fonctions.size()];
		for(Map.Entry<String, EFonction> e:this.fonctions.entrySet()) {
			fonctionArray[e.getValue().idx] = e.getValue();
		}
		typeArray = new ETypeObjet[this.types.size()];
		for(Map.Entry<String, ETypeObjet> e:this.types.entrySet()) {
			typeArray[e.getValue().idx] = e.getValue();
			
		}
		List<ETypeObjet> racines = new ArrayList<ETypeObjet>();
		for(int i=0;i < typeArray.length;i++) {
			ETypeObjet to = typeArray[i];
			if (to.superType != null) {
				to.superType.enfants.add(to);
			} else {
				racines.add(to);
			}
			
		}
		int idx = 0;
		for(ETypeObjet racine:racines) {
			idx= racine.init(idx);
		}
		
		
	}
	public int init(ETypeObjet to,int idx){
		to.debut = idx;
		for(ETypeObjet enfant:to.enfants) {
			
			idx = init(enfant,idx);
		
			
		}
		to.fin =idx;
		return idx;
		
		
	}
	
	
	

}
