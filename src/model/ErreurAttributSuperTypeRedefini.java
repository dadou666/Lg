package model;

public class ErreurAttributSuperTypeRedefini extends ErreurSemantique {

	/**
	 * 
	 */
	private static final long serialVersionUID = -895121924568844494L;
	public Champ champ;
	public ErreurAttributSuperTypeRedefini(Champ champ) 
	{
		this.champ = champ;
	}
}
