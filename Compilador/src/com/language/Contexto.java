package com.language;

import java.util.HashMap;
import java.util.Map;

import com.language.exceptions.ExecutionException;


public class Contexto {
	Map<String, Valor> variables;
	Map<String, TEstructuradoLista> listas;
	Map<String,FuncionDef> funciones;
	int ScopeGlobal;
	
	public Contexto() {
		super();
		variables = new HashMap<String, Valor>();
	}

	
	
	public Contexto(Map<String, Valor> variables,
			Map<String, TEstructuradoLista> listas,
			Map<String, FuncionDef> funciones, int scopeGlobal) {
		super();
		this.variables = variables;
		this.listas = listas;
		this.funciones = funciones;
		ScopeGlobal = scopeGlobal;
	}



	public Map<String, Valor> getVariables() {
		return variables;
	}
	
	public void setVariables(Map<String, Valor> variables) {
		this.variables = variables;
	}
	
	public int getScopeGlobal() {
		return ScopeGlobal;
	}
	
	public void setScopeGlobal(int scopeGlobal) {
		ScopeGlobal = scopeGlobal;
	}
	
	public Map<String, TEstructuradoLista> getListas() {
		return listas;
	}

	public void setListas(Map<String, TEstructuradoLista> listas) {
		this.listas = listas;
	}
	

	public Map<String, FuncionDef> getFunciones() {
		return funciones;
	}


	public void setFunciones(Map<String, FuncionDef> funciones) {
		this.funciones = funciones;
	}



	public String calcScopeVariable (String nomVariable){
		return nomVariable + '-' + ScopeGlobal;
	}
	
	public void aumentarScope (){
		ScopeGlobal++;
	}
	
	public void disminuirScope (){
		ScopeGlobal--;
	}
	
	public void actualizarOCrearVariable(Expr e, String nomVariable) throws ExecutionException{
		
		if(e instanceof Valor){
			Valor v = (Valor)e;
			variables.put(this.calcScopeVariable(nomVariable),v);
			listas.remove(this.calcScopeVariable(nomVariable));
		}
		else if(e instanceof TEstructuradoLista)
		{
			TEstructuradoLista value = (TEstructuradoLista) e;
			listas.put(this.calcScopeVariable(nomVariable), value);
			variables.remove(this.calcScopeVariable(nomVariable));
		}
		
		throw new ExecutionException("No se puede actualizar la variable");
		
		
	}
	
	public Expr buscarVariable(String nombreVariable) {
		Valor ret = null;
		TEstructuradoLista lista;
		for (int i = this.getScopeGlobal(); i>=0; i--){
			ret = variables.get(nombreVariable + "-" + i);
			if (ret != null){
				return ret;
			}
			lista = listas.get(nombreVariable + "-" + i);
			if(lista != null){
				return lista;
			}
		}
		return null;
		
		//esto cambia, tiene que buscar en todos los maps y quedarse con la variable con ese nombre con el scope mas grande
	}
	
	public void guardarFuncion(String nombreFuncion, FuncionDef funcion) {
		funciones.put(this.calcScopeVariable(nombreFuncion), funcion);
	}
	
	public void imprimir (){
		String s;
		s = variables.toString();
		System.out.println(s);
	}
	
}
