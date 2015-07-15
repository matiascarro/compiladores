package com.language;

public class ListaExpr {

	Expr		expresion;
	ListaExpr	siguiente;
	
	
	public ListaExpr() {
		// TODO Auto-generated constructor stub
	}


	public ListaExpr(Expr expresion, ListaExpr siguiente) {
		super();
		this.expresion = expresion;
		this.siguiente = siguiente;
	}


	public Expr getExpresion() {
		return expresion;
	}


	public void setExpresion(Expr expresion) {
		this.expresion = expresion;
	}


	public ListaExpr getSiguiente() {
		return siguiente;
	}


	public void setSiguiente(ListaExpr siguiente) {
		this.siguiente = siguiente;
	}
	
	public int cantidadElementos(){
		ListaExpr aux = this;
		int ret = 1;
		
		while (aux.siguiente != null){
			ret++;
			aux = aux.siguiente;
		}
		return ret;
	}

}
