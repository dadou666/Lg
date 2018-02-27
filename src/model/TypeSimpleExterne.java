package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeSimpleExterne extends TypeBasic {
	public TerminalNode mn;
	public TerminalNode tn;
	private String nom;

	@Override
	public String nom() {
		if (nom == null) {
			nom = mn.getText() + "$" + tn.getText();

		}

		return nom;
	}

	@Override
	public void nom(String nom) {
		// TODO Auto-generated method stub

	}
	
	public String toString() {
		return nom();
	}

	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return nom();
	}

}
