package com.language;

import java.util.Iterator;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class IfThen extends Comm{
	
	Expr op;
	ListComm lc;

	public IfThen(Expr o, ListComm l) {
		op = o;
		lc = l; 
	}
	
	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		if(!(op instanceof OperacionBooleana)){
			throw new ExecutionException("Expresion de while no es booleana");
		}
		
		Expr e = op.evaluar(contexto);
		
		Valor v = (Valor) e;
		
		ListComm aux = lc;
		
		if (v.getTipo() == TipoValor.BOOL){
			
			if (v.isB()){
				Comm sent = aux.getSentencia();
				sent.evaluar(contexto);
				while (aux.getSiguiente() != null){
					aux = aux.getSiguiente();
					sent = aux.getSentencia();
					sent.evaluar(contexto);
				}
				
			}
		
		} else {
			throw new ExecutionException("Tipo inv�lido - Sentencia if");
		}
	}

}
