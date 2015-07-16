package com.language;

import java.util.Iterator;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class IfThen extends Comm{
	
	OperacionBooleana op;
	ListComm lc;

	public IfThen(OperacionBooleana o, ListComm l) {
		op = o;
		lc = l; 
	}
	
	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		Valor v = op.evaluar(contexto);
		
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
