package model;

import java.util.Set;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeMultiple extends TypeBasic {

	String nom;
	String module;

	public TypeMultiple(String nom, String module) {
		this.nom = nom;
		this.module = module;
	}

	public void nom(String nom) {
		this.nom = nom;
	}

	public String nom() {
		if (module != null) {
			return module + "$" + nom;
		}
		return nom;
	}

	public String toString() {
		return "@" + nom();
	}

	public boolean estMultiple() {
		return true;
	}

	public void verifierSemantique(Univers u) {
		if (u.donnerType(nom()) == null) {
			u.erreurs.add(new ObjetInconnu(this));

		}

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {

		if (type instanceof TypeMultiple || type instanceof TypeSimple) {
			TypeDef td;

			String tp = type.toString();
			if (this.toString().equals(tp)) {
				return true;
			}
			do {
				td = u.donnerType(tp);
				if (td.superType == null) {
					return false;
				}
				if (td.superType().equals(nom())) {
					return true;
				}
				tp = td.superType();
			} while (true);

		}
		return false;

	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

	public void assignerModule(String nom) {
		if (this.module == null) {
			this.module = nom;
		}

	}

	public void donnerModules(Set<String> modules) {
		if (module != null) {
		modules.add(module); }
	}
	public Code creer(GestionNom gestionNom) {
		Objet r = new Objet();
		r.type = new TypeSimple("tpMultiple","metaModele");
		r.ajouterAttribut("nom",gestionNom.donnerNom(this.nom()));
		
		return r;

	}

}
