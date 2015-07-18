package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class TEstructuradoDiccionario extends Expr{

	Expr						valor;
	Valor						key;
	TEstructuradoDiccionario	siguiente;
	
	
	public TEstructuradoDiccionario() {
		// TODO Auto-generated constructor stub
	}
	
	

	public TEstructuradoDiccionario(Expr valor, Valor key,
			TEstructuradoDiccionario siguiente) {
		super();
		this.valor = valor;
		this.key = key;
		this.siguiente = siguiente;
	}
	
	



	public Expr getValor() {
		return valor;
	}



	public void setValor(Expr valor) {
		this.valor = valor;
	}



	public Valor getKey() {
		return key;
	}



	public void setKey(Valor key) {
		this.key = key;
	}



	public TEstructuradoDiccionario getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(TEstructuradoDiccionario siguiente) {
		this.siguiente = siguiente;
	}
	
	
	private boolean has_key(Valor v1) throws ExecutionException{
		TEstructuradoDiccionario ted = this;
		
		while (ted != null){
			if(ted.getKey().esIgual(v1)){
				return true;
			}
			ted=ted.getSiguiente();
		}
		
		return false;
	}
	
	private TEstructuradoLista aLista(){
		TEstructuradoLista nodo,sig,ret = new TEstructuradoLista();
		
		TEstructuradoDiccionario aux = this;
		ret.setE(this.getValor());
		ret.setSiguiente(null);
		sig = ret;
		while (aux.siguiente!=null){
			aux = aux.getSiguiente();
			nodo = new TEstructuradoLista(aux.getValor());
			sig.setSiguiente(nodo);
			sig = sig.getSiguiente();
		}
		
		return ret;
	}
	
	private TEstructuradoLista aClavesLista(){
		TEstructuradoLista nodo,sig,ret = new TEstructuradoLista();
		
		TEstructuradoDiccionario aux = this;
		ret.setE(this.getKey());
		ret.setSiguiente(null);
		sig = ret;
		while (aux.siguiente!=null){
			aux = aux.getSiguiente();
			nodo = new TEstructuradoLista(aux.getKey());
			sig.setSiguiente(nodo);
			sig = sig.getSiguiente();
		}
		
		return ret;
	}
	
	private void eliminarElemento(Valor v1){
		if(v1.esIgual(this.getKey())){
			this.valor = null;
		}
		
		TEstructuradoDiccionario ted = this;
		boolean encontre = false;
		while (ted.siguiente != null && !encontre){
			if(ted.getSiguiente().getKey().esIgual(v1)){
				ted.setSiguiente(ted.getSiguiente().getSiguiente());
			}
			ted=ted.getSiguiente();
		}
	}
	
	
	private Expr buscar(Valor v){
		TEstructuradoDiccionario ted = this;
		
		while (ted != null){
			if(ted.getKey().esIgual(v)){
				return ted.getValor();
			}
			ted=ted.getSiguiente();
		}
		return null;
	}
	
	
	public Expr ejecutarFuncion(Var nombreFuncion, Expr p1) throws ExecutionException{
		Valor v = null; //new Valor(0, "", -1, true, 0, TipoValor.INT);
		
		if ((nombreFuncion.getNombreVariable() == "has_key" || nombreFuncion.getNombreVariable()=="pop") && (p1 == null)){
			throw new ExecutionException("Parametro vacio en ejecutarFuncion");
		}
		
		if((nombreFuncion.getNombreVariable() != "has_key" && nombreFuncion.getNombreVariable()!="pop" && nombreFuncion.getNombreVariable()!="buscar") && (p1 != null)){
			throw new ExecutionException("No usa parametros en ejecutarFuncion");
		}
		Valor aux;
		switch (nombreFuncion.getNombreVariable()) {
		case "has_key":
			if(!(p1 instanceof Valor)){
				throw new ExecutionException("El parametro en la funcion tiene error de tipo");
			}
			aux = (Valor) p1;
			v = new Valor(0, null, 0, this.has_key(aux), 0, TipoValor.BOOL) ;
			return v;
			
		case "items":
			throw new ExecutionException("No esta implementada la funcion items de diccionario");
			
		case "keys":
			return this.aClavesLista();
			
		case "pop":
			if(!(p1 instanceof Valor)){
				throw new ExecutionException("El parametro en la funcion tiene error de tipo");
			}
			aux = (Valor) p1;
			this.eliminarElemento(aux);
			break;
			
		case "values":
			return this.aLista();
			
		case "buscar":
			if(!(p1 instanceof Valor)){
				throw new ExecutionException("El parametro en la funcion tiene error de tipo");
			}
			aux = (Valor) p1;
			return this.buscar(aux);
		default:
			break;
		}
		
		
		
		return v;
	}



	@Override
	Expr evaluar(Contexto contexto) throws ParsingException, ExecutionException {
		// TODO Auto-generated method stub
		
		TEstructuradoDiccionario aux = this;
		while(aux!=null){
			aux.key = aux.key.evaluar(contexto);
			aux.valor = aux.valor.evaluar(contexto);
			aux = aux.siguiente;
		}
		
		return this;
	}



	@Override
	String print(Contexto contexto) throws ExecutionException {
		// TODO Auto-generated method stub
		return "No se imprime el diccionario";
	}

}
