package generer;

import static org.junit.Assert.*;

import java.util.HashMap;

import model.execution.EContext;
import model.execution.EEntier;
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
	public void testAppelFonctionAvecAccesAtribut() {
		EContext ctx =compiler("type @n {}  type  a { [n]->n:f  }  function o a:a n:n | a.f(n)   ","o(a { f=#{n:n | @n {next=n }}} 5n) ");
		assertTrue(ctx.univers.fonctionArray != null);
	//	assertTrue(ctx.univers.fonctionArray .length==2);
		System.out.println(" code="+ctx);
		ctx.calculer();
		ctx.calculer();
		System.out.println(" code="+ctx);
		
	}
	
	@Test
	public void testAppelFonctionEtAcces() {
		EContext ctx =compiler("type u { t:t } type t {}  function m t:t | u { t=t  } "," ( m(t {} ) ).t");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==1);
		System.out.println(" code="+ctx);
		ctx.calculer();
		ctx.calculer();
		System.out.println(" code="+ctx);
		String r = ctx.toString();
		assertTrue(r.equals("t{ }"));
	}
	
	@Test
	public void testAppelEntierNext() {
		EContext ctx =compiler("type @n { }  "," 45n.next");
	
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		
		assertTrue(ctx.toString().equals("44n"));
	}
	
	@Test
	public void testAppelCompilerFonction() {
		EContext ctx =compiler("type @n { }  "," # { @n:a | a.next }");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==1);
		System.out.println(" code="+ctx);
		
	}
	@Test
	public void testAppelCompilerAppelFonctionAnonype() {
		EContext ctx =compiler("type @n { }  "," # { @n:a | a.next } ( 4n )");
		assertTrue(ctx.univers.fonctionArray != null);
		assertTrue(ctx.univers.fonctionArray .length==1);
		ctx.calculer();
		System.out.println(" code="+ctx);
		
	}
	
	@Test
	public void testAppelEntierNew() {
		EContext ctx =compiler("type @n { }  "," @n { next= 45n }");
	
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		
		assertTrue(ctx.toString().equals("46n"));
	}
	@Test 
	public void testCalculSymbolic() {
		EContext ctx =compiler("type @n { }  "," #{ n:x | if x is n then n {} else 45n }");
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		
		
	}
	@Test 
	public void testCalculSymbolic2() {
		EContext ctx =compiler("type @n { }  "," #{ n:x | #{ n:x | if x is @n then @n {next=x} else 45n }(@n {next=x})}");
		System.out.println(" code="+ctx);
		ctx.calculer();
		System.out.println(" code="+ctx);
		
		
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
		
	

		if (!u.erreurs.isEmpty()) {

			fail("  Aucune erreur attendu " + u.erreurs);

		}
		 g = new Generateur();
		Code code = g.lireSourceCode(expression);
		g.ajouterFonctionAnonyme(u);
		u.init();
		u.verifierSemantique();
	
		if (g.error) {
			fail(" error syntaxe code");
		}
		code.verifierSemantique(u, new HashMap<String, TypeLiteral>());
		if (!u.erreurs.isEmpty()) {

			fail("  Aucune erreur attendu " + u.erreurs);

		}

		EUniversDef univers = new EUniversDef();
		u.compiler(null, univers);
		
		EContext context = new EContext();
		context.univers =univers;
		context.code = code.compiler(u, univers);
		univers.init();

		return context;
	}

}
