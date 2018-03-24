package generer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Map;

import model.semantique.Code;
import model.semantique.Const;
import model.semantique.Objet;
import model.semantique.Univers;

import org.junit.Test;

public class TestMetaModele {

	
	@Test
	public void testTypeMetaModeleAcces() throws IOException {

		 test("type t {m:m } type m {}  function o  | %main$t.tp ");
		 

		

	}
	
	@Test
	public void testTypeMetaModeleFunctionArg() throws IOException {

		 test("type t {m:m } type m {} function s metaModele$typeDef:t | t.tp  function o  | s(%main$t) ");
		 

		

	}
	
	@Test
	public void testFunctionMetaModeleFunctionArg() throws IOException {

		 test("type t {m:m } type m {}  function s metaModele$functionDef:t | t.champs  function o  | s(%main$s) ");
		 

		

	}
	
	
	@Test
	public void testConstanteMetaModeleFunctionArg() throws IOException {

		 test("const o t {m=m{} } type t {m:m } type m {}  function s metaModele$constante:t | t.code  function o  | s(%main$o) ");
		 

		

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
