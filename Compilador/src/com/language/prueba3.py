print "PRUEBA 3";

# Vamos a probar listas, y condiciones booleanas con if y while

l = [11,22,33,44,55,66];

a = l[3];

print a;

print l[4];

x = l[5];

if ( x > 54 ) :

	print "La condicion es verdadera, y esta bien";
	
else

	print "Si imprimo esto estoy mal";
	
endif;

b = "HOLA";

while ( x > 52 ) :
	
	a = 32;
	b = a;
	x = x - 1;
	print "el nuevo valor de x es: " + x;

endwhile; 

print "pruebo el nuevo tipo de b: " + b;

l2 = [11, False];

mi_var = l[1];

print "mi_var vale " + mi_var;



end
