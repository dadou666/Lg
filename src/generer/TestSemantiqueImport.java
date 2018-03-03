package generer;

import static org.junit.Assert.*;
import model.ErreurSemantique;
import model.Univers;

import org.junit.Test;

public class TestSemantiqueImport {

	@Test
	public void test() {
		test(" function m mod$t:a | mod$u(a) "," type t {} function u t:a | a");

	}
	public <T extends ErreurSemantique> T test(String src,String module, Class<T> erreur) {

		Univers u = new Generateur().lireSource(src);
		Univers umodule = new Generateur().lireSource(module);
		umodule.verifierSemantique();
		if (!umodule.erreurs.isEmpty()) {
			fail("Module erreur");
			return null;
		}
		u.imports.put("mod", umodule);
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
		umodule.verifierSemantique();
		if (!umodule.erreurs.isEmpty()) {
			fail("Module erreur");
			return null;
		}
		u.imports.put("mod", umodule);
		umodule.assignerModule("mod");
		u.verifierSemantique();

		if (u.erreurs.isEmpty()) {
			return u;
		}

		fail("  Aucune erreur attendu " + u.erreurs);
		return null;
	}
}
