package com.language;

import java.util.Iterator;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class While extends Comm{
	
	Expr op;
	ListComm lc;

	public While(Expr o, ListComm l) {
		op = o;
		lc = l;
	}
	
	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		Expr e = op.evaluar(contexto);
		
		Valor v = (Valor) e;
		
		if(!(v.getTipo() == TipoValor.BOOL)){
			throw new ExecutionException("Expresion de while no es booleana");
		}
		
		
		
		ListComm aux;
		
		if (v.getTipo() == TipoValor.BOOL){
		
			while (v.isB()){
				aux = lc;
				Comm sent = aux.getSentencia();
				sent.evaluar(contexto);
				while (aux.getSiguiente() != null){
					aux = aux.getSiguiente();
					sent = aux.getSentencia();
					sent.evaluar(contexto);
				} 
				
				e = op.evaluar(contexto);
				
				v = (Valor) e;
				
			}
		
		} else {
			throw new ExecutionException("Tipo inv�lido - Sentencia while");
		}
	}

}
