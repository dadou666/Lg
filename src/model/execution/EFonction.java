package model.execution;

import java.util.HashMap;
import java.util.Map;

public class EFonction  {
	public int idx;
	public EType params[];
	public Map<String, Integer> map = new HashMap<>();
	public String nom;
	public ECode code;

	public EFonction asFonctionAnonyme() {
		return this;
	}
	public String [] noms() {
		String [] noms = new String[params.length];
		for(Map.Entry<String, Integer> e:map.entrySet()) {
			noms[e.getValue()] = e.getKey();
		}
		return noms;
		
	}

	public String afficher(EUniversDef univers) {
		StringBuilder sb = new StringBuilder();
		if (nom == null) {
			sb.append("#{ ");
			
		} else {
			sb.append("function ");
		}
		String [] noms = noms();
		for(int i=0;i < params.length ;i++) {
			sb.append(params[i].afficher(univers));
			sb.append(":");
			sb.append(noms[i]);
			sb.append(" ");
		}
		sb.append("|");
		sb.append(code.afficher(univers));
		if (nom == null) {
			sb.append("}");
		}
		
		return sb.toString();
	}
	

}
