package com.language;

import com.language.exceptions.ExecutionException;
import com.language.exceptions.ParsingException;

public class OperacionBitwise extends Expr {

	private Expr e1, e2;
	private TipoOperadorBitwise op;
	
	public OperacionBitwise() {
		// TODO Auto-generated constructor stub
	}
	
	

	public OperacionBitwise(Expr e1, Expr e2, TipoOperadorBitwise op) {
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



	public TipoOperadorBitwise getOp() {
		return op;
	}



	public void setOp(TipoOperadorBitwise op) {
		this.op = op;
	}

	//******************************************************************************
	//******************************************************************************
	//*****************                AND                 *************************
	//******************************************************************************
	//******************************************************************************
	private Valor calcularOperacionAnd(Valor v1, Valor v2) throws ExecutionException{
		
		switch (v1.getTipo()) {
		
		case BOOL:
			if(v2.getTipo() == TipoValor.BOOL){
				return new Valor(0, null, 0,v1.isB() & v2.isB(), 0, TipoValor.BOOL);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		case INT:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, v1.getI() & v2.getI(),false, 0, TipoValor.INT);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() & v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
		case LONG:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, 0,false, v1.getL() & v2.getI(), TipoValor.LONG);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() & v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		default:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado");
		}
	}
	
	
	//******************************************************************************
	//******************************************************************************
	//*****************                OR                 **************************
	//******************************************************************************
	//******************************************************************************
	private Valor calcularOperacionOr(Valor v1, Valor v2) throws ExecutionException{
		
		switch (v1.getTipo()) {
		
		case BOOL:
			if(v2.getTipo() == TipoValor.BOOL){
				return new Valor(0, null, 0,v1.isB() | v2.isB(), 0, TipoValor.BOOL);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		case INT:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, v1.getI() | v2.getI(),false, 0, TipoValor.INT);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() | v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
		case LONG:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, 0,false, v1.getL() | v2.getI(), TipoValor.LONG);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() | v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		default:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado");
		}
	}
		
		
	//******************************************************************************
	//******************************************************************************
	//*****************                XOR                 *************************
	//******************************************************************************
	//******************************************************************************
	private Valor calcularOperacionXor(Valor v1, Valor v2) throws ExecutionException{
		
		switch (v1.getTipo()) {
		
		case BOOL:
			if(v2.getTipo() == TipoValor.BOOL){
				return new Valor(0, null, 0,v1.isB() ^ v2.isB(), 0, TipoValor.BOOL);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		case INT:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, v1.getI() ^ v2.getI(),false, 0, TipoValor.INT);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() ^ v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
		case LONG:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, 0,false, v1.getL() ^ v2.getI(), TipoValor.LONG);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() ^ v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		default:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado");
		}
	}
	
	//******************************************************************************
	//******************************************************************************
	//*****************             Shift_Izq              *************************
	//******************************************************************************
	//******************************************************************************
	private Valor calcularOperacionShiftIzq(Valor v1, Valor v2) throws ExecutionException{
		
		switch (v1.getTipo()) {
		
		case BOOL:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado en la operacion");
			
		case INT:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, v1.getI() << v2.getI(),false, 0, TipoValor.INT);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() << v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
		case LONG:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, 0,false, v1.getL() << v2.getI(), TipoValor.LONG);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() << v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		default:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado");
		}
	}
	
	
	private Valor calcularOperacionShiftDer(Valor v1, Valor v2) throws ExecutionException{
		
		switch (v1.getTipo()) {
		
		case BOOL:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado en la operacion");
			
		case INT:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, v1.getI() >> v2.getI(),false, 0, TipoValor.INT);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() >> v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
		case LONG:
			if(v2.getTipo() == TipoValor.INT){
				return new Valor(0, null, 0,false, v1.getL() >> v2.getI(), TipoValor.LONG);
			}
			if(v2.getTipo() == TipoValor.LONG){
				return new Valor(0, null, 0,false, v1.getL() >> v2.getL(), TipoValor.LONG);
			}
			throw new ExecutionException("Tipo"+ v2.getTipo() +" no soportado");
			
		default:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado");
		}
	}
	
	
	private Valor calcularOperacionComplemento(Valor v1) throws ExecutionException{
		
		switch (v1.getTipo()) {
		
		case BOOL:
			
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado en la operacion");
			
		case INT:
			return new Valor(0, null, ~v1.getI(),false, 0, TipoValor.INT);
			
		case LONG:
			return new Valor(0, null, 0,false, ~v1.getL(), TipoValor.INT);
			
		default:
			throw new ExecutionException("Tipo"+ v1.getTipo() +" no soportado");
		}
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
		
		if(v1.getTipo() == TipoValor.FLOAT ||  v2.getTipo() == TipoValor.FLOAT
				|| v1.getTipo() == TipoValor.STRING ||  v2.getTipo() == TipoValor.STRING){
			throw new ParsingException("Errores de tipo, no soporta " + v1.getTipo().toString() + " con " + v2.getTipo().toString() + " en la operacion");
		}
		
		if((v1.getTipo() == TipoValor.BOOL && v2.getTipo() != TipoValor.BOOL) ||
				(v1.getTipo() != TipoValor.BOOL && v2.getTipo() == TipoValor.BOOL)){
			throw new ParsingException("Errores de tipo, no soporta " + v1.getTipo().toString() + " con " + v2.getTipo().toString() + " en la operacion");
		}
		
		
			
		switch (op) {
		
		case AND:
			return this.calcularOperacionAnd(v1, v2);
			
		case OR:
			return this.calcularOperacionOr(v1, v2);
			
		case SHIFT_DER:
			return this.calcularOperacionShiftDer(v1, v2);
			
		case SHIFT_IZQ:
			return this.calcularOperacionShiftIzq(v1, v2);
			
		case XOR:
			return this.calcularOperacionXor(v1, v2);
			
		case COMPLEMENTO:
			this.calcularOperacionComplemento(v1);

		default:
			throw new ExecutionException("Operación " + op.toString() + " no soportada" );
		}
		
	}

}
