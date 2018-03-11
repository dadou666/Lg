package generer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import model.Code;
import model.Univers;

import org.junit.Test;

public class TestMetaModele {

	@Test
	public void testTypeMetaModele() throws IOException {

		 test("type t {m:m } type m {} ");
		

	}

	@Test
	public void testChargementMetaModele() throws IOException {
		Generateur.metaModele();

	}

	public Univers test(String src, String module) {

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

	public Univers test(String src) throws IOException {

		Univers u = new Generateur().lireSource(src);
		u.init();
		u.creerMetaModele("main");
		
		u.verifierSemantique();

		if (u.erreurs.isEmpty()) {
			return u;
		}

		fail("  Aucune erreur attendu " + u.erreurs);
		return null;
	}
}
