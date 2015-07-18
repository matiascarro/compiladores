package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class FuncionEjecutar extends Expr {
	
	Var 		nombreFuncion;
	ListaExpr 	parametros;

	public FuncionEjecutar() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FuncionEjecutar(Var nombreFuncion, ListaExpr parametros) {
		super();
		this.nombreFuncion = nombreFuncion;
		this.parametros = parametros;
	}



	@Override
	ListaExpr evaluar(Contexto contexto) throws ExecutionException {
		// TODO Auto-generated method stub
		//buscar la funcion en el contexto
		//Chequear que la cantidad de parametros y variables sea la misma
		//sumar uno a globalScope
		//asignar a cada variable el valor del parametro en el contexto, tener ojo porque pueden ser listas, maps, etc.
		//(para el punto anterior fijarse en las asignaciones usando las clases que ya implementan asignacion de cada uno)
		//
		//sumar uno a scopeglobal
		//Pedir la lista de comm a la definición de ejecucion y ejecutar. Hay que tener cuidado con las llamadas return y break;
		
		FuncionDef func = contexto.buscarFuncion(nombreFuncion.getNombreVariable());
		if(func == null){
			throw new ExecutionException("No existe la funcion");
		}
		if (parametros!=null){
			if((parametros.cantidadElementos() != func.getParametros().cantidadElementos())){
				throw new ExecutionException("Llamado con numero incorrecto de parametros");
			}
		}
		contexto.aumentarScope();
		ListaExpr auxL = parametros;
		ListaVar variables = func.getParametros();
		
		while (auxL!=null){
			contexto.actualizarOCrearVariable(auxL.getExpresion(), variables.getVariable().getNombreVariable());
			auxL = auxL.getSiguiente();
			variables = variables.getSiguiente();
		}
		ListComm lista = func.getSentencias();
		
		while((lista != null) && !(lista.getSentencia() instanceof FuncionReturn)){
			lista.getSentencia().evaluar(contexto);
			lista = lista.getSiguiente();
		}
		
		if(lista != null){
			if(lista.getSentencia() instanceof FuncionReturn){
				lista.getSentencia().evaluar(contexto);
				FuncionReturn f = (FuncionReturn)lista.getSentencia();
				contexto.eliminarVariablesDeScope();
				contexto.disminuirScope();
				return f.getRetorno();
			}
		}
		contexto.eliminarVariablesDeScope();
		contexto.disminuirScope();
		return null;
		
	}
	
	@Override
	public String print(Contexto contexto) throws ExecutionException{
		Expr e =  this.evaluar(contexto);
		return e.print(contexto);
				
	}

}
