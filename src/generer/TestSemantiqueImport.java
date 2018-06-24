package generer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.erreur.ErreurHeritageTypeAPINonPossible;
import model.erreur.ErreurSemantique;
import model.semantique.Univers;
import test.A;
import test.B;
import test.U;

import org.junit.Test;

public class TestSemantiqueImport {

	@Test
	public void test() {
		test(" function m mod$t:a | mod$u(a) ", " type t {} function u t:a | a");

	}

	@Test
	public void testAPI() {
		List<Class> classes = new ArrayList<Class>();
		classes.add(A.class);
		classes.add(B.class);
		classes.add(U.class);
		Map<String,String> sources = new HashMap<String,String>();
		sources.put("api.mdl", Generateur.genererTypes(classes));
		Univers u = this.test(" type D : api$A {} ", sources);
		List<ErreurHeritageTypeAPINonPossible> l=u.erreurs(ErreurHeritageTypeAPINonPossible.class); 
		assertTrue(!l.isEmpty());

	}
	@Test
	public void testAPIEmpty() {
		List<Class> classes = new ArrayList<Class>();
		classes.add(A.class);
		classes.add(B.class);
		classes.add(U.class);
		Map<String,String> sources = new HashMap<String,String>();
		sources.put("api.mdl", Generateur.genererTypes(classes));
		sources.put("main.mdl", " type D : api$A {} ");
		Univers u = this.test(" ", sources);
		List<ErreurHeritageTypeAPINonPossible> l=u.erreurs(ErreurHeritageTypeAPINonPossible.class); 
		assertTrue(!l.isEmpty());

	}

	@Test
	public void testModules() {
		Univers u = new Generateur().lireSourceUnivers(
				"const o m6$r { }  type t { m3$a:a }  function h m1$a:a [m4$a]->t:a | m2$a { u= m5$f(a)  } ");
		Set<String> modules = u.modules();
		assertTrue(modules.contains("m6"));
		assertTrue(modules.contains("m5"));
		assertTrue(modules.contains("m4"));
		assertTrue(modules.contains("m3"));
		assertTrue(modules.contains("m2"));
		assertTrue(modules.contains("m1"));

	}

	public <T extends ErreurSemantique> T test(String src, String module, Class<T> erreur) {

		Univers u = new Generateur().lireSourceUnivers(src);
		Univers umodule = new Generateur().lireSourceUnivers(module);
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

	public Univers test(String src, String module) {

		Univers u = new Generateur().lireSourceUnivers(src);
		Univers umodule = new Generateur().lireSourceUnivers(module);
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

	public Univers test(String src, Map<String, String> dependances) {
		Generateur gen = new Generateur();

		Univers u = gen.donnerUniversPourSource("courant", src, null, dependances);
		u.erreurs.addAll(gen.erreurs);
	
		return u;
	}
}
