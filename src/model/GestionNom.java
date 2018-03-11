package model;

import java.util.HashMap;
import java.util.Map;

public class GestionNom {
	Map<String,CreerEntier> map = new HashMap<>();
	int valeur =0;
	public CreerEntier donnerNom(String nom) {
		CreerEntier r = map.get(nom);
		if (r == null) {
			r = new CreerEntier("nom","metaModele",valeur);
			valeur++;
			map.put(nom, r);
		}
		return r;
		
	}

}
