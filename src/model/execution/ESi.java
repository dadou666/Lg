package model.execution;

public class ESi extends ECode {
	public ECode test;
	public int idx;
	public ECode alors;
	public ECode sinon;

	public ECode calculer(ECode vars[], EUniversDef machine) {
		ETypeObjet typeTest = test.calculer(vars, machine).type(machine);
		ETypeObjet type = machine.typeArray[idx];
		if (typeTest.debut >= type.debut && typeTest.fin <= type.fin) {
			return alors.calculer(vars, machine);
		}
		return sinon.calculer(vars, machine);

	}

	@Override
	public ECode getAttribute(int adr, EUniversDef machine) {
		throw new Error("getAttribute");
	}

	@Override
	public ETypeObjet type(EUniversDef machine) {
		throw new Error("type");
	}

	@Override
	public String afficher(EUniversDef univers) {
		ETypeObjet eto = univers.typeArray[idx];
		StringBuilder sb = new StringBuilder();
		sb.append("if");
		sb.append(" ");
		sb.append(test.afficher(univers));
		sb.append(" is ");
		sb.append(eto.nom);
		sb.append(" then ");
		sb.append(alors.afficher(univers));
		sb.append(" else ");
		sb.append(sinon.afficher(univers));
		return sb.toString();

	}

}
