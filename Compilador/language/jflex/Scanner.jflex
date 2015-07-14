package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.exceptions.*;
import com.language.model.expression.*;

%%

%cup
%line
%unicode
%column

%class Scanner
%{
	private SymbolFactory sf;
	private StringBuffer string = new StringBuffer();

	public Scanner(java.io.InputStream r, SymbolFactory sf) {
		this(r);
		this.sf=sf;
	}

	private Symbol symbol(int type) {
		return new Symbol(type, yyline, yycolumn);
	}
	private Symbol symbol(int type, Object value) {
		return new Symbol(type, yyline, yycolumn, value);
	}
%}

%eofval{
    return symbol(sym.EOF);
%eofval}

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]

Identifier = [:jletter:][:jletterdigit:]* 

IntegerLiteral = 0 | [1-9][0-9]*
FloatLiteral = (0 | [1-9][0-9]*)\.[0-9]+
DecLongLiteral    = {IntegerLiteral} [lL]

%%

"+" 				{ return symbol(sym.SUMA, "+"); }
"-" 				{ return symbol(sym.RESTA, "-"); }

"/" 				{ return symbol(sym.DIVISION, "/"); }
"=" 				{ return symbol(sym.EQUAL, "="); }

"(" 				{ return symbol(sym.LPAREN, "("); }
")" 				{ return symbol(sym.RPAREN, ")"); }

"**" 				{ return symbol(sym.EXPONENTE, "**"); }
"//" 				{ return symbol(sym.DIVISION_ENTERA, "//"); }
"%" 				{ return symbol(sym.MODULO, "%"); }

"&" 				{ return symbol(sym.BAND, "&"); }
"|" 				{ return symbol(sym.BOR, "|"); }
"^" 				{ return symbol(sym.BXOR, "^"); }
"~" 				{ return symbol(sym.COMPLEMENTO, "~"); }
"<<" 				{ return symbol(sym.SHIFT_IZQ, "<<"); }
">>" 				{ return symbol(sym.SHIFT_DER, ">>"); }

"and" 				{ return symbol(sym.AND, "and"); }
"or" 				{ return symbol(sym.OR, "or"); }
"not" 				{ return symbol(sym.NEGACION, "not"); }

"==" 				{ return symbol(sym.IGUAL, "=="); }
"!=" 				{ return symbol(sym.DISTINTO, "!="); }
"<" 				{ return symbol(sym.MENOR, "<"); }
">" 				{ return symbol(sym.MAYOR, ">"); }
"<=" 				{ return symbol(sym.MENOR_IGUAL, "<="); }
">=" 				{ return symbol(sym.MAYOR_IGUAL, ">="); }

"False"				{ return symbol(sym.BOOLEAN, false); }
"True"				{ return symbol(sym.BOOLEAN, true); }

"[" 				{ return symbol(sym.LPARENCUADRADO, "["); }
"]" 				{ return symbol(sym.RPARENCUADRADO, "]"); }

"," 				{ return symbol(sym.COMMA, ","); }

"{" 				{ return symbol(sym.LPARENCORCHETE, "{"); }
"}" 				{ return symbol(sym.RPARENCORCHETE, "}"); }

":" 				{ return symbol(sym.DOSPUNTOS, ":"); }


";" 				{ return symbol(sym.SEPARADOR, ";"); }

"end" 				{ return symbol(sym.END, "end"); }

"print" 			{ return symbol(sym.PRINT, "print"); }

\"([^\"\r\n\t]*)\"	{ return symbol(sym.STRING, yytext()); }

'([^\"\r\n\t]*)'	{ return symbol(sym.STRING, yytext()); }

{Identifier}		{ return symbol(sym.ID, yytext()); }

{IntegerLiteral}	{ return symbol(sym.INT, yytext()); }

{DecLongLiteral}	{ return symbol(sym.LONG, yytext()); }

{FloatLiteral}		{ return symbol(sym.FLOAT, yytext()); }
					


{WhiteSpace}        { /* ignore*/ }

. 					{
						throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
					}



