package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class FuncionEjecutar extends Expr {
	
	Var 		nombreFuncion;
	ListaExpr 	parametros;

	public FuncionEjecutar() {
		// TODO Auto-generated constructor stub
	}

	@Override
	Expr evaluar(Contexto contexto) throws ParsingException, ExecutionException {
		// TODO Auto-generated method stub
		//buscar la funcion en el contexto
		//Chequear que la cantidad de parametros y variables sea la misma
		//sumar uno a globalScope
		//asignar a cada variable el valor del parametro en el contexto, tener ojo porque pueden ser listas, maps, etc.
		//(para el punto anterior fijarse en las asignaciones usando las clases que ya implementan asignacion de cada uno)
		//
		//sumar uno a scopeglobal
		//Pedir la lista de comm a la definición de ejecucion y ejecutar. Hay que tener cuidado con las llamadas return y break;
		return null;
	}

}
