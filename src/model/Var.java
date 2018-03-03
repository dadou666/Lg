package model;

import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Var extends Code implements Reference {
	private String nom;
	private String module;
	private boolean estParam=true;
	public Var(String nom,String module) {
		this.nom = nom;
		this.module = module;
	}
	public String toString() {
		return nom();
	}
	public String nom() {
		if (module != null) {
			return module+"$"+nom;
		}
		return nom;
	}
public void assignerModule(String nom) {
		if (estParam) {
			return;
		}
		if (module == null) {
			module =nom;
		}
		
	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		TypeLiteral tl = variables.get(nom());
		if (tl != null) {
			return tl;
		}

		Const c = u.constantes.get(nom());
		if (c == null) {
			FonctionLocal fl = u.donnerFonction(nom());
			if (fl != null) {
				estParam =false;
				TypeFunction tf = new TypeFunction();
				tf.retour = fl.tl(u, null);
				for(Champ champ:fl.params) {
					tf.params.add(champ.type);
				}
				return tf;
			}
			u.erreurs.add(new ObjetInconnu(this));
			return null;
		}
		estParam = false;
		return c.tl(u);

	}
	public TypeLiteral ajouterPourSi(Si si,Map<String,TypeLiteral> variables) {
		TypeLiteral oldTL = variables.get(nom());
		variables.put(nom(), si.type);
		return oldTL;
	}
	public void supprimerPourSi(Map<String,TypeLiteral> variables,TypeLiteral tl) {
		if (tl != null) {
			variables.put(nom, tl);
		}
		
	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}
}
