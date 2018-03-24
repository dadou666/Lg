package generer;

import static org.junit.Assert.*;

import java.util.Set;

import model.erreur.ErreurSemantique;
import model.semantique.Univers;

import org.junit.Test;

public class TestSemantiqueImport {

	@Test
	public void test() {
		test(" function m mod$t:a | mod$u(a) "," type t {} function u t:a | a");

	}
	
	
	@Test
	public void testModules() {
		Univers u = new Generateur().lireSource("const o m6$r { }  type t { m3$a:a }  function h m1$a:a [m4$a]->t:a | m2$a { u= m5$f(a)  } ");
		Set<String> modules = u.modules();
		assertTrue(modules.contains("m6"));
		assertTrue(modules.contains("m5"));
		assertTrue(modules.contains("m4"));
		assertTrue(modules.contains("m3"));
		assertTrue(modules.contains("m2"));
		assertTrue(modules.contains("m1"));
		
		
		
		
		
	}
	public <T extends ErreurSemantique> T test(String src,String module, Class<T> erreur) {

		Univers u = new Generateur().lireSource(src);
		Univers umodule = new Generateur().lireSource(module);
		umodule.verifierSemantique();
		if (!umodule.erreurs.isEmpty()) {
			fail("Module erreur");
			return null;
		}
		
		
		u.ajouterImportModule("mod", umodule);
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

	public Univers test(String src,String module) {

		Univers u = new Generateur().lireSource(src);
		Univers umodule = new Generateur().lireSource(module);
		umodule.init();
		umodule.verifierSemantique();
		if (!umodule.erreurs.isEmpty()) {
			fail("Module erreur");
			return null;
		}
		u.ajouterImportModule("mod", umodule);
		u.init();
		u.verifierSemantique();

		if (u.erreurs.isEmpty()) {
			return u;
		}

		fail("  Aucune erreur attendu " + u.erreurs);
		return null;
	}
}
