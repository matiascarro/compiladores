package com.language;

import com.language.exceptions.ExecutionException;
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
	Expr evaluar(Contexto contexto) throws ParsingException, ExecutionException {
		Expr ret = contexto.buscarVariable(nombreVariable);
		if(ret==null){
			throw new ParsingException("La variable "+ nombreVariable + " no existe en el scope");
		}
		if(!(ret instanceof Valor) &&  !(ret instanceof TEstructuradoLista)){
			throw new ExecutionException("Error en evaluar");
		}
		
		
		
		return ret;
	}


	@Override
	String print(Contexto contexto) throws ExecutionException {
		// TODO Auto-generated method stub
		return nombreVariable;
	}

}
