package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class AsignacionLista extends Comm{

	Var nombre;
	TEstructuradoLista tel;

	
	public AsignacionLista(Var nombre, TEstructuradoLista tel) {
		super();
		this.nombre = nombre;
		this.tel = tel;
	}



	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		Expr e = tel.evaluar(contexto);
		
		if(!(e instanceof TEstructuradoLista)) {
			throw new ExecutionException("Error de tipo, errores cuando se quiere asignar");
		}
		
		contexto.actualizarOCrearVariable(e, nombre.getNombreVariable());
		
	}

	
}
