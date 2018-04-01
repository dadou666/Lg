package model.execution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.semantique.Attribut;

public  class ETypeObjet {

	public int idx;
	public ETypeObjet superType;
	public String nom;
	public int debut;
	public int fin;
	public EAttribut [] attributs;
	public Map<String,EAttribut> map = new HashMap<String,EAttribut>();
	
	public List<ETypeObjet> enfants= new ArrayList<ETypeObjet>();
	public String afficher(EUniversDef univers) {
		StringBuilder sb = new StringBuilder();
		sb.append("type ");
		sb.append(nom);
		int d=0;
		
		if (superType != null) {
			sb.append(":");
			sb.append(superType.nom);
			d=superType.attributs.length;
		}
		sb.append("{");
			
		for(int i=d;i < attributs.length;i++ ) {
			EAttribut a=attributs[i];
			sb.append(a.nom);
			sb.append(":");
			sb.append(a.type.afficher(univers));
			
		}
		sb.append("}");
		return sb.toString();
		
		
	}
	public int init(int idx){
		debut = idx;
		for(ETypeObjet enfant:enfants) {
			
			idx = enfant.init(idx);
		
			
		}
		fin =idx;
		return idx;
		
		
	}
	

}
