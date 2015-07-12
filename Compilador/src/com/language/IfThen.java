package com.language;

import java.util.Iterator;

public class IfThen extends Comm{
	
	OperacionBooleana op;
	ListComm lc;

	public IfThen(OperacionBooleana o, ListComm l) {
		op = o;
		lc = l; 
	}
	
	@Override
	void evaluar(Contexto contexto) throws Exception {
		// TODO Auto-generated method stub
		
		Valor v = op.evaluar(contexto);
		
		ListComm aux = lc;
		
		if (v.isB()){
			Comm sent = aux.getSentencia();
			sent.evaluar(contexto);
			while (aux.getSiguiente() != null){
				aux = aux.getSiguiente();
				sent = aux.getSentencia();
				sent.evaluar(contexto);
			}
			
		}
		
	}

}
