package com.language;

public class EstructuraLista {
	
	Expr e;
	EstructuraLista siguiente;


	public EstructuraLista(Expr e) {
		super();
		this.e = e;
		this.siguiente = null;
	}
	
	public EstructuraLista(Expr e, EstructuraLista siguiente) {
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

	public EstructuraLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(EstructuraLista siguiente) {
		this.siguiente = siguiente;
	}
}
