package com.language;

public class OperacionBinaria extends Expr{

	Expr e1, e2;
	TipoOperadorBinario op;
	
	@Override
	Valor evaluar(Contexto contexto) throws Exception {
		// TODO Auto-generated method stub
		// Evaluo por ej 3 + 3  
		Valor v1, v2;
		
		v1= e1.evaluar(contexto);
		v2=e2.evaluar(contexto);
		
		switch (op) {
			
			case SUMA:
			
			break;
			
			case RESTA:
				
			break;

		default:
			break;
		}
		
		return null;
	}

	
	
}
