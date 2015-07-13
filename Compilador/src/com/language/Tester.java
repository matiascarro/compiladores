package com.language;

import com.language.model.expression.Expression;

public class Tester {

	public static void main(String[] args) {
		
		//String exptext = "19 * 3 + 3";
		String exptext = "s = 3;";
		
		Expression expobj = ExpressionParser.parse(exptext);
		//COMENTARIO
		
		System.out.println("Expresion obtenida: ");
		System.out.println(expobj.toString());
		
	}
	
}
