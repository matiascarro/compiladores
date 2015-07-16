package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class AsignacionLista extends Comm{

	Var nombre;
	Expr ex;

	
	public AsignacionLista(Var nombre, Expr e) {
		super();
		this.nombre = nombre;
		this.ex = e;
	}



	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		Expr e = ex.evaluar(contexto);
		
		if(!(e instanceof TEstructuradoLista)) {
			throw new ExecutionException("Error de tipo, errores cuando se quiere asignar");
		}
		
		contexto.actualizarOCrearVariable(e, nombre.getNombreVariable());
		
	}

	
}
