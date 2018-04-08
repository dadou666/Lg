package model.semantique;

import generer.Generateur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.DoublonDeNomParam;
import model.erreur.ErreurSemantique;
import model.execution.EUniversDef;

public class Univers {
	public String nom;
	public Map<String, Univers> imports = new HashMap<String, Univers>();
	public List<Element> elements;
	private Map<String, FonctionLocal> fonctions= new HashMap<>();
	private Map<String, TypeDef> types= new HashMap<>();
	public Map<String, Const> constantes= new HashMap<>();
	public List<ErreurSemantique> erreurs = new ArrayList<>();

	public void compiler(String nomModule, EUniversDef univers) {

		for (Element e : elements) {
			e.compiler(nomModule, univers, this);
		}
		for (Map.Entry<String, Univers> e : imports.entrySet()) {
			e.getValue().compiler(nomModule, univers);
		}

	}

	public void ajouterImportModule(String nom, Univers u) {
		imports.put(nom, u);
		u.assignerModule(nom);
	}

	public void assignerModule(String nom) {
		for (Element e : fonctions.values()) {
			e.assignerModule(nom);
		}
		for (Element e : types.values()) {
			e.assignerModule(nom);
		}
		for (Element e : constantes.values()) {
			e.assignerModule(nom);
		}

	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Element elt : elements) {
			sb.append(elt);
			sb.append("\n");
		}
		return sb.toString();

	}

	public FonctionLocal donnerFonction(String nom) {
		int idxModule = nom.indexOf("$");
		if (idxModule < 0) {
			return fonctions.get(nom);
		}
		String module = nom.substring(0, idxModule);
		return imports.get(module).donnerFonction(nom.substring(idxModule + 1));

	}

	public Const donnerConstante(String nom) {
		int idxModule = nom.indexOf("$");
		if (idxModule < 0) {
			return constantes.get(nom);
		}
		String module = nom.substring(0, idxModule);
		return imports.get(module)
				.donnerConstante(nom.substring(idxModule + 1));

	}

	public void ajouterFonction(String nom, FonctionLocal fl) {
		fonctions.put(nom, fl);

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
		return donnerType(module, nom.substring(idxModule + 1));
	}

	public TypeDef donnerType(String module, String nom) {
		if (module == null) {
			return types.get(nom);
		}

		return imports.get(module).donnerType(null, nom);
	}

	public void init() {
	
		for (Element elt : elements) {
			if (elt != null) {
				elt.init(this);
			}
		}
	}

	public void verifierSemantique() {

		for (Element elt : elements) {
			List<ErreurSemantique> tmpLs = new ArrayList<>();

			if (elt != null)
				try {

					tmpLs.addAll(erreurs);
					// System.out.println(" verif "+elt);
					elt.verifierSemantique(this);
					for (ErreurSemantique es : this.erreurs) {
						if (!tmpLs.contains(es))
							es.element = elt;

					}
				} catch (ErreurSemantique es) {
					es.element = elt;
					if (!erreurs.contains(es)) {
						erreurs.add(es);
					}
					for (ErreurSemantique x : this.erreurs) {
						if (!tmpLs.contains(x))
							x.element = elt;

					}
				}
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
		TypeDef td0 = this.donnerType(t0);
		TypeDef td1 = this.donnerType(t1);
		return typeUnion(td0.superType(), td1.superType());

	}

	public TypeSimple donnerTypeElement(String var, String module) {
		if (module == null) {
			if (var.equals(this.nom) || imports.get(var) != null) {
				return new TypeSimple("elements", "metaModele");
			}
			return null;

		}
		if (nom.equals(module)) {

			if (fonctions.get(var) != null) {
				return new TypeSimple("functionDef", "metaModele");
			}
			if (types.get(var) != null) {

				return new TypeSimple("typeDef", "metaModele");
			}
			if (constantes.get(var) != null) {
				return new TypeSimple("constante", "metaModele");
			}
			return null;
		}
		Univers u = imports.get(module);
		if (u == null) {
			return null;
		}
		return u.donnerTypeElement(var, module);

	}

	public boolean heriteDe(String a, String b) {

		String tpNom = a;
		TypeDef current = types.get(b);

		while (true) {
			if (current.superType == null) {
				return false;
			}
			if (current.superType().equals(tpNom)) {
				return true;
			}
			current = this.donnerType(current.superModule, current.superType);
		}

	}

	public TypeLiteral typeChamp(String nomType, String nomChamp) {
		return champs(nomType).get(nomChamp);

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
				tmp = this.donnerType(tmp.superType);
			}

		}
		return td.map;

	}

	public Set<String> modules() {
		HashSet<String> modules = new HashSet<>();
		for (Element e : this.elements) {
			if (e != null) {
				e.donnerModules(modules);
			}
		}

		return modules;

	}

	public void creerMetaModele(String module) throws IOException {

		this.ajouterImportModule("metaModele", Generateur.metaModele());
	}

}
