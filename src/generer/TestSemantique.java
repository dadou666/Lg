package generer;

import static org.junit.Assert.*;
import model.erreur.ErreurAccesChampInexistant;
import model.erreur.ErreurAttributAbsentDansCreer;
import model.erreur.ErreurSemantique;
import model.erreur.ErreurTypeNonCalculable;
import model.semantique.FonctionDef;
import model.semantique.FonctionLocal;
import model.semantique.ObjetInconnu;
import model.semantique.Univers;

import org.junit.Test;

public class TestSemantique {

	@Test
	public void testChampFonctionTypeInconnu() {
		ObjetInconnu es = test(" function f m:x | x", ObjetInconnu.class);
		assertEquals(es.ref.nomRef(), "m");
	}

	@Test
	public void testChampFonctionTypeOk() {
		test("type m {} function f m:x | x", null);

	}
	@Test
	public void testFonctionAvec2Parametre() {
		String s ="type @naturel {} function + naturel:a naturel:b | if a is @naturel then @naturel { next=a.next+b } else b ";
		test(s,null);
	}

	@Test
	public void testAttributInconnuDansFonction() {

		ErreurAccesChampInexistant es = test("type m {} function f m:x | x.o",
				ErreurAccesChampInexistant.class);
		assertEquals(es.acces.nomRef(), "o");

	}

	@Test
	public void testAttributOkDansFonction() {

		test("type t {} type m {t:o} function f m:x | x.o", null);

	}

	@Test
	public void testAttributOkPourRetourFonction() {

		test("type t {} type m {t:o} function f m:x | x function l m:x | f(x).o",
				null);

	}

	@Test
	public void testAttributOkDansFonctionDansSi() {

		test("type t:n {} type m:n {t:o} type n {}  function f n:x | if x is m then x.o else x",
				null);

	}

	@Test
	public void testTypeRetourFonctionNonCalculable() {

		test("type t {} type m:n {t:o} type n {}  function f n:x | if x is m then x.o else x",
				ErreurTypeNonCalculable.class);


	}

	@Test
	public void testAttributHeriteOkDansFonction() {

		test("type t {} type m {t:o} type n:m {}  function f n:x | x.o", null);

	}

	@Test
	public void testFunctionTypeArgsOk() {
		test("type t {} " + " function m  [t]->t:f t:x |  f(x) "
				+ " function z t:t | t  " + " function u t:t | m(z t)", null);

	}
	
	@Test 
	public void testFonctionAnonymeOk() {
		test("type t {} "+ " function m [t]->t:a t:r | a(r)  function u  t:a | m( #{ t:o | o } t {} ) ");
				
				
		
	}
	
	@Test 
	public void testFonctionAnonymeOk2() {
		test("type o:t {} type t {} "+ " function m [t]->t:a t:r | a(r)  function u  t:a | m( #{ o:o | o } o {} ) ");
				
				
		
	}

	
	@Test 
	public void testAccesNextTypeMultiple() {
		test(" type @t { } function u t:a | if a is @t then  a.next else a",null);
		
	}
	@Test 
	public void testAccesNextTypeMultipleDansSi() {
		test(" type @t { } function u t:a | if a is ! @t then  a else a.next",null);
		
	}
	@Test
	public void testTypeMultipleOk() {
		test(" type @t { } function u t:a | a "
				+ " function m  t:a| u(@t { next= t {}} ) ", null);
		test(" type @t { } function u t:a | a " + " function m t:t| u(t {} ) ",
				null);

	}
	@Test 
	public void testFctMultiArg() {
		test(" type a {} type b { } type c {} function f a:a b:b | c {} function u c:c | c function v a:a b:b | u(f(a b)) ");
		
	}
	
