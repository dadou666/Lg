package model.semantique;

import java.util.List;

import model.execution.EUniversDef;

public class PredicatDef extends Element{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3152778725825415298L;
	public String nom;
	public List<Champ> params;
	public Predicat predicat;
	@Override
	public void compiler(String nomModule, EUniversDef machine, Univers u) {
		// TODO Auto-generated method stub
		
	}

}
