package com.language;

public class Var extends Expr{

	String nombreVariable;
	
	@Override
	Variable evaluar(Contexto contexto) throws Exception {
		Variable v = contexto.buscarVariable(nombreVariable);
		if(v==null){
			throw new Exception("La variable "+ nombreVariable + " no existe en el scope");
		}
		
		return v;
	}

}
