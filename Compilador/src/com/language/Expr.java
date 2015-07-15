package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

abstract public class Expr {

	abstract Expr evaluar(Contexto contexto) throws ParsingException, ExecutionException;
	
	

}
