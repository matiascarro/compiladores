package com.language;

public class Variable {
	float f;
	String s;
	int i;
	boolean b;
	long l;
	
	TipoVariable tipo;

	public Variable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Variable(float f, String s, int i, boolean b, long l,
			TipoVariable tipo) {
		super();
		this.f = f;
		this.s = s;
		this.i = i;
		this.b = b;
		this.l = l;
		this.tipo = tipo;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public long getL() {
		return l;
	}

	public void setL(long l) {
		this.l = l;
	}

	public TipoVariable getTipo() {
		return tipo;
	}

	public void setTipo(TipoVariable tipo) {
		this.tipo = tipo;
	}
	
	
}

