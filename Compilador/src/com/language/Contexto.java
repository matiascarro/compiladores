package com.language;

import java.util.HashMap;
import java.util.Map;


public class Contexto {
	Map<String, Valor> variables;
	int ScopeGlobal;
	
	public Contexto() {
		super();
		variables = new HashMap<String, Valor>();
	}

	public Contexto(Map<String, Valor> variables, int scopeGlobal) {
		super();
		this.variables = variables;
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
		return variables.get(nombreVariable);
	}
	
	public void imprimir (){
		String s;
		s = variables.toString();
		System.out.println(s);
	}
	
}
