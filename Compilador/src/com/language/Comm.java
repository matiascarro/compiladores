package com.language;

public abstract class Comm {
	Contexto context;
	abstract void evaluar();
	
	
	public Contexto getContext() {
		return context;
	}
	
	public void setContext(Contexto context) {
		this.context = context;
	}

}
