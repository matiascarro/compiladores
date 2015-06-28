package com.language;

public class Asignacion extends Comm {

	Expr	e;
	Comm	c;
	
	
	public Asignacion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Asignacion(Expr e, Comm c) {
		super();
		this.e = e;
		this.c = c;
	}

	
	public Expr getE() {
		return e;
	}


	public void setE(Expr e) {
		this.e = e;
	}


	public Comm getC() {
		return c;
	}


	public void setC(Comm c) {
		this.c = c;
	}


	@Override
	void evaluar(Contexto contexto) {
		// TODO Buscar la variable a la cual queremos asignar el valor
		//e = c;
		c.evaluar(contexto);
		Variable v = e.evaluar(contexto);
		contexto.actualizarOCrearVariable(v);
		
		
	}

}
