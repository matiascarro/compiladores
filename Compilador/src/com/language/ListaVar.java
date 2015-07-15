package com.language;

public class ListaVar {
	
	Var 		variable;
	ListaVar 	siguiente;

	public ListaVar() {
		// TODO Auto-generated constructor stub
		siguiente = null;
	}

	public ListaVar(Var variable, ListaVar siguiente) {
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

	public ListaVar getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(ListaVar siguiente) {
		this.siguiente = siguiente;
	}
	
	public int cantidadElementos(){
		ListaVar aux = this;
		int ret = 1;
		
		while (aux.siguiente != null){
			ret++;
			aux = aux.siguiente;
		}
		return ret;
	}
	
	

}
