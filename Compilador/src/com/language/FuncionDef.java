package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class FuncionDef extends Comm {
	
	Var				nombreFuncion;
	ListaVar		parametros;
	ListComm		sentencias;
	
	public FuncionDef() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FuncionDef(Var nombreFuncion, ListaVar parametros, ListComm sentencias) {
		super();
		this.nombreFuncion = nombreFuncion;
		this.parametros = parametros;
		this.sentencias = sentencias;
	}
	
	



	public Var getNombreFuncion() {
		return nombreFuncion;
	}



	public void setNombreFuncion(Var nombreFuncion) {
		this.nombreFuncion = nombreFuncion;
	}



	public ListaVar getParametros() {
		return parametros;
	}



	public void setParametros(ListaVar parametros) {
		this.parametros = parametros;
	}



	public ListComm getSentencias() {
		return sentencias;
	}



	public void setSentencias(ListComm sentencias) {
		this.sentencias = sentencias;
	}



	@Override
	void evaluar(Contexto contexto) throws ParsingException,
			ExecutionException {
		// TODO Auto-generated method stub
		//Guarda la funcion en una lista de funciones
		contexto.guardarFuncion(nombreFuncion.getNombreVariable(),this);
	}

}
