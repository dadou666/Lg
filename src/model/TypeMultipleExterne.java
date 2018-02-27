package model;

import org.antlr.v4.runtime.tree.TerminalNode;

public class TypeMultipleExterne extends TypeMultiple {
	public TerminalNode mn;

	public TypeMultipleExterne(TerminalNode tn,TerminalNode mn) {
		super(tn);
		this.mn = mn;
		
	}
	@Override
	public String nom() {
		if (nom == null) {
			nom ="*"+ mn.getText() + "$" + tn.getText();

		}

		return nom;
	}

}
