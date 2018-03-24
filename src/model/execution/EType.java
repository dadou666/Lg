package model.execution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EType {
	public String nom;
	public EType superType;
	public int debut;
	public int fin;
	public EAttribut [] attributs;
	public Map<String,EAttribut> map = new HashMap<String,EAttribut>();
	
	public List<EType> enfants;

}