	@Test 
	public void testCalculTypeRetour() {
		
		String src="type @naturel {} function  red naturel:a naturel:b naturel:ib naturel:c |" +
		"	if a is !   @naturel  then " +
		"		c " +
		"	else if b is @naturel then" +
		" 	red(a.next b.next ib c)" +
		"		else" +
		"	red(a ib ib   @naturel { next=naturel {} } )" ; 
		Univers u=test(src);
		FonctionLocal fl = u.donnerFonction("red");
		assertTrue(fl.def.tlReturn.toString().equals("naturel"));
		 

	}
	@Test 
	public void testNextKo() {
		test("type @f {} function f  f:c| c.next",ErreurAccesChampInexistant.class);
		
	}
	@Test 
	public void testNextOk() {
		test("type @f {} function f  @f:c| c.next",null);
		
	}
	@Test
	public void testFonctionArgsOk() {
		test(" type @t { } function u [t]->t:f t:a | f(f(a)) ");
	}

	@Test
	public void testEntierOk() {
		test(" type @t { } function u t:a | a " + " function m  t:t| u(458t ) ",
				null);
	}
   
	@Test
	public void testFonctionLocalOk() {
		test(" type @t { } function u [t]->t:f t:a | f(a) "
				+ " function m t:t | u(#{ t:a | a } t {}) ", null);
	}

	@Test
	public void testNomFonctionInconnu() {
		ObjetInconnu es = test("type m {}  function f m:x | u(x)",
				ObjetInconnu.class);
		assertEquals(es.ref.nomRef(), "u");
	}

	@Test
	public void testNomFonctionOk() {
		test("type m {} function u m:x | x   function f m:x | u(x)", null);

	}

	@Test
	public void testCreerArgOk() {

		test("  type u {} " + "  function m u:x | x "
				+ " function  t u:u |  m(u { } ) ", null);

	}

	@Test
	public void testChampNextOk() {

		test(" type @u  {}  function u @u:a | a.next", null);
	}

	@Test
	public void testCreerIncomplet() {

		ErreurAttributAbsentDansCreer e = test(" type m {} "
				+ " type u { m:x } "

				+ " function  t u:u |  u { }  ",
				ErreurAttributAbsentDansCreer.class);
		assertEquals(e.nom, "x");

	}
	@Test 
	public void testCreationEntierSansType() {
		
		ObjetInconnu oi =test(" type a {} function f a:a | 45m ",ObjetInconnu.class);
		
		
	}
	
	@Test 
	public void testCurrification() {
		
		test(" type a {}  function f a:a a:b | a  function u  [a]->a:m  | m(a {} ) function v a:a |  u(f(a))");
	}
	@Test
	public void testCreerAvecAttributInexistant() {

		ObjetInconnu e = test(" type @a {} type m {} " + " type u { m:x } "

		+ " function  t m:x |  u { x=m {} o= 45a }  ", ObjetInconnu.class);

		assertEquals(e.ref.nomRef(), "o");

	}

	@Test
	public void testTypeUnionOk() {

		Univers u = test("type bool {}  type true:bool {} type false:bool { }  "
				+ "function not  bool:a | if a is true then false {} else true {} "
				+ "function u bool:t | not(not(true {} ))   ");

		FonctionLocal fd = u.donnerFonction("not");
		assertEquals(fd.def.tlReturn.toString(), "bool");

	}

	@Test
	public void testTypeUnionko() {

		test("type bool {}  type true:bool {} type false:bool { }  type a {} type b{} "
				+ "function f  bool:a | if a is true then a {} else b {} ",
				ErreurTypeNonCalculable.class);

	}

	public <T extends ErreurSemantique> T test(String src, Class<T> erreur) {

		Univers u = new Generateur().lireSourceUnivers(src);
		u.init();
		u.verifierSemantique();

		if (erreur == null) {
			if (u.erreurs.isEmpty()) {
				return null;
			}

			fail("  Aucune erreur attendu " + u.erreurs);

		}
		for (ErreurSemantique es : u.erreurs) {
			if (es.getClass() == erreur) {
				return (T) es;
			}
		}

		fail("Manque une erreur de type " + erreur);
		return null;

	}

	public Univers test(String src) {

		Univers u = new Generateur().lireSourceUnivers(src);
		u.init();
		u.verifierSemantique();

		if (u.erreurs.isEmpty()) {
			return u;
		}

		fail("  Aucune erreur attendu " + u.erreurs);
		return null;
	}
}
