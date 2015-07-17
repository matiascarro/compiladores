package com.language;

import java.util.Iterator;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class IfThenElse extends Comm{
	
	Expr op;
	ListComm lthen;
	ListComm lelse;

	public IfThenElse(Expr o, ListComm t, ListComm e) {
		op = o;
		lthen = t;
		lelse = e; 
	}
	
	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		if(!(op instanceof OperacionBooleana)){
			throw new ExecutionException("Expresion de while no es booleana");
		}
		
		Expr e = op.evaluar(contexto);
		
		Valor v = (Valor) e;
		
		ListComm aux;
		Comm sent;
		
		if (v.getTipo() == TipoValor.BOOL){
		
			if (v.isB()){
				
				aux = lthen;
				
				sent = aux.getSentencia();
				sent.evaluar(contexto);
				
				while (aux.getSiguiente() != null){
					aux = aux.getSiguiente();
					sent = aux.getSentencia();
					sent.evaluar(contexto);
				}
				
			} else {
				
				aux = lelse;
				
				sent = aux.getSentencia();
				sent.evaluar(contexto);
				
				while (aux.getSiguiente() != null){
					aux = aux.getSiguiente();
					sent = aux.getSentencia();
					sent.evaluar(contexto);
				}
			}
			
		} else {
			throw new ExecutionException("Tipo inv�lido - Sentencia if else");
		}
		
	}

}
