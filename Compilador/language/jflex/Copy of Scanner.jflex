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

%%

[0-9]+				{ return symbol(sym.INTEGER, atoi(yytext)); } (¿?)
LONG??
[0-9]+\.[0-9]+		{ return symbol(sym.FLOAT, atof(yytext)); }

false				{ return symbol(sym.FALSE, yytext()); }
true				{ return symbol(sym.TRUE, yytext()); }

\"([^\"\r\n\t]*)\"	{ return symbol(sym.STRING, yytext()); }

'([^\"\r\n\t]*)'	{ return symbol(sym.STRING, yytext()); }


"+" 				{ return symbol(sym.PLUS, "+"); }
"-" 				{ return symbol(sym.MINUS, "-"); }
"*" 				{ return symbol(sym.TIMES, "*"); }
"/" 				{ return symbol(sym.DIV, "/"); }
"**" 				{ return symbol(sym.EXP, "**"); }
"//" 				{ return symbol(sym.DIVINT, "//"); }
"%" 				{ return symbol(sym.MOD, "%"); }

"(" 				{ return symbol(sym.LPAREN, "("); }
")" 				{ return symbol(sym.RPAREN, ")"); }


"&" 				{ return symbol(sym.INTAND, "&"); }
"|" 				{ return symbol(sym.INTOR, "|"); }
"^" 				{ return symbol(sym.INTXOR, "^"); }
"~" 				{ return symbol(sym.INTNOT, "~"); }
"<<" 				{ return symbol(sym.LDESP, "<<"); }
">>" 				{ return symbol(sym.RDESP, ">>"); }

"\""				{ return symbol(sym.COMILLADOBLE, "\""); }
"\"\"\""			{ return symbol(sym.COMILLATRIPLE, "\"\"\""); }

"and" 				{ return symbol(sym.AND, "and"); }
"or" 				{ return symbol(sym.OR, "or"); }
"not" 				{ return symbol(sym.NOT, "not"); }
"==" 				{ return symbol(sym.EQUAL, "=="); }
"!=" 				{ return symbol(sym.DIFF, "!="); }
"<" 				{ return symbol(sym.MINTO, "<"); }
">" 				{ return symbol(sym.MAXTO, ">"); }
"<=" 				{ return symbol(sym.MINEQ, "<="); }
">=" 				{ return symbol(sym.MAXEQ, ">="); }

"[" 				{ return symbol(sym.LPARENCUADRADO, "["); }
"]" 				{ return symbol(sym.RPARENCUADRADO, "]"); }

"," 				{ return symbol(sym.COMMA, ","); }

"{" 				{ return symbol(sym.LPARENCORCHETE, "{"); }
"}" 				{ return symbol(sym.RPARENCORCHETE, "}"); }

":" 				{ return symbol(sym.DOSPUNTOS, ":"); }

"when" 				{ return symbol(sym.WHEN, "when"); }
"if" 				{ return symbol(sym.IF, "if"); }
"else" 				{ return symbol(sym.ELSE, "else"); }
"break"				{ return symbol(sym.BREAK, "break"); }
"continue"			{ return symbol(sym.CONTINUE, "continue"); }
"for" 				{ return symbol(sym.FOR, "for"); }
"in" 				{ return symbol(sym.IN, "in"); }

"print" 			{ return symbol(sym.PRINT, "print"); }


{Identifier}		{ return symbol(sym.ID, yytext()); }

{IntegerLiteral}	{ return symbol(sym.INTEGRAL, yytext()); }
					
{FloatLiteral} 		{ return symbol(sym.DECIMAL, yytext()); }

{WhiteSpace}        { /* ignore*/ }

. 					{
						throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
					}



