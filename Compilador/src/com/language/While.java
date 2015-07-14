package com.language;

import java.util.Iterator;

import com.language.exceptions.ExecutionException;

public class While extends Comm{
	
	OperacionBooleana op;
	ListComm lc;

	public While(OperacionBooleana o, ListComm l) {
		op = o;
		lc = l;
	}
	
	@Override
	void evaluar(Contexto contexto) throws Exception {
		// TODO Auto-generated method stub
		
		Valor v = op.evaluar(contexto);
		
		ListComm aux = lc;
		
		if (v.getTipo() == TipoValor.BOOL){
		
			while (v.isB()){
				Comm sent = aux.getSentencia();
				sent.evaluar(contexto);
				while (aux.getSiguiente() != null){
					aux = aux.getSiguiente();
					sent = aux.getSentencia();
					sent.evaluar(contexto);
				} 
				
				v = op.evaluar(contexto);
				
			}
		
		} else {
			throw new ExecutionException("Tipo inválido - Sentencia while");
		}
	}

}
