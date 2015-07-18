package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public abstract class Comm {
	
	int numeroLine;
	
	abstract void evaluar(Contexto contexto) throws ExecutionException,ParsingException;

	public int getNumeroLine() {
		return numeroLine;
	}

	public void setNumeroLine(int numeroLine) {
		this.numeroLine = numeroLine;
	}
	
	

}
