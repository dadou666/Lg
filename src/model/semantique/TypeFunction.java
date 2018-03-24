package model.semantique;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TypeFunction extends TypeLiteral {
	public TypeLiteral retour;
	public TypeLiteral param;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");

		sb.append(param);
		sb.append(" ");

		sb.append("] ->");
		sb.append(retour);
		return sb.toString();

	}

	public void assignerModule(String nom) {
		retour.assignerModule(nom);
		param.assignerModule(nom);
	}

	public void donnerModules(Set<String> modules) {
		retour.donnerModules(modules);

		param.donnerModules(modules);

	}

	public void verifierSemantique(Univers u) {
		retour.verifierSemantique(u);

		param.verifierSemantique(u);

	}

	public boolean peutAccepter(Univers u, TypeLiteral type) {
		if (type instanceof TypeFunction) {
			TypeFunction tf = (TypeFunction) type;

			if (!param.peutAccepter(u, tf.param)) {
				return false;
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
		Objet obj = new Objet("metaModele", "tpFunction");
		obj.ajouterAttribut("tpReturn", this.retour.creer(gestionNom));
		obj.ajouterAttribut("param", param.creer(gestionNom));
		


		return obj;

	}
}
