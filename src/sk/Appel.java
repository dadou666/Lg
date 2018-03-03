package sk;

public class Appel extends Expression {
	public Expression a;
	public Expression b;

	public Appel(Expression a, Expression b) {
		this.a = a;
		if (b==null) {
			throw new Error();
		}
		this.b = b;
		

	}

	public String toString() {
		return "(" + a.toStringSansParenthese() + " " + b + ")";

	}

	public String toStringSansParenthese() {
		return a.toStringSansParenthese() + " " + b.toString();
	}
	public Expression toSK() {
		return new Appel(a.toSK(),b.toSK());
	}
	public boolean contains(String var) {
		return a.contains(var) | b.contains(var);
	}
}
