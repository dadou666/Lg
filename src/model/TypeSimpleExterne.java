package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeSimpleExterne extends TypeSimple {
	public TypeSimpleExterne(String nom,String module) {
		super(nom);
		this.module =module;
	}


	private String module;

	@Override
	public String nom() {


		return module+"$"+super.nom();
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
