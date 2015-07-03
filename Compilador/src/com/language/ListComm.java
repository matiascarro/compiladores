package com.language;

public class ListComm {

	Comm		sentencia;
	ListComm	siguiente;
	
	
	
	public ListComm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ListComm(Comm sentencia) {
		super();
		this.sentencia = sentencia;
		this.siguiente = null;
	}



	public ListComm(Comm sentencia, ListComm siguiente) {
		super();
		this.sentencia = sentencia;
		this.siguiente = siguiente;
	}
	public Comm getSentencia() {
		return sentencia;
	}
	public void setSentencia(Comm sentencia) {
		this.sentencia = sentencia;
	}
	public ListComm getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(ListComm siguiente) {
		this.siguiente = siguiente;
	}
	
	
}
