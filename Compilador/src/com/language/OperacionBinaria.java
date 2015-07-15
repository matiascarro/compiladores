package com.language;



import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class OperacionBinaria extends Expr{

	Expr e1, e2;
	TipoOperadorBinario op;
	
	
	
	public OperacionBinaria(Expr e1, Expr e2, TipoOperadorBinario op) {
		super();
		this.e1 = e1;
		this.e2 = e2;
		this.op = op;
	}
	
	

	public OperacionBinaria() {
		super();
		// TODO Auto-generated constructor stub
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



	public TipoOperadorBinario getOp() {
		return op;
	}



	public void setOp(TipoOperadorBinario op) {
		this.op = op;
	}



	private Valor calcularTipoOperadorMatematicoSuma(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
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
				ret.setL(v1.getL() + v2.getL());
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
			ret.setL(v1.getL() + v2.getI());
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
	
	private Valor calcularTipoOperadorMatematicoResta(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
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
				ret.setL(v1.getL() - v2.getL());
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
			ret.setL(v1.getL() - v2.getI());
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
	
	
	private Valor calcularTipoOperadorMatematicoDivision(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		switch (v2.getTipo()) {
		case FLOAT:
			if(v2.getF() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		case INT:
			if(v2.getI() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		case LONG:
			if(v2.getI() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		default:
			throw new ParsingException("Se quiere dividir errores de tipo");
			
		}
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF( v1.getF() / v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF( v1.getI() / v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF(v1.getL() / v2.getL());
				return ret;

			default:
				throw new ParsingException("No se puede sumar operadores de tipo " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getF() / v2.getI());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getI() / v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getL() / v2.getI());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getI() / v2.getL());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getF() / v2.getL());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getL() / v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	
	private Valor calcularTipoOperadorMatematicoDivisionEntera(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		switch (v2.getTipo()) {
		case FLOAT:
			if(v2.getF() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		case INT:
			if(v2.getI() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		case LONG:
			if(v2.getI() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		default:
			throw new ParsingException("Se quiere dividir errores de tipo");
			
		}
		
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF(v1.getF()%v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.INT);
				ret.setI(v1.getI()%v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(v1.getL()%v2.getL());
				return ret;

			default:
				throw new ParsingException("No se puede sumar operadores de tipo " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setI(new Float(v1.getF() / v2.getI()).intValue());
			ret.setTipo(TipoValor.INT);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setI(new Float(v1.getI() / v2.getF()).intValue());
			ret.setTipo(TipoValor.INT);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setI(new Float(v1.getL() / v2.getI()).intValue());
			ret.setTipo(TipoValor.INT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setI(new Float(v1.getI() / v2.getL()).intValue());
			ret.setTipo(TipoValor.INT);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setI(new Float(v1.getF() / v2.getL()).intValue());
			ret.setTipo(TipoValor.INT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setI(new Float(v1.getL() / v2.getF()).intValue());
			ret.setTipo(TipoValor.INT);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	private Valor calcularTipoOperadorMatematicoExponente(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
	
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF(new Double(Math.pow( v1.getF(),v2.getF())).floatValue());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(new Double(Math.pow( v1.getI() , v2.getI())).longValue());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(new Double(Math.pow(v1.getL() , v2.getL())).longValue());
				return ret;

			default:
				throw new ParsingException("No se puede sumar operadores de tipo " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
		}
		
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(new Double(Math.pow(v1.getF(),v2.getI())).floatValue());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(new Double(Math.pow(v1.getI(),v2.getF())).floatValue());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(new Double(Math.pow(v1.getL(),v2.getI())).floatValue());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(new Double(Math.pow(v1.getI(),v2.getL())).floatValue());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(new Double(Math.pow(v1.getF(),v2.getL())).floatValue());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(new Double(Math.pow(v1.getL(),v2.getF())).floatValue());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	///*****************************************************************************************
	///*************************-----------*****************************************************
	///*************************   MODULO  *****************************************************
	///*************************-----------*****************************************************
	///*****************************************************************************************
	private Valor calcularTipoOperadorMatematicoModulo(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		switch (v2.getTipo()) {
		case FLOAT:
			if(v2.getF() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		case INT:
			if(v2.getI() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		case LONG:
			if(v2.getI() == 0)
			{
				throw new ExecutionException("Division entre cero");
			}
			break;
		default:
			throw new ParsingException("Se quiere dividir errores de tipo");
			
		}
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF( v1.getF()%v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.INT);
				ret.setI( v1.getI() % v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(v1.getL() % v2.getL());
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
			ret.setL(v1.getL() + v2.getI());
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
	
	///*****************************************************************************************
	///*************************--------------------********************************************
	///*************************   MULTIPLICACION  *********************************************
	///*************************--------------------********************************************
	///*****************************************************************************************
	private Valor calcularTipoOperadorMatematicoMultiplicacion(Valor v1, Valor v2) throws ExecutionException, ParsingException{
		
		Valor ret;
		
		if(v1.getTipo() == v2.getTipo()){
			
			switch (v1.getTipo()) {
			case FLOAT:
				ret = new Valor();
				ret.setTipo(TipoValor.FLOAT);
				ret.setF( v1.getF()*v2.getF());
				return ret;
			case INT:
				ret = new Valor();
				ret.setTipo(TipoValor.INT);
				ret.setI( v1.getI() * v2.getI());
				return ret;
			case LONG:
				ret = new Valor();
				ret.setTipo(TipoValor.LONG);
				ret.setL(v1.getL() * v2.getL());
				return ret;

			default:
				throw new ParsingException("No se puede sumar operadores de tipo " +v1.getTipo().toString() + " con tipo "+v2.getTipo().toString() );
			}
			
		}
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getF() * v2.getI());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if (v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setF(v1.getI() * v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		
		if(v1.getTipo() == TipoValor.LONG && v2.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setL(v1.getL() * v2.getI());
			ret.setTipo(TipoValor.LONG);
			return ret;
		}
		if(v2.getTipo() == TipoValor.LONG && v1.getTipo() == TipoValor.INT){
			ret = new Valor();
			ret.setL(v1.getI() * v2.getL());
			ret.setTipo(TipoValor.LONG);
			return ret;	
		}
		
		if(v1.getTipo() == TipoValor.FLOAT && v2.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getF() * v2.getL());
			ret.setTipo(TipoValor.FLOAT);
			return ret;
		}
		if(v2.getTipo() == TipoValor.FLOAT && v1.getTipo() == TipoValor.LONG){
			ret = new Valor();
			ret.setF(v1.getL() * v2.getF());
			ret.setTipo(TipoValor.FLOAT);
			return ret;	
		}
		
		throw new ParsingException("Los tipos "+ v1 + "y "+ v2 + " son incompatibles");
	}
	
	
	@Override
	Valor evaluar(Contexto contexto) throws ParsingException, ExecutionException {
		// TODO Auto-generated method stub
		// Evaluo por ej 3 + 3  
		Expr ep1, ep2;
		Valor v1, v2;
		
		
		ep1 = e1.evaluar(contexto);
		ep2 = e2.evaluar(contexto);
		
		if(!(ep1 instanceof Valor) || !(ep2 instanceof Valor)){
			throw new ExecutionException("Error de tipo, errores cuando se quiere asignar");
		}
		
		
		v1 = (Valor)ep1;
		v2 = (Valor)ep2;
		
		switch (op) {
			
			case SUMA:
				return  this.calcularTipoOperadorMatematicoSuma(v1, v2);
				
			case RESTA:
				return this.calcularTipoOperadorMatematicoResta(v1, v2);
				
			case DIVISION:
				return this.calcularTipoOperadorMatematicoDivision(v1, v2);
				
			case DIVISION_ENTERA:
				return this.calcularTipoOperadorMatematicoDivisionEntera(v1, v2);
				
			case EXPONENTE:
				return this.calcularTipoOperadorMatematicoExponente(v1, v2);
				
			case MODULO:
				return this.calcularTipoOperadorMatematicoModulo(v1, v2);
				
			case MULTIPLICACION:
				this.calcularTipoOperadorMatematicoMultiplicacion(v1, v2);

		default:
			break;
		}
		
		return null;
	}

	
	
}
