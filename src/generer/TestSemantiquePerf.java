package generer;

import static org.junit.Assert.*;
import grammaire.lgLexer;
import grammaire.lgParser;

import java.io.IOException;

import model.Univers;

import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

public class TestSemantiquePerf {

	@Test
	public void test() throws IOException {
		testFile("entier.mdl");
	}
	@Test
	public void testMetaModele() throws IOException {
		testFile("metaModele.mdl");
	}
	 public void testFile(String file) throws IOException {

		Univers u = new Generateur().lireFichier(file);
		u.init();
		u.verifierSemantique();
		System.out.println(" "+u.erreurs);
	}
}
