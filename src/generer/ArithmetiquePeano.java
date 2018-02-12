package generer;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.tree.ParseTree;

import grammaire.lgLexer;
import grammaire.lgParser;

public class ArithmetiquePeano {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		new Generateur().lireFichier("src\\arithmetiquePeano.txt");
		
		
	}
	static public void  test(String src) {

		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromString(src));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		
		 System.out.println(src +"->" +parser.system().toStringTree(parser));
		
	}
	
	static public void  testFile(String file) throws IOException {

		lgLexer lgLexer = new lgLexer(
				org.antlr.v4.runtime.CharStreams.fromFileName(file));
		CommonTokenStream tokens = new CommonTokenStream(lgLexer);
		lgParser parser = new lgParser(tokens);
		
		 System.out.println(parser.system().toStringTree(parser));
		
	}

}
