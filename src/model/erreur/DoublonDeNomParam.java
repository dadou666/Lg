package model.erreur;

import model.Champ;

public class DoublonDeNomParam extends ErreurSemantique {
  public Champ champ;
	public DoublonDeNomParam(Champ champ) {
		this.champ = champ;

	}


	private static final long serialVersionUID = 1L;

}
