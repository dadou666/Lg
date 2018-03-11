package model;

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Entier extends Code implements Reference {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6492955326184315539L;
	public String type;
	public String module;
	public int valeur;

	public String type() {
		if (module != null) {
			return module + "$" + type;
		}
		return type;
	}
	public Entier(String type,String module,int valeur) {
		this.type = type;
		this.module = module;
		this.valeur =valeur;
	}
	public Entier(TerminalNode tn) {

		String txt = tn.getText();

		int idx = 0;
		while (idx < txt.length() && Character.isDigit(txt.charAt(idx))) {
			idx++;
		}

		type = txt.substring(idx);
		int idxModule = type.indexOf("$");
		if (idxModule >= 0) {
			module = type.substring(0, idxModule);
			type = type.substring(idxModule + 1);
		}
		valeur = Integer.parseInt(txt.substring(0, idx - 1));
	}

	public String toString() {
		if (module != null) {
			return valeur + module + "$" + type;
		}
		return valeur + type;

	}

	public void donnerModules(Set<String> modules) {
		if (module != null) {
			modules.add(module);
		}
	}

	public void assignerModule(String nom) {
		if (module == null) {
			module = nom;
		}

	}

	public TypeLiteral typeRetour(Univers u,
			Map<String, TypeLiteral> variables,
			Map<String, FonctionLocal> locals) {
		if (valeur > 0) {
			TypeMultiple tm = new TypeMultiple(type(), null);

			return tm;
		}
		TypeSimple ts = new TypeSimple(type(), null);

		return ts;

	}

	public void verifierSemantique(Univers u) {
		if (u.donnerType("@" + type()) != null) {
			u.erreurs.add(new ObjetInconnu(this));

		}
		if (u.donnerType(type()) != null) {
			u.erreurs.add(new ObjetInconnu(this));

		}

		if (u.champs("@"+type()).isEmpty()) {
			return ;
		}
		

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return type();
	}
	
	@Override
	public Code creer(GestionNom gestionNom) {
		Objet r = new Objet("metaModele","entier");
		
		Entier entier = new Entier("nom","metaModele",this.valeur);
		
		r.ajouterAttribut("nom", entier);
		r.ajouterAttribut("tp", gestionNom.donnerNom(type()));
		
		
		return r;
		
		
		
	}

}
