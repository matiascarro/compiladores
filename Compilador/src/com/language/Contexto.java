package com.language;

import java.util.HashMap;
import java.util.Map;


public class Contexto {
	Map<String, TipoVariable> variables;
	int ScopeGlobal;
	
	public Contexto() {
		super();
		variables = new HashMap<String, TipoVariable>();
	}

	public Contexto(Map<String, TipoVariable> variables, int scopeGlobal) {
		super();
		this.variables = variables;
		ScopeGlobal = scopeGlobal;
	}
	
	public Map<String, TipoVariable> getVariables() {
		return variables;
	}
	
	public void setVariables(Map<String, TipoVariable> variables) {
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
	
}
