package model;

import java.util.List;

public class FonctionDef extends Code {
	public List<Champ> params;
	public Code code;
	public List<FonctionLocal> locals;
	public TypeLiteral tp;

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("#{");
		for (Champ champ : params) {
			sb.append(champ);
			sb.append(" ");
		}
		sb.append("|");
		sb.append(code);
		sb.append(" ");
		if (locals != null) {
			for (FonctionLocal local : locals) {

				sb.append(local);
				sb.append(" ");

			}
		}
		sb.append("}");
		return sb.toString();

	}
}
