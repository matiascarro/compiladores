package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class TEstructuradoLista extends Expr{
	
	Expr e;
	TEstructuradoLista siguiente;

	
	
	public TEstructuradoLista() {
		super();
	}

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
	
	public Expr ejecutarFuncion(Var nombreFuncion, Expr p1, Expr p2) throws ExecutionException{
		
		Valor v = null; //new Valor(0, "", -1, true, 0, TipoValor.INT);
		
		if ((nombreFuncion.getNombreVariable() != "size") && (p1 == null)){
			throw new ExecutionException("Parametro vacio en ejecutarFuncion");
		}
		if ((nombreFuncion.getNombreVariable() == "insert") && (p2 == null)){
			throw new ExecutionException("Parametro vacio en ejecutarFuncion");
		}
		
		if ((p1 != null) && (!(p1 instanceof Valor)&&!(p1 instanceof TEstructuradoLista))){
			throw new ExecutionException("Parametro de tipo invalido en ejecutarFuncion");
		}
		
		if ((p2 != null) && (!(p2 instanceof Valor)&&!(p2 instanceof TEstructuradoLista))){
			throw new ExecutionException("Parametro de tipo invalido en ejecutarFuncion");
		}
		
		TEstructuradoLista t = null;
		TEstructuradoLista aux = null;
		TEstructuradoLista nueva = null;
		Valor val;
		Valor valaux;
		boolean encontre;
		int cant;
		int cantaux;
		
		switch (nombreFuncion.getNombreVariable()) {
		case "append":
			
			t = new TEstructuradoLista(p1, null);
			
			aux = this;
			
			while (aux.getSiguiente() != null){
				
				aux = aux.siguiente;
				
			}
			
			aux.siguiente = t;
				
			break;
			
		case "count":
			// solo implementado para tipos valor
			
			if (p1 instanceof Valor){
			
				aux = this;
				
				cant = 0;
				
				while (aux != null){
					
					if (aux.e instanceof Valor){
						val = (Valor) aux.e;
						
						if (val.esIgual((Valor) p1)){
							cant++;
						}
					}
						
					aux = aux.siguiente;
					
				}
				
				v = new Valor(0, "", cant, true, 0, TipoValor.INT);
				
			}
			
			break;
			
		case "extend":
			//implementado para listas con elementos solo tipo valor
			
			if (p1 instanceof TEstructuradoLista)
				
			aux = this;
			
			while (aux.getSiguiente() != null){
				
				aux = aux.siguiente;
				
			}
			
			t = (TEstructuradoLista) p1;
			
			while (t != null) {
				
				if (!(t.getE() instanceof Valor)){
					throw new ExecutionException("Error en funcion extend");
				}
				
				valaux = (Valor) t.getE();
				
				val = new Valor(valaux.getF(), valaux.getS(), valaux.getI(), valaux.isB(), valaux.getL(), valaux.getTipo());
				
				nueva = new TEstructuradoLista(val);

				aux.siguiente = nueva;
				
				aux = aux.siguiente;
				
				t = t.siguiente;
				
			}
			
			
			break;
			
		case "index":
			//solo para valores
			
			if (p1 instanceof Valor){
				
				// caso de dos parametros
				if ((p2 != null)&&(p2 instanceof Valor)){
					
					valaux = (Valor) p2;
					
					if (valaux.getTipo() != TipoValor.INT){
						throw new ExecutionException("Error de tipos en funcion index");
					}
					
					cantaux = valaux.getI();
					aux = this;
					cant = 0;
					encontre = false;
					while ((aux != null)&&(!encontre)){
						cant++;
						if (aux.e instanceof Valor){
							val = (Valor) aux.e;
							if ((val.esIgual((Valor) p1))&&(cant>=cantaux)){
								encontre = true;
							}
						}
						aux = aux.siguiente;
					}
					if (encontre) {
						v = new Valor(0, "", cant, true, 0, TipoValor.INT);	
					}
				}
				
				// caso de 1 parametro
				
				if (p2 == null){
					aux = this;
					cant = 0;
					encontre = false;
					while ((aux != null)&&(!encontre)){
						cant++;
						if (aux.e instanceof Valor){
							val = (Valor) aux.e;
							if (val.esIgual((Valor) p1)){
								encontre = true;
							}
						}
						aux = aux.siguiente;
					}
					
					if (encontre) {
						v = new Valor(0, "", cant, true, 0, TipoValor.INT);	
					}
				}
				
			}
			
			break;
		case "insert":
			//solo para valores
			
			if ((p1 instanceof Valor)&&(p2 instanceof Valor)){
				
				aux = this;
				
				val = (Valor) p1;
				
				valaux = (Valor) p2;
				
				if (valaux.getTipo() != TipoValor.INT){
					throw new ExecutionException("Error en funcion insert con el parametro 2");
				}
				
				cant = 1;
				
				while (valaux.getI()!= cant){
						
					cant++;
							
					aux = aux.siguiente;
					
				}
				
				t = new TEstructuradoLista(nueva, aux);
				
				aux = t;
				
			}
			
			break;
		case "pop":
			
			if (p1 instanceof Valor){
				
				aux = this;
				
				val = (Valor) p1;
				
				if (val.getTipo() != TipoValor.INT){
					throw new ExecutionException("Error en funcion insert con el parametro 2");
				}
				
				cant = 1;
				
				if (val.getI() == 1){
					
					e = siguiente.getE();
					siguiente = siguiente.getSiguiente();
							
				}else{
				
					while (val.getI()!= (cant-1)){
							
						cant++;
								
						aux = aux.siguiente;
						
					}
					
					aux.siguiente = siguiente.getSiguiente();
				}
			}
			
			break;
		case "size":
				
				aux = this;
				
				cant = 0;
				
				while (aux != null){
						
					cant++;
							
					aux = aux.siguiente;
					
				}
				
				v = new Valor(0, "", cant, true, 0, TipoValor.INT);	
			
			break;
			
		case "buscar":
			
			if (p1 instanceof Valor){
				
				aux = this;
				val = (Valor) p1;
				if (val.getTipo() != TipoValor.INT){
					throw new ExecutionException("Error en funcion insert con el parametro 2");
				}
				
				cant = 1;
				while ((aux != null)&&(cant != val.getI())){
					aux = aux.siguiente;
					cant++;
				}
				if (cant == val.getI()){
					return aux.e;
				}
			}
			return null;
		

		default:
			break;
			
		}
		
		return v;
		
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

	@Override
	String print(Contexto contexto) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	


}
