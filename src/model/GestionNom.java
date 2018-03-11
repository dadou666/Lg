package model;

import java.util.HashMap;
import java.util.Map;

public class GestionNom {
	Map<String,Entier> map = new HashMap<>();
	int valeur =0;
	public Entier donnerNom(String nom) {
		Entier r = map.get(nom);
		if (r == null) {
			r = new Entier("nom","metaModele",valeur);
			valeur++;
			map.put(nom, r);
		}
		return r;
		
	}

}
