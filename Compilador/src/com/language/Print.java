package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class Print extends Comm{
	
	Expr expresion;
	
	public Print(Expr e) {
		super();
		this.expresion = e;
	}

	
	
	
	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		Expr ep = expresion.evaluar(contexto);
			
		System.out.println(ep.print(contexto));
		
		
	}

}
