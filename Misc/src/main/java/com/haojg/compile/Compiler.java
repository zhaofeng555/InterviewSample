package com.haojg.compile;

public class Compiler {

	public static void main(String[] args) {
		Lexer lexer = new Lexer();
		//Parser parser = new Parser(lexer);
		//parser.statements();
		lexer.runLexer();
	}
}