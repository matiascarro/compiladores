print "PRUEBA 6";

# Vamos a probar operaciones predefinidas

a = {
	"Love Actually": "Richart Curtis", 
	"Kill Bill": "Tarantino", 
	"Amelie": "Jeunet"
};

print a["Kill Bill"];

 b = a.has_key("Kill Bill");
 if (b):
	print "yeah!";
endif;

s = [111, "hola", 333, True];

d = s.count(111);
print "la cantidad de 111 en la lista";
print d;

l = a.keys();

print l[2];

end
