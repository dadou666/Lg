package generer;

import static org.junit.Assert.*;
import model.ErreurAccesChampInexistant;
import model.ErreurAttributAbsentDansCreer;
import model.ErreurSemantique;
import model.ErreurTypeNonCalculable;
import model.ObjetInconnu;
import model.Univers;

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
		try {
			test("type t {} type m:n {t:o} type n {}  function f n:x | if x is m then x.o else x",
					null);
		} catch (ErreurTypeNonCalculable erreur) {
			return;
		}
		fail("ErreurTypeNonCalculable attendu ");

	}

	@Test
	public void testAttributHeriteOkDansFonction() {

		test("type t {} type m {t:o} type n:m {}  function f n:x | x.o", null);

	}
	
	@Test 
	public void testFunctionTypeArgsOk() {
		test("type t {} "
				+ " function m  [t]->t:f t:x |  f(x) "
				+ " function z t:t | t  "
				+ " function u t:t | m(z t)",null);
		
		
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
		
		test( "  type u {} "
				+ "  function m u:x | x "
				+ " function  t |  m(u { } ) ",null);
		
	}
	
	@Test 
	public void testCreerIncomplet() {
		
		ErreurAttributAbsentDansCreer e=	test( " type m {} "
				+ " type u { m:x } "
			
				+ " function  t |  u { }  ",ErreurAttributAbsentDansCreer.class);
		assertEquals(e.nom, "x");
		
	}
	
	@Test 
	public void testCreerAvecAttributInexistant() {
		
		ObjetInconnu e=	test( " type m {} "
				+ " type u { m:x } "
			
				+ " function  t |  u { x=m {} o= 45a }  ",ObjetInconnu.class);
		
		assertEquals(e.ref.nomRef(), "o");
		
	}
	public <T extends ErreurSemantique> T test(String src, Class<T> erreur) {

		Univers u = new Generateur().lireSource(src);
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
}
