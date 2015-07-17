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

"*" 				{ return symbol(sym.MULTIPLICACION, "*"); }
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
"not" 				{ return symbol(sym.NOT, "not"); }

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

"." 				{ return symbol(sym.DOT, "."); }

"has_key" 			{ return symbol(sym.FHASKEY, "has_key"); }
"items" 			{ return symbol(sym.FITEMS, "items"); }
"keys"  			{ return symbol(sym.FKEYS, "keys"); }
"pop" 				{ return symbol(sym.FPOP, "pop"); }
"values" 			{ return symbol(sym.FVALUES, "values"); }
"count" 			{ return symbol(sym.FCOUNT, "count"); }
"find"	 			{ return symbol(sym.FFIND, "find"); }
"join"	 			{ return symbol(sym.FJOIN, "join"); }
"split" 			{ return symbol(sym.FSPLIT, "split"); }
"replace" 			{ return symbol(sym.FREPLACE, "replace"); }
"length" 			{ return symbol(sym.FLENGTH, "length"); }
"append" 			{ return symbol(sym.FAPPEND, "append"); }
"extend" 			{ return symbol(sym.FEXTEND, "extend"); }
"index" 			{ return symbol(sym.FINDEX, "index"); }
"insert"	 		{ return symbol(sym.FINSERT, "insert"); }
"size"	 			{ return symbol(sym.FSIZE, "size"); }

"def"				{ return symbol(sym.FDEF, "def"); }
"return"			{ return symbol(sym.FRETURN, "return"); }


"{" 				{ return symbol(sym.LPARENCORCHETE, "{"); }
"}" 				{ return symbol(sym.RPARENCORCHETE, "}"); }

":" 				{ return symbol(sym.DOSPUNTOS, ":"); }

";" 				{ return symbol(sym.SEPARADOR, ";"); }

"end" 				{ return symbol(sym.END, "end"); }

"while" 			{ return symbol(sym.WHILE, "while"); }
"endwhile" 			{ return symbol(sym.ENDWHILE, "endwhile"); }
"if" 				{ return symbol(sym.IF, "if"); }
"else" 				{ return symbol(sym.ELSE, "else"); }
"endif" 			{ return symbol(sym.ENDIF, "endif"); }


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



