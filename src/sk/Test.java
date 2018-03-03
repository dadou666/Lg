package sk;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Expression mul = Expression.appel(Expression.literal("*"),
				Expression.literal("x"), Expression.literal("y"));
		Lambda l = Expression.lambda(
				"x",
				Expression.lambda(
						"y",
						Expression.appel(Expression.literal("+"),
								Expression.literal("x"), mul)

				));
		System.out.println(l);
		System.out.println(l.toSK());
		l = Expression.lambda(
				"x",
				Expression.lambda(
						"y",
						Expression.appel(Expression.literal("+"),
								Expression.literal("x"), 	Expression.literal("y"))

				));
		System.out.println(l);
		System.out.println(l.toSK());
		
		l = Expression.lambda(
				"x",
				Expression.lambda(
						"y",
						Expression.appel(
								Expression.literal("y"), 	Expression.literal("x"))

				));
		System.out.println(l);
		System.out.println(l.toSK());
	}

}
