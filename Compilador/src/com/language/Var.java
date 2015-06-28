package com.language;

public class Var extends Expr{

	String nombreVariable;
	
	@Override
	Valor evaluar(Contexto contexto) throws Exception {
		Valor v = contexto.buscarVariable(nombreVariable);
		if(v==null){
			throw new Exception("La variable "+ nombreVariable + " no existe en el scope");
		}
		
		return v;
	}

}
