package model.semantique;

import java.util.Set;

import model.execution.ECode;
import model.execution.EUniversDef;

public class AppelDebutFonction extends AppelBase implements Reference {
	public FonctionDef fd;
	@Override
	public String nomRef() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void donnerModules(Set<String> modules) {
		// TODO Auto-generated method stub
		fd.donnerModules(modules);
		
	}
	public void assignerModule(String nom) {
		
		fd.assignerModule(nom);

	}
	
	@Override
	public ECode compiler(Univers u, EUniversDef machine) {
		// TODO Auto-generated method stub
		return null;
	}

}
