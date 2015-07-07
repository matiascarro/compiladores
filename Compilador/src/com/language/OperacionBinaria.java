package com.language;

import com.language.exceptions.ParsingException;

public class OperacionBinaria extends Expr{

	Expr e1, e2;
	TipoOperadorBinario op;
	
	
	private Valor calcularTipoOperadorMatematicoSuma(Valor v1, Valor v2){
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF( v1.getF()+v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.INT);
				ret.setI( v1.getI() + v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(ret.getL() + ret.getL());
				return ret;

			default:
				throw new ParsingException("No se puede sumar operadores de tipo " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getF() + v2.getI());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getI() + v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getL() + v2.getI());
			ret.setTipo(TipoValor.LONG);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setL(v1.getI() + v2.getL());
			ret.setTipo(TipoValor.LONG);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getF() + v2.getL());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getL() + v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	private Valor calcularTipoOperadorMatematicoResta(Valor v1, Valor v2){
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF( v1.getF()-v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.INT);
				ret.setI( v1.getI() - v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(ret.getL() - ret.getL());
				return ret;

			default:
				throw new ParsingException("No se puede sumar operadores de tipo " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getF() - v2.getI());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getI() - v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getL() - v2.getI());
			ret.setTipo(TipoValor.LONG);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setL(v1.getI() - v2.getL());
			ret.setTipo(TipoValor.LONG);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getF() - v2.getL());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getL() - v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	
	@Override
	Valor evaluar(Contexto contexto) {
		// TODO Auto-generated method stub
		// Evaluo por ej 3 + 3  
		Valor v1, v2, ret;
		
		
		v1 = e1.evaluar(contexto);
		v2 = e2.evaluar(contexto);
		
		switch (op) {
			
			case SUMA:
				return  this.calcularTipoOperadorMatematicoSuma(v1, v2);
				
			case RESTA:
				return this.calcularTipoOperadorMatematicoResta(v1, v2);
				
			
			case DIVISION:
				break;
				
			case DIVISION_ENTERA:
				break;
				
			case EXPONENTE:
				break;
				
			case MODULO:
				break;
				
			case MULTIPLICACION:
				break;

		default:
			break;
		}
		
		return null;
	}

	
	
}
