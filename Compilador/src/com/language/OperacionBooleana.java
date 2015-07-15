package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class OperacionBooleana extends Expr{

	Expr e1, e2;
	TipoOperadorBooleano op;
	
	public OperacionBooleana() {
		// TODO Auto-generated constructor stub
	}
	
	

	public OperacionBooleana(Expr e1, Expr e2, TipoOperadorBooleano op) {
		super();
		this.e1 = e1;
		this.e2 = e2;
		this.op = op;
	}


	

	public Expr getE1() {
		return e1;
	}



	public void setE1(Expr e1) {
		this.e1 = e1;
	}



	public Expr getE2() {
		return e2;
	}



	public void setE2(Expr e2) {
		this.e2 = e2;
	}



	public TipoOperadorBooleano getOp() {
		return op;
	}



	public void setOp(TipoOperadorBooleano op) {
		this.op = op;
	}

	//******************************************************************************************************
	//******************************************************************************************************
	//*********************************   DISTINTO   *******************************************************
	//******************************************************************************************************
	//******************************************************************************************************
	private Valor calcularOperacionDistinto(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getF() != v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getI() != v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getL() != v2.getL());
				return ret;
			case BOOL:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.isB() != v2.isB());
				return ret;
			case STRING:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getS() != v2.getS());
				return ret;

			default:
				throw new ParsingException("No soporta operacion para los tipos  " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getF() != v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() != v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getL() != v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() != v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getF() != v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getL() != v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	//******************************************************************************************************
	//******************************************************************************************************
	//************************************   IGUAL   *******************************************************
	//******************************************************************************************************
	//******************************************************************************************************	
	private Valor calcularOperacionIgual(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getF() == v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getI() == v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getL() == v2.getL());
				return ret;
			case BOOL:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.isB() == v2.isB());
				return ret;
			case STRING:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getS() == v2.getS());
				return ret;

			default:
				throw new ParsingException("No soporta operacion para los tipos  " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getF() == v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() == v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getL() == v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() == v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getF() == v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getL() == v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	//******************************************************************************************************
	//******************************************************************************************************
	//************************************   MAYOR    ******************************************************
	//******************************************************************************************************
	//******************************************************************************************************	
	private Valor calcularOperacionMayor(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getF() > v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getI() > v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getL() > v2.getL());
				return ret;
			case BOOL:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(false);
				return ret;
			case STRING:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getS().compareTo(v2.getS()) > 0);
				return ret;

			default:
				throw new ParsingException("No soporta operacion para los tipos  " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getF() > v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() > v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getL() > v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() > v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getF() > v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getL() > v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}


	//******************************************************************************************************
	//******************************************************************************************************
	//************************************   MAYOR IGUAL   *************************************************
	//******************************************************************************************************
	//******************************************************************************************************	
	private Valor calcularOperacionMayorIgual(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getF() >= v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getI() >= v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getL() >= v2.getL());
				return ret;
			case BOOL:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(false);
				return ret;
			case STRING:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getS().compareTo(v2.getS()) >= 0);
				return ret;

			default:
				throw new ParsingException("No soporta operacion para los tipos  " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getF() >= v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() >= v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getL() >= v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() >= v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getF() >= v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getL() >= v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}

	//******************************************************************************************************
	//******************************************************************************************************
	//************************************   MENOR    ******************************************************
	//******************************************************************************************************
	//******************************************************************************************************	
	private Valor calcularOperacionMenor(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getF() < v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getI() < v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getL() < v2.getL());
				return ret;
			case BOOL:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(false);
				return ret;
			case STRING:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getS().compareTo(v2.getS()) < 0);
				return ret;

			default:
				throw new ParsingException("No soporta operacion para los tipos  " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getF() < v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() < v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getL() < v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() < v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getF() < v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getL() < v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}


	//******************************************************************************************************
	//******************************************************************************************************
	//************************************   MENOR IGUAL   *************************************************
	//******************************************************************************************************
	//******************************************************************************************************	
	private Valor calcularOperacionMenorIgual(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getF() <= v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB( v1.getI() <= v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getL() <= v2.getL());
				return ret;
			case BOOL:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(false);
				return ret;
			case STRING:
				ret = new Valor();
				ret.setTipo(TipoValor.BOOL);
				ret.setB(v1.getS().compareTo(v2.getS()) <= 0);
				return ret;

			default:
				throw new ParsingException("No soporta operacion para los tipos  " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getF() <= v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() <= v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getL() <= v2.getI());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setB(v1.getI() <= v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getF() <= v2.getL());
			ret.setTipo(TipoValor.BOOL);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setB(v1.getL() <= v2.getF());
			ret.setTipo(TipoValor.BOOL);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	
	@Override
	Valor evaluar(Contexto contexto) throws ParsingException,
			ExecutionException {
		
		Expr ep1, ep2;
		Valor v1, v2;
		
		
		ep1 = e1.evaluar(contexto);
		ep2 = e2.evaluar(contexto);
		
		if(!(ep1 instanceof Valor) || !(ep2 instanceof Valor)){
			throw new ExecutionException("Error de tipo, errores cuando se quiere asignar");
		}
		
		
		v1 = (Valor)ep1;
		v2 = (Valor)ep2;
		
		/*if(v1.getTipo() == TipoValor.BOOL ||  v2.getTipo() == TipoValor.BOOL){
				
			throw new ParsingException("Errores de tipo, no soporta " + v1.getTipo().toString() + " con " + v2.getTipo().toString() + " en la operacion");
		}*/
		
		switch (op) {
		case AND:
			if(v1.getTipo() == TipoValor.BOOL && v2.getTipo() == TipoValor.BOOL){
				return new Valor(0, null, 0, v1.isB() && v2.isB(), 0, TipoValor.BOOL);
			}
			throw new ExecutionException("Errores de tipo, no soporta " + v1.getTipo().toString() + " con " + v2.getTipo().toString() + " en la operacion");
		case OR:
			if(v1.getTipo() == TipoValor.BOOL && v2.getTipo() == TipoValor.BOOL){
				return new Valor(0, null, 0, v1.isB() || v2.isB(), 0, TipoValor.BOOL);
			}
			throw new ExecutionException("Errores de tipo, no soporta " + v1.getTipo().toString() + " con " + v2.getTipo().toString() + " en la operacion");
		case NEGACION:
			if(v1.getTipo() == TipoValor.BOOL && v2.getTipo() == TipoValor.BOOL){
				return new Valor(0, null, 0, !v1.isB(), 0, TipoValor.BOOL);
			}
			throw new ExecutionException("Errores de tipo, no soporta " + v1.getTipo().toString() + " con " + v2.getTipo().toString() + " en la operacion");
		case DISTINTO:
			return this.calcularOperacionDistinto(v1, v2);
		case IGUAL:
			return this.calcularOperacionIgual(v1, v2);
		case MAYOR:
			return this.calcularOperacionMayor(v1, v2);
		case MAYOR_IGUAL:
			return this.calcularOperacionMayorIgual(v1, v2);
		case MENOR:
			return this.calcularOperacionMenor(v1, v2);
		case MENOR_IGUAL:
			return this.calcularOperacionMenorIgual(v1, v2);
		default:
			throw new ExecutionException("Operación " + op.toString() + " no soportada" );
			
		}
				
	}

}
