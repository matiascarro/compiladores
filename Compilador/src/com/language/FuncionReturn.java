package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class FuncionReturn extends Comm {

	ListaExpr	retorno;
	
	public FuncionReturn() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public FuncionReturn(ListaExpr retorno) {
		super();
		this.retorno = retorno;
	}





	public ListaExpr getRetorno() {
		return retorno;
	}



	public void setRetorno(ListaExpr retorno) {
		this.retorno = retorno;
	}



	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		ListaExpr l = retorno;
		
		while(l!=null){
			l.setExpresion(l.getExpresion().evaluar(contexto));
			l.setSiguiente(l.getSiguiente());
		}
		

	}

}
