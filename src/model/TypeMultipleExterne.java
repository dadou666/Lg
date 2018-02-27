package model;

public class TypeMultipleExterne extends TypeMultiple {
	public String module;

	public TypeMultipleExterne(String nom, String module) {
		super(nom);
		this.module = module;

	}

	@Override
	public String nom() {

		return "*" + module + "$" + nom;
	}

}
