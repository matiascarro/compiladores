package com.language;

import com.language.exceptions.ParsingException;

abstract public class Expr {

	abstract Valor evaluar(Contexto contexto) throws ParsingException;
	
	

}
