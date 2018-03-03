package sk;

public class Expression {
	public String toStringSansParenthese() {
		return this.toString();
	}
	public boolean contains(String var) {
		return false;
	}
	public static Expression appel(Expression... args) {

	

		Expression tmp = args[0];
		for (int i = 1; i < args.length; i++) {
			tmp = new Appel(tmp, args[i]);
		}
		return tmp;

	}

	public static Lambda lambda(String var, Expression e) {
		return new Lambda(var, e);

	}
	public static Literal literal(String val) {
		return new Literal(val);
	}
	public Expression toSK() {
		return this;
	}
	
}
