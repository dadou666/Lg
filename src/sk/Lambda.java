package sk;

public class Lambda extends Expression {
	public String var;
	public Expression e;

	public Lambda(String var, Expression e) {
		this.var = var;
		this.e = e;
	}

	public String toString() {
		return var + "$" + e;
	}

	public Expression toSK() {
		
		if (e instanceof Appel) {
			Appel a = (Appel) e;
			if (e.contains(var)) {
				return Expression.appel(new S(), (new Lambda(var, a.a)).toSK(),
						(new Lambda(var, a.b)).toSK());
			}
		}
		
		if (e instanceof Literal) {
			Literal l = (Literal) e;
			if (l.value.equals(var)) {
				return new I();
			}
			return e;

		}
		if (e instanceof Lambda) {
			Lambda l =(Lambda) e;
			if (l.e.contains(var)) {
				return new Lambda(var,e.toSK()).toSK();
			}
			
		}
	
		return new Appel(new K(), e.toSK());

	}

	public boolean contains(String var) {
		if (this.var.equals(var)) {
			return false;
		}
		return e.contains(var);
	}

}
