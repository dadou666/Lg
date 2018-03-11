package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TypeFunction extends TypeLiteral {
	public TypeLiteral retour;
	public List<TypeLiteral> params = new ArrayList<>();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (TypeLiteral tp : params) {
			sb.append(tp);
			sb.append(" ");
		}
		sb.append("] ->");
		sb.append(retour);
		return sb.toString();

	}

	public void assignerModule(String nom) {
		retour.assignerModule(nom);
		for (TypeLiteral tl : params) {
			tl.assignerModule(nom);
		}
	}
public void donnerModules(Set<String> modules) {
	retour.donnerModules(modules);
	for(TypeLiteral tl:params) {
		tl.donnerModules(modules);
	}
	}
	public void verifierSemantique(Univers u) {
		retour.verifierSemantique(u);
		for (TypeLiteral tl : params) {
			tl.verifierSemantique(u);
		}

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {
		if (type instanceof TypeFunction) {
			TypeFunction tf = (TypeFunction) type;
			if (tf.params.size() != params.size()) {
				return false;

			}
			for (int i = 0; i < params.size(); i++) {
				if (!params.get(i).peutAccepter(u, tf.params.get(i))) {
					return false;
				}
			}
			if (retour.peutAccepter(u, tf.retour)) {
				return true;
			}

		}

		return false;

	}

	public TypeLiteral typeUnion(TypeLiteral tl, Univers u) {
		return null;
	}
	public Code creer(GestionNom gestionNom) {
		Objet obj = new Objet("metaModele","tpFunction");
		obj.ajouterAttribut("tpReturn", this.retour.creer(gestionNom));
		List<Code> ls = new ArrayList<Code>();
		for(TypeLiteral tl:this.params) {
			ls.add(tl.creer(gestionNom));
		}
		Objet tmp = new Objet("metaModele","lsTp","tp",ls,0);
		obj.ajouterAttribut("lsTp", tmp);
		
		
		
		return obj;

	}
}
