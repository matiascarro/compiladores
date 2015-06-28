package com.language;

public class Asignacion extends Comm {

	Expr	e;
	String	nomVariable;
	
	
	


	public Asignacion(Expr e, String nomVariable) {
		super();
		this.e = e;
		this.nomVariable = nomVariable;
	}


	


	public Asignacion() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Expr getE() {
		return e;
	}





	public void setE(Expr e) {
		this.e = e;
	}





	public String getNomVariable() {
		return nomVariable;
	}





	public void setNomVariable(String nomVariable) {
		this.nomVariable = nomVariable;
	}





	@Override
	void evaluar(Contexto contexto) throws Exception {
		// TODO Buscar la variable a la cual queremos asignar el valor
		//e = c;
		Variable v = e.evaluar(contexto);
		v.setNombre(nomVariable);
		contexto.actualizarOCrearVariable(v);
		
		
	}

}
