package generer;

import static org.junit.Assert.*;

import java.util.HashMap;

import model.execution.EContext;
import model.execution.EUniversDef;
import model.semantique.Code;
import model.semantique.TypeLiteral;
import model.semantique.Univers;

import org.junit.Test;

public class TestCompiler {

	@Test
	public void testAppelFonction() {
		EContext ctx =compiler("type u { t:t } type t {}  function m t:t | u { t=t  } "," ( m(t {} ) )");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==1);
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		String r = ctx.toString();
		assertTrue(r.equals("u{ t=t{ } }"));
	}

	@Test
	public void testAppelFonctionCurryFication() {
		EContext ctx =compiler("type u { t:a t:b} type t {} function g [t]->u:o t:m | o(m)  function m t:a t:b| u { a=a b=b } "," g( m(t {} ) t {} ) ");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==2);
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		String r = ctx.toString();
		assertTrue(r.equals("u{ a=t{ } b=t{ } }"));
	}
	@Test
	public void testAppelFonctionEtAcces() {
		EContext ctx =compiler("type u { t:t } type t {}  function m t:t | u { t=t  } "," ( m(t {} ) ).t");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==1);
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		String r = ctx.toString();
		assertTrue(r.equals("t{ }"));
	}
	
	@Test
	public void testSi() {
		EContext ctx =compiler("type bool {} type true:bool {} type false:bool {}  function not bool:b | if b is true then false {} else true {} "," not(true {} )");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==1);
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		String r = ctx.toString();
		assertTrue(r.equals("false{ }"));
	}
	public EContext compiler(String src, String expression) {
		Generateur g = new Generateur();
		if (g.error) {
			fail(" error syntaxe univers");
		}
		Univers u = g.lireSourceUnivers(src);
		u.init();
		u.verifierSemantique();

		if (!u.erreurs.isEmpty()) {

			fail("  Aucune erreur attendu " + u.erreurs);

		}
		 g = new Generateur();
		Code code = g.lireSourceCode(expression);
		if (g.error) {
			fail(" error syntaxe code");
		}
		code.verifierSemantique(u, new HashMap<String, TypeLiteral>());
		if (!u.erreurs.isEmpty()) {

			fail("  Aucune erreur attendu " + u.erreurs);

		}

		EUniversDef univers = new EUniversDef();
		u.compiler(null, univers);
		univers.init();
		EContext context = new EContext();
		context.univers =univers;
		context.code = code.compiler(u, univers);
		

		return context;
	}

}
