package model;

import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Var extends Code implements Reference {
	private String nom;
	public TerminalNode tn;
	public String toString() {
		return nom();
	}
	public String nom() {
		if (nom == null) {
			 nom = tn.getText();
		}
		return nom;
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
			FonctionLocal fl = u.fonctions.get(nom());
			if (fl != null) {
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
