package model.execution;

public class ELocal extends ECode {
	public int adr;
	
	public ECode calculer(ECode vars[]) {
		return vars[adr];

	}

}
