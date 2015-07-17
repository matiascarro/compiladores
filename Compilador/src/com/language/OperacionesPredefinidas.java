package com.language;

import com.language.exceptions.ExecutionException;

public class OperacionesPredefinidas extends Expr{
	
	Var variable; //es la variable a la que se le aplica la operacion, puede ser lista, diccionario, string
	Var nombreFuncion;
	Expr parametro1;
	Expr parametro2;
	
	
	public OperacionesPredefinidas(Var variable, Var nombreFuncion,
			Expr parametro1, Expr parametro2) {
		super();
		this.variable = variable;
		this.nombreFuncion = nombreFuncion;
		this.parametro1 = parametro1;
		this.parametro2 = parametro2;
	}



	@Override
	Expr evaluar(Contexto contexto) throws ExecutionException  {
		// TODO Auto-generated method stub
		// si variable no es lista o diccionario o string entonces error
		// hay que encontrar la variable en el contexto y que no sea null
		// si variable no existe tengo que dar error
		
		Expr e = contexto.buscarVariable(variable.getNombreVariable());
		
		if (e instanceof TEstructuradoLista){
			TEstructuradoLista lista = (TEstructuradoLista)e;
			if (parametro1 != null){
				parametro1 = parametro1.evaluar(contexto);
			}
			if (parametro2 != null){
				parametro2 = parametro2.evaluar(contexto);
			}
			return lista.ejecutarFuncion(nombreFuncion, parametro1, parametro2);
		}
		if (e instanceof TEstructuradoDiccionario){
			if(parametro2 != null){
				throw new ExecutionException("Mal llamada la funcion con parametros");
			}
			if (parametro1 != null){
				parametro1 = parametro1.evaluar(contexto);
			}
			TEstructuradoDiccionario diccionario = (TEstructuradoDiccionario)e;
			return diccionario.ejecutarFuncion(nombreFuncion, parametro1);
		}
		if(e instanceof Valor){
			Valor v = (Valor)e;
			if(((Valor) e).getTipo() == TipoValor.STRING){
				if (parametro1 != null){
					parametro1 = parametro1.evaluar(contexto);
				}
				if (parametro2 != null){
					parametro2 = parametro2.evaluar(contexto);
				}
				return v.ejecutarFuncionString(nombreFuncion, parametro1, parametro2);
			}
		}
			
		throw new ExecutionException("Error en la operacion predefinida");
	
	}



	@Override
	String print(Contexto contexto) throws ExecutionException {
		Expr e = evaluar(contexto);
		return e.print(contexto);
	}
	
	

}
