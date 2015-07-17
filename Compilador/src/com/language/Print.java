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
		
		if(!(ep instanceof Valor)){
			throw new ExecutionException("Error de tipo, errores cuando se quiere asignar");
		}
		
		
		Valor v = (Valor)ep;
		
		System.out.println("acas");
		
		if (v.getTipo() == TipoValor.STRING){
			
			System.out.println(v.getS());
			
		} else {
			throw new ExecutionException("Valor invalido - Print");
		}
		
	}

}
