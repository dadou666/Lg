package model.semantique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionNom {
	Map<String,Entier> map = new HashMap<>();
	List<String> entiers = new ArrayList<>();
	int valeur =0;
	public Entier donnerNom(String nom) {
		Entier r = map.get(nom);
		if (r == null) {
			r = new Entier("nom","metaModele",valeur);
			entiers.add(nom);
			valeur++;
			map.put(nom, r);
		}
		return r;
		
	}
	public String nom(Entier e) {
		if (e.valeur < entiers.size()) {
			return entiers.get(e.valeur);
		}
		return e.toString();
	}

}
