package com.language;

import com.language.exceptions.ParsingException;

public class Var extends Expr{

	String nombreVariable;
	
	@Override
	Valor evaluar(Contexto contexto) throws ParsingException {
		Valor v = contexto.buscarVariable(nombreVariable);
		if(v==null){
			throw new ParsingException("La variable "+ nombreVariable + " no existe en el scope");
		}
		
		return v;
	}

}
