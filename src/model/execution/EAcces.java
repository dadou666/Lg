package model.execution;

public class EAcces extends ECode {
	public ECode code;
	public int adr;
	public ECode getAttribute(int adr) {
		return code.getAttribute(adr);
	}

}
