package com.language;


public class Tester {

	public static void main(String[] args) {
		
		//String exptext = "19 * 3 + 3";
		String exptext = "s = 3; end";
		
		//Expression expobj = ExpressionParser.parse(exptext);
		//COMENTARIO
		
		Programa prog = ProgramaParser.parse(exptext);
		
		System.out.println("Expresion obtenida: ");
		//System.out.println(expobj.toString());
		
	}
	
}
