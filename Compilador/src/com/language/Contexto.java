package com.language;

import java.util.HashMap;
import java.util.Map;


public class Contexto {
	Map<String, Valor> variables;
	Map<String, Estructurados> listas;
	int ScopeGlobal;
	
	public Contexto() {
		super();
		variables = new HashMap<String, Valor>();
	}

	public Contexto(Map<String, Valor> variables,
			Map<String, Estructurados> listas, int scopeGlobal) {
		super();
		this.variables = variables;
		this.listas = listas;
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
	
	public Map<String, Estructurados> getListas() {
		return listas;
	}

	public void setListas(Map<String, Estructurados> listas) {
		this.listas = listas;
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
	
	public void actualizarOCrearVariable(Valor v, String nomVariable){
		//Si existe la variable tengo que setear tb el tipo
		variables.put(this.calcScopeVariable(nomVariable),v);
	}
	
	public Valor buscarVariable(String nombreVariable) {
		Valor ret = null;
		for (int i = this.getScopeGlobal(); i>=0; i--){
			ret = variables.get(nombreVariable + "-" + i);
			if (ret != null){
				break;
				
			}
		}
		return ret;
		
		//esto cambia, tiene que buscar en todos los maps y quedarse con la variable con ese nombre con el scope mas grande
	}
	
	public void imprimir (){
		String s;
		s = variables.toString();
		System.out.println(s);
	}
	
}
