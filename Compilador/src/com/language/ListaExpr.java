package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class ListaExpr extends Expr {

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


	@Override
	Expr evaluar(Contexto contexto) throws ParsingException, ExecutionException {

		ListaExpr aux = this;
		while(aux!=null){
			
			aux.expresion = aux.expresion.evaluar(contexto);
			aux = aux.siguiente;
		}
		
		return this;
	}
	
	public String toString(){
		ListaExpr aux = this;
		String ret = "";
		while(aux!=null){
			
			ret = ret + aux.expresion.toString();
			aux = aux.siguiente;
		}
		return ret;
	}

}
