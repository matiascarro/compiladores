package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class Valor  extends Expr{
	private float f;
	private String s;
	private int i;
	private boolean b;
	private long l;
	
	private TipoValor tipo;

	public Valor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Valor(float f, String s, int i, boolean b, long l,
			TipoValor tipo) {
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
	
	public boolean esIgual (Valor vaux){
		boolean resultado = false;
		if (this.tipo == vaux.tipo){
			if (this.tipo == TipoValor.BOOL){
				if (this.b == vaux.b){
					resultado = true;
				}
			}
			if (this.tipo == TipoValor.FLOAT){
				if (this.f == vaux.f){
					resultado = true;
				}
			}
			if (this.tipo == TipoValor.INT){
				if (this.i == vaux.i){
					resultado = true;
				}
			}
			if (this.tipo == TipoValor.LONG){
				if (this.l == vaux.l){
					resultado = true;
				}
			}
			if (this.tipo == TipoValor.STRING){
				if (this.s.equals(vaux.s)){
					resultado = true;
				}
			}
		}
		return resultado;
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

	public TipoValor getTipo() {
		return tipo;
	}

	public void setTipo(TipoValor tipo) {
		this.tipo = tipo;
	}
	
	
	public Valor ejecutarFuncionString(Var nombreFuncion, Expr p1, Expr p2) throws ExecutionException{
		
		Valor v = null; //new Valor(0, "", -1, true, 0, TipoValor.INT);
		
		if ((nombreFuncion.getNombreVariable() != "length") && (p1 == null)){
			throw new ExecutionException("Parametro vacio en ejecutarFuncionString");
		}
		if ((nombreFuncion.getNombreVariable() == "replace") && (p2 == null)){
			throw new ExecutionException("Parametro vacio en ejecutarFuncionString");
		}
		
		if ((p1 != null) && (!(p1 instanceof Valor)||!(p1 instanceof TEstructuradoLista))){
			throw new ExecutionException("Parametro de tipo invalido en ejecutarFuncionString");
		}
		
		if ((p2 != null) && (!(p2 instanceof Valor)||!(p2 instanceof TEstructuradoLista))){
			throw new ExecutionException("Parametro de tipo invalido en ejecutarFuncionString");
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
		case "count":
			
			val = (Valor) p1;
			
			cant = 0;
			
			while (this.s.indexOf(val.getS(), 0) != -1){
				cant++;
			}
			
			v = new Valor(0, "", cant, true, 0, TipoValor.INT);
				
			break;
			
		case "find":
			
			if (p1 instanceof Valor){
				
				// caso de dos parametros
				if ((p2 != null)&&(p2 instanceof Valor)){
					
					cant = 0;
					
					val = (Valor) p1;
					
					valaux = (Valor) p2;
					
					if ((val.getTipo() != TipoValor.STRING)||(valaux.getTipo() != TipoValor.INT)){
						throw new ExecutionException("Parametro invalido en funcion find de strings");
					}
					
					cant = this.s.indexOf(val.getS(), valaux.getI());
					
					v = new Valor(0, "", cant, true, 0, TipoValor.INT);
				
				
				}
				
				if (p2 == null){
					
					cant = 0;
					
					val = (Valor) p1;
					
					if ((val.getTipo() != TipoValor.STRING)){
						throw new ExecutionException("Parametro invalido en funcion find de strings");
					}
					
					cant = this.s.indexOf(val.getS());
					
					v = new Valor(0, "", cant, true, 0, TipoValor.INT);
					
				}
			}	
			
			break;
			
		case "join":
			//IMPLEMENTAR
			
			break;
			
		case "split":
			//IMPLEMENTAR
			
			break;
		case "replace":
			//IMPLEMENTAR
			
			
			break;
		case "length":
				
				cant = s.length();
				
				v = new Valor(0, "", cant, true, 0, TipoValor.INT);	
			
			break;

		default:
			break;
			
		}
		
		return v;
		
	}

	

	@Override
	Valor evaluar(Contexto contexto) throws ParsingException,
			ExecutionException {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	String print(Contexto contexto) throws ExecutionException {
		
			switch (tipo) {
			case BOOL:
				return b?"True":"False";
			case FLOAT:
				return new Float(f).toString();
			case INT:
				return new Integer(i).toString();
			case LONG:
				return new Long(l).toString();
			case STRING:
				return s;

			default:
				return "No deberia pasar esto";
			}
		}
}

