package com.language;

public class OperacionesPredefinidas extends Comm{
	
	Expr variable; //es la variable a la que se le aplica la operacion, puede ser lista, diccionario, string
	Var nombreFuncion;
	Expr parametro1;
	Expr parametro2;
	
	
	public OperacionesPredefinidas(Expr variable, Var nombreFuncion,
			Expr parametro1, Expr parametro2) {
		super();
		this.variable = variable;
		this.nombreFuncion = nombreFuncion;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
	}



	@Override
	void evaluar(Contexto contexto)  {
		// TODO Auto-generated method stub
		// si variable no es lista o diccionario o string entonces error
		// hay que encontrar la variable en el contexto y que no sea null
		// si variable no existe tengo que dar error
	
	}
	
	

}
