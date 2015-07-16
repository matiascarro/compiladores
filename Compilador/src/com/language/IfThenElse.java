package com.language;

import java.util.Iterator;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class IfThenElse extends Comm{
	
	OperacionBooleana op;
	ListComm lthen;
	ListComm lelse;

	public IfThenElse(OperacionBooleana o, ListComm t, ListComm e) {
		op = o;
		lthen = t;
		lelse = e; 
	}
	
	@Override
	void evaluar(Contexto contexto) throws ParsingException, ExecutionException  {
		// TODO Auto-generated method stub
		
		Valor v = op.evaluar(contexto);
		
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
