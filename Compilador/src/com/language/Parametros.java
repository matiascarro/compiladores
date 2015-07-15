package com.language;

public class Parametros {

	Var 		variable;
	Parametros	siguiente;
	
	
	public Parametros() {
		// TODO Auto-generated constructor stub
	}


	public Parametros(Var variable) {
		super();
		this.variable = variable;
		this.siguiente = null;
	}


	public Parametros(Var variable, Parametros siguiente) {
		super();
		this.variable = variable;
		this.siguiente = siguiente;
	}


	public Var getVariable() {
		return variable;
	}


	public void setVariable(Var variable) {
		this.variable = variable;
	}


	public Parametros getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(Parametros siguiente) {
		this.siguiente = siguiente;
	}
	
	
	
	
	
	

}
