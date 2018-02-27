package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Univers {
	public Map<String, Univers> imports = new HashMap<String, Univers>();
	public List<Element> elements;
	public Map<String, FonctionLocal> fonctions;
	private Map<String, TypeDef> types;
	public Map<String, Const> constantes;
	public List<ErreurSemantique> erreurs = new ArrayList<>();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Element elt : elements) {
			sb.append(elt);
			sb.append("\n");
		}
		return sb.toString();

	}

	public void ajouterType(String nom, TypeDef td) {
		types.put(nom, td);
	}

	public TypeDef donnerType(String nom) {
		int idxModule = nom.indexOf("$");
		if (idxModule < 0) {
			return types.get(nom);
		}
		String module = nom.substring(0, idxModule);
		return imports.get(module).donnerType(nom.substring(idxModule + 1));
	}

	public void verifierSemantique() {
		fonctions = new HashMap<>();
		types = new HashMap<>();
		constantes = new HashMap<>();
		for (Element elt : elements) {
			elt.init(this);
		}
		for (Element elt : elements) {
			elt.verifierSemantique(this);
		}

	}

	public String typeUnion(String t0, String t1) {
		if (t0 == null) {
			return null;
		}
		if (t1 == null) {
			return null;
		}
		if (t0.equals(t1)) {
			return t0;
		}
		if (this.heriteDe(t0, t1)) {
			return t1;
		}
		if (this.heriteDe(t1, t0)) {
			return t0;
		}
		TypeDef td0 = this.types.get(t0);
		TypeDef td1 = this.types.get(t1);
		return typeUnion(td0.superType, td1.superType);

	}

	public boolean heriteDe(String a, String b) {

		String tpNom = a;
		TypeDef current = types.get(b);

		while (true) {
			if (current.superType == null) {
				return false;
			}
			if (current.superType.equals(tpNom)) {
				return true;
			}
			current = types.get(current.superType);
		}

	}

	public TypeLiteral typeChamp(String nomType, String nomChamp) {
		TypeDef td = this.types.get(nomType);
		return td.map.get(nomChamp);

	}

	public Map<String, TypeLiteral> champs(String type) {
		TypeDef td = this.donnerType(type);
		if (td == null) {
			return null;
		}
		if (td.map != null) {
			return td.map;
		}
		td.map = new HashMap<String, TypeLiteral>();
		if (td.multiple) {
			td.map.put("next", new TypeSimple(td.superType));

		}
		TypeDef tmp = td;
		while (tmp != null) {
			
			for (Champ champ : tmp.champs) {
				if (td.map.get(champ.nom()) != null) {
					erreurs.add(new DoublonDeNomParam(champ));

				} else {
					td.map.put(champ.nom(), champ.type);
				}
			}
			if (tmp.superType == null) {
				tmp = null;
			} else {
				tmp = this.donnerType(td.superType);
			}

		}
		return td.map;

	}
}
