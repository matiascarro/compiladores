package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class Estructurados extends Expr{
	
	Expr e;
	Estructurados siguiente;


	public Estructurados(Expr e) {
		super();
		this.e = e;
		this.siguiente = null;
	}
	
	public Estructurados(Expr e, Estructurados siguiente) {
		super();
		this.e = e;
		this.siguiente = siguiente;
	}

	public Expr getE() {
		return e;
	}

	public void setE(Expr e) {
		this.e = e;
	}

	public Estructurados getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Estructurados siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	Valor evaluar(Contexto contexto) throws ParsingException,
			ExecutionException {
		// TODO Auto-generated method stub
		
		return null;
	}


}
