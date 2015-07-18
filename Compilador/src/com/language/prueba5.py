print "PRUEBA 5";

# Vamos a probar funciones

a = 18;

def funcion():

	b = a;
	print b;
	
end;

print "Si llamamos a la funcion, nos imprime que b vale: ";

funcion();

# Vamos a probar con una funcion que nos halle el factorial de un numero x

def factorial(x):

	i = x - 1;
	resultado = x;
	
	while i > 0:
		resultado = resultado * i;
		i = i - 1;
	endwhile;
	
	print "El resultado de factorial de x: ";
	print resultado;

end;

factorial(7);		

# Vamos a probar con una funcion que devuelva la suma de dos numeros


def suma(m , n):

	i = m + n;
	
	print "El resultado de la suma es:";
	print i;

end;

suma(11 , 3);	

end
