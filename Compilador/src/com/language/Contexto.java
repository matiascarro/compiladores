package com.language;

import java.util.HashMap;
import java.util.Map;


public class Contexto {
	Map<String, Variable> variables;
	int ScopeGlobal;
	
	public Contexto() {
		super();
		variables = new HashMap<String, Variable>();
	}

	public Contexto(Map<String, Variable> variables, int scopeGlobal) {
		super();
		this.variables = variables;
		ScopeGlobal = scopeGlobal;
	}
	
	public Map<String, Variable> getVariables() {
		return variables;
	}
	
	public void setVariables(Map<String, Variable> variables) {
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
	
	public void actualizarOCrearVariable(Variable v){
		variables.put(this.calcScopeVariable(v.getNombre()),v);
		
	}
	
}
