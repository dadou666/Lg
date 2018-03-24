package generer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.semantique.Element;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.ParseTree;

import grammaire.lgLexer;
import grammaire.lgParser;

public class TestParserUnitaire {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		//test("function m # { m:a  | if a is *t then u(a) else f(b #{ o:m | m}) } ");
//	test("function m # { m:a  |  *tot { a = m(x) b = #{ | l  o=|a } }   } ");
//	test(" type f {[l]->u:i t:o }  function m #{ o:o | m(o)  tu= [a]->t: l|l } ");
	//	test("   function m #{ o:o | tot [ { a= o } {a=p} {a = q} ] } ");
	//	test("   function m  o:o | f(o).mol | o ");
	test (" function m t:a |  m(z  @t  { } )");

	}

	static public void test(String src) {

		System.out.println(new Generateur().lireSource(src));

	}
	
	
	static public void testLogique(String src) {

		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);

		System.out.println(src + "->" + parser.system().toStringTree(parser));

	}

	static public void testFile(String file) throws IOException {

		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromFileName(file));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);

		System.out.println(parser.system().toStringTree(parser));

	}

	public static List<Element> lire(ParserRuleContext parser) {
		List<Element> ls = new ArrayList<Element>();
		for (int i = 1; i < parser.getChildCount(); i++) {
			ls.add(lireElement(parser.getChild(i)));
		}
		return null;
	}

	public static Element lireElement(ParseTree parser) {
		if (parser.getChildCount() > 0) {
			System.out.println("  " + parser.getChild(0).getText());

		}
		return null;

	}

	public static List<Element> lire(String file) throws IOException {
		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromFileName(file));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		return lire(parser.system());

	}

}
