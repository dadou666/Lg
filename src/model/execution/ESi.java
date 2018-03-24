package model.execution;

public class ESi extends ECode {
	public ECode test;
	public EType type;
	public ECode alors;
	public ECode sinon;
	public ECode calculer(ECode vars[]) {
		EType typeTest = test.calculer(vars).type();
		if (typeTest.debut>= type.debut && typeTest.fin <= type.fin) {
			return alors.calculer(vars);
		}
		return sinon.calculer(vars);
		

	}

}
