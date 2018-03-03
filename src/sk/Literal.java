package sk;

public class Literal extends Expression {
	public String value;
	public Literal(String value) {
		this.value = value;
	}
	public String toString() {
		return value;
	}
	public Expression toSK() {
		return this;
	}
	public boolean contains(String var) {
		return value.equals(var);
	}
}
