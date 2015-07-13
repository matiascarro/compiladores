package com.language;

import com.language.exceptions.ParsingException;

public class Var extends Expr{

	String nombreVariable;
	
	
	public Var() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Var(String nombreVariable) {
		super();
		this.nombreVariable = nombreVariable;
	}

	

	public String getNombreVariable() {
		return nombreVariable;
	}


	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}


	@Override
	Valor evaluar(Contexto contexto) throws ParsingException {
		Valor v = contexto.buscarVariable(nombreVariable);
		if(v==null){
			throw new ParsingException("La variable "+ nombreVariable + " no existe en el scope");
		}
		
		return v;
	}

}
