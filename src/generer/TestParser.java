package generer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Element;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.ParseTree;

import grammaire.lgLexer;
import grammaire.lgParser;

public class TestParser {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		test("type *hello { *a:o *m:m } ");
		test("function  nono  t:o  | chose  { t=m() u=s h=m.nono}  ");
		test("function nono   t:o | if o is nono then a() else (nunu {})  ");
		test("function nono  t:o | if o is nono then m(o) else nunu {} ");
		test("function nono  t:o | *alloc { m= if x is t then u  else h  } ");

		test("function nono  t:o | (if o is nono then m(o) else nunu {} ).take ");
		test(" type *a { te:a} type b {} ");
		test("function s    | m5[ {m=g } { m=j } ] ");
		test("function +   m:x |  x+this");
		test("function +  m:x | ( x+this )+f(this)");
		test("function +  m:x |( x+this )/(m-x)");
		test("function +  m:x | f($ u  785  $l 78)");
		test("function s | $ m 778  ");
		test(" function s  [a]->e:x | x(m)");
		test(" type a { [a u]->m:ok } ");
		test("function s m:a | a.u.o  ");
		test(" function s u:a |  m(#{t:u |t(u) })");
		test(" function s u:a |  m(#{t:u |t(u) })  ");
		testLogique ("predicat m t:x | All u:v [m]->m:u | p(x) is m");
		
		testLogique ("predicat m  t:x  | All u:v [m]->m:u | Exist m:u | p(x) is m");
		
		testLogique ("predicat m  t:x | All u:v [m]->m:u | Exist m:u | p(x) is m ");
		testLogique ("predicat m t:x | All u:v [m]->m:u | Exist m:u | p(x)+o is m ");
		//testFile("src\\metaModele.mdl");

	}

	static public void test(String src) {

		System.out.println( new Generateur().lireSource(src) );

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
