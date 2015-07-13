package com.language;

import java.io.ByteArrayInputStream;

import java_cup.runtime.Symbol;

import com.language.exceptions.ParsingException;

public class ProgramaParser {

	
		
	public static Programa parse(String expText) {

		byte[] expbytes = expText.getBytes();
		ByteArrayInputStream bais = new ByteArrayInputStream(expbytes);

		Scanner s = new Scanner(bais);
		Parser parser = new Parser(new Scanner(bais));
		
		try {
			
			Symbol topsym = parser.parse();
			Programa prog = (Programa) topsym.value;
			return prog;

		} catch (Throwable ex) {
			throw new ParsingException("Error parsing source: " + ex.getMessage());
		}

	}
	

}
