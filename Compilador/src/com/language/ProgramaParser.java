package com.language;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

import java_cup.runtime.Symbol;

import com.language.exceptions.ParsingException;

public class ProgramaParser {

	
	
	public static void main(String[] args) {

		Reader reader = null;
		
		try {
			
			if (args.length == 1) {
				File input = new File(args[0]);
		      	if (!input.canRead()) {
		    	  System.out.println("Error: could not read ["+input+"]");
		      	}
		      	reader = new FileReader(input);
		    }else {  
		    	System.out.println("Error: could not read ");
		    }
			Scanner scanner = new Scanner(reader);
			Parser parser = new Parser(scanner);
			Symbol topsym = parser.parse();
			Programa prog = (Programa) topsym.value;
			prog.ejecutarPrograma();

		} catch (ParsingException ex) {
			System.out.println(ex.getMessage() +  Scanner.getGlobalLine());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + Scanner.getGlobalLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + Scanner.getGlobalLine());
		}

	}
		
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
