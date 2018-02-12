package model;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.tree.TerminalNode;

public class Const extends Element {
	private String nom;
	public Code value;
	public TerminalNode tn;
	public TypeLiteral tl;
	public boolean defType=false;
	public TypeLiteral tl(Univers u) {
		if (tl != null ) {
			return tl;
		}
		if (defType) {
			throw new Error(" constante "+nom);
		}
		defType = true;
		tl = value.typeRetour(u, new HashMap<String,TypeLiteral>(),new HashMap<String,FonctionLocal>());
		return tl;
	}
	public String nom() {
		if (nom == null) {
			nom= tn.getText();
		}
		return nom;
	}
	public String toString() {
		return " const "+nom() +" "+value;
	}
	public void init(Univers u) throws ErreurSemantique{
		if (u.constantes.get(nom()) != null) {
			throw new DoublonDeNom(nom(), this);
		}
		u.constantes.put(nom(),this);
		
		
	}
	public void verifierSemantique(Univers u) throws ErreurSemantique {
		
		Map<String,TypeLiteral> map = new HashMap<>();
		value.verifierSemantique(u, map);

	}
}
