package com.language;

public class Programa {
	
	ListComm 			sentencias;
	Contexto			contexto;
	
	
	
	
	public Programa() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Programa(ListComm sentencias) {
		super();
		this.sentencias = sentencias;
		this.contexto = new Contexto();
	}
	
	
	
	public ListComm getSentencias() {
		return sentencias;
	}



	public void setSentencias(ListComm sentencias) {
		this.sentencias = sentencias;
	}



	public Contexto getContexto() {
		return contexto;
	}



	public void setContexto(Contexto contexto) {
		this.contexto = contexto;
	}
	
	public void imprimirContexto(){
		contexto.imprimir();
	}



	public void agregarSentencia(Comm s) {
		
	}
	
	public void ejecutarPrograma()
	{
		
	}
	
	

}
