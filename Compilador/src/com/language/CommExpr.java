package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class CommExpr extends Comm {

	Expr	expresion;
	
	public CommExpr() {
		// TODO Auto-generated constructor stub
	}
	

	public CommExpr(Expr expresion) {
		super();
		this.expresion = expresion;
	}


	
	public Expr getExpresion() {
		return expresion;
	}


	public void setExpresion(Expr expresion) {
		this.expresion = expresion;
	}


	@Override
	void evaluar(Contexto contexto) throws ExecutionException, ParsingException {
		// TODO Auto-generated method stub
		if(!(expresion instanceof OperacionesPredefinidas) && !(expresion instanceof FuncionEjecutar)){
			throw new ExecutionException("CommExpr es solamente una OperacionPredefinida o una FuncionEjecutar");
		}
		expresion.evaluar(contexto);
	}

}
