package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class TEstructuradoLista extends Expr{
	
	Expr e;
	TEstructuradoLista siguiente;


	public TEstructuradoLista(Expr e) {
		super();
		this.e = e;
		this.siguiente = null;
	}
	
	public TEstructuradoLista(Expr e, TEstructuradoLista siguiente) {
		super();
		this.e = e;
		this.siguiente = siguiente;
	}

	public Expr getE() {
		return e;
	}

	public void setE(Expr e) {
		this.e = e;
	}

	public TEstructuradoLista getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(TEstructuradoLista siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	TEstructuradoLista evaluar(Contexto contexto) throws ParsingException,
			ExecutionException {
		// TODO Auto-generated method stub
		//No se si esto esta bien, pero lo que quiero hacer es llevar la lista a su minima expresion, por ejemplo, si 
		//en un nodo de la lista tenemos 5 + 3, que ponga 8, por ejemplo si tenemos 5 + a y a no está definida, explote!!!!
		TEstructuradoLista aux = this;
		while (aux!= null){
			aux.e = aux.e.evaluar(contexto);
			aux = aux.siguiente;
		}
		return this;
	}


}
