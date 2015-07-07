package com.language;

import com.language.exceptions.ParsingException;

public class Const extends Expr{

	Valor	v;//8
	
	
	
	public Const() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Const(Valor v) {
		super();
		this.v = v;
	}



	public Valor getV() {
		return v;
	}



	public void setV(Valor v) {
		this.v = v;
	}



	@Override
	Valor evaluar(Contexto contexto) throws ParsingException {
		return v;
	}

}
