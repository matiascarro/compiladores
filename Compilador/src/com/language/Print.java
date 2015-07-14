package com.language;

import com.language.exceptions.ExecutionException;

public class Print extends Comm{
	
	Expr expresion;
	
	public Print(Expr e) {
		super();
		this.expresion = e;
	}

	
	
	
	@Override
	void evaluar(Contexto contexto) throws Exception {
		// TODO Auto-generated method stub
		
		Valor v = expresion.evaluar(contexto);
		
		if (v.getTipo() == TipoValor.STRING){
			
			System.out.println(v.getS());
			
		} else {
			throw new ExecutionException("Valor inválido - Print");
		}
		
	}

}
