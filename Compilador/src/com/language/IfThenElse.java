package com.language;

import java.util.Iterator;

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
	void evaluar(Contexto contexto) throws Exception {
		// TODO Auto-generated method stub
		
		Valor v = op.evaluar(contexto);
		
		ListComm aux;
		Comm sent;
		
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
		
	}

}
