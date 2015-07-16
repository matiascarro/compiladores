package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;


public class AsignacionDiccionario extends Comm {

	Var nombreVariable;
	TEstructuradoDiccionario diccionario;
	
	public AsignacionDiccionario() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AsignacionDiccionario(Var nombreVariable,
			TEstructuradoDiccionario diccionario) {
		super();
		this.nombreVariable = nombreVariable;
		this.diccionario = diccionario;
	}

	


	public Var getNombreVariable() {
		return nombreVariable;
	}



	public void setNombreVariable(Var nombreVariable) {
		this.nombreVariable = nombreVariable;
	}



	public TEstructuradoDiccionario getDiccionario() {
		return diccionario;
	}



	public void setDiccionario(TEstructuradoDiccionario diccionario) {
		this.diccionario = diccionario;
	}



	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		
		Expr e = diccionario.evaluar(contexto);
		
		if(!(e instanceof TEstructuradoLista)) {
			throw new ExecutionException("Error de tipo, errores cuando se quiere asignar");
		}
		
		contexto.actualizarOCrearVariable(e, nombreVariable.getNombreVariable());
	}

}
