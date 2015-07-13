package com.language;

public class Asignacion extends Comm {

	Expr	e;
	Var		nomVariable;
	
	
	


	public Asignacion(Expr e, Var nomVariable) {
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





	public Var getNomVariable() {
		return nomVariable;
	}





	public void setNomVariable(Var nomVariable) {
		this.nomVariable = nomVariable;
	}





	@Override
	void evaluar(Contexto contexto) throws Exception {
		// TODO Buscar la variable a la cual queremos asignar el valor
		//d = 8 //Asignacion(Const(8))
		
		Valor v = e.evaluar(contexto);
		
		contexto.actualizarOCrearVariable(v,nomVariable.getNombreVariable());
		
		
	}

}
