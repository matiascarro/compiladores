package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class AsignacionFuncion extends Comm {

	ListaVar	variables;
	ListaExpr	resultados;
	
	public AsignacionFuncion() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AsignacionFuncion(ListaVar variables, ListaExpr expresiones) {
		super();
		this.variables = variables;
		this.resultados = expresiones;
	}



	@Override
	void evaluar(Contexto contexto) throws ExecutionException, ParsingException {
		// TODO Auto-generated method stub
		if(variables.cantidadElementos() != resultados.cantidadElementos()){
			throw new ExecutionException("La funcione devuelve diferente cantidad de parametros que los que se quieren asignar");
		}
		while (resultados != null){
			contexto.actualizarOCrearVariable(resultados.getExpresion().evaluar(contexto), variables.getVariable().getNombreVariable());
		}

	}

}
