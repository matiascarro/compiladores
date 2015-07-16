package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public abstract class Comm {
	
	abstract void evaluar(Contexto contexto) throws ExecutionException,ParsingException;
	

}
