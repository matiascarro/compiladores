/* The following code was generated by JFlex 1.4.1 on 17/07/15 1:43 */

package com.language.parser;

import java.util.*;
import java_cup.runtime.*;
import com.language.exceptions.*;
import com.language.model.expression.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 17/07/15 1:43 from the specification file
 * <tt>C:/Users/Mati/git/compiladores/Compilador/language/jflex/Scanner.jflex</tt>
 */
class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\5\1\74\1\2\1\0\1\3\1\1\16\5\4\0\1\3\1\36"+
    "\1\73\1\0\1\4\1\21\1\22\1\75\1\17\1\20\1\14\1\12"+
    "\1\47\1\13\1\10\1\15\1\6\11\7\1\70\1\71\1\26\1\16"+
    "\1\27\2\0\5\4\1\37\5\4\1\11\7\4\1\43\6\4\1\45"+
    "\1\0\1\46\1\24\1\51\1\0\1\30\1\4\1\60\1\32\1\42"+
    "\1\61\1\63\1\50\1\54\1\62\1\52\1\40\1\55\1\31\1\33"+
    "\1\56\1\4\1\34\1\41\1\35\1\44\1\57\1\72\1\64\1\53"+
    "\1\65\1\66\1\23\1\67\1\25\41\5\2\0\4\4\4\0\1\4"+
    "\2\0\1\5\7\0\1\4\4\0\1\4\5\0\27\4\1\0\37\4"+
    "\1\0\u01ca\4\4\0\14\4\16\0\5\4\7\0\1\4\1\0\1\4"+
    "\21\0\160\5\5\4\1\0\2\4\2\0\4\4\10\0\1\4\1\0"+
    "\3\4\1\0\1\4\1\0\24\4\1\0\123\4\1\0\213\4\1\0"+
    "\5\5\2\0\236\4\11\0\46\4\2\0\1\4\7\0\47\4\7\0"+
    "\1\4\1\0\55\5\1\0\1\5\1\0\2\5\1\0\2\5\1\0"+
    "\1\5\10\0\33\4\5\0\3\4\15\0\5\5\6\0\1\4\4\0"+
    "\13\5\5\0\53\4\37\5\4\0\2\4\1\5\143\4\1\0\1\4"+
    "\10\5\1\0\6\5\2\4\2\5\1\0\4\5\2\4\12\5\3\4"+
    "\2\0\1\4\17\0\1\5\1\4\1\5\36\4\33\5\2\0\131\4"+
    "\13\5\1\4\16\0\12\5\41\4\11\5\2\4\4\0\1\4\5\0"+
    "\26\4\4\5\1\4\11\5\1\4\3\5\1\4\5\5\22\0\31\4"+
    "\3\5\104\0\1\4\1\0\13\4\67\0\33\5\1\0\4\5\66\4"+
    "\3\5\1\4\22\5\1\4\7\5\12\4\2\5\2\0\12\5\1\0"+
    "\7\4\1\0\7\4\1\0\3\5\1\0\10\4\2\0\2\4\2\0"+
    "\26\4\1\0\7\4\1\0\1\4\3\0\4\4\2\0\1\5\1\4"+
    "\7\5\2\0\2\5\2\0\3\5\1\4\10\0\1\5\4\0\2\4"+
    "\1\0\3\4\2\5\2\0\12\5\4\4\7\0\1\4\5\0\3\5"+
    "\1\0\6\4\4\0\2\4\2\0\26\4\1\0\7\4\1\0\2\4"+
    "\1\0\2\4\1\0\2\4\2\0\1\5\1\0\5\5\4\0\2\5"+
    "\2\0\3\5\3\0\1\5\7\0\4\4\1\0\1\4\7\0\14\5"+
    "\3\4\1\5\13\0\3\5\1\0\11\4\1\0\3\4\1\0\26\4"+
    "\1\0\7\4\1\0\2\4\1\0\5\4\2\0\1\5\1\4\10\5"+
    "\1\0\3\5\1\0\3\5\2\0\1\4\17\0\2\4\2\5\2\0"+
    "\12\5\1\0\1\4\17\0\3\5\1\0\10\4\2\0\2\4\2\0"+
    "\26\4\1\0\7\4\1\0\2\4\1\0\5\4\2\0\1\5\1\4"+
    "\7\5\2\0\2\5\2\0\3\5\10\0\2\5\4\0\2\4\1\0"+
    "\3\4\2\5\2\0\12\5\1\0\1\4\20\0\1\5\1\4\1\0"+
    "\6\4\3\0\3\4\1\0\4\4\3\0\2\4\1\0\1\4\1\0"+
    "\2\4\3\0\2\4\3\0\3\4\3\0\14\4\4\0\5\5\3\0"+
    "\3\5\1\0\4\5\2\0\1\4\6\0\1\5\16\0\12\5\11\0"+
    "\1\4\7\0\3\5\1\0\10\4\1\0\3\4\1\0\27\4\1\0"+
    "\12\4\1\0\5\4\3\0\1\4\7\5\1\0\3\5\1\0\4\5"+
    "\7\0\2\5\1\0\2\4\6\0\2\4\2\5\2\0\12\5\22\0"+
    "\2\5\1\0\10\4\1\0\3\4\1\0\27\4\1\0\12\4\1\0"+
    "\5\4\2\0\1\5\1\4\7\5\1\0\3\5\1\0\4\5\7\0"+
    "\2\5\7\0\1\4\1\0\2\4\2\5\2\0\12\5\1\0\2\4"+
    "\17\0\2\5\1\0\10\4\1\0\3\4\1\0\51\4\2\0\1\4"+
    "\7\5\1\0\3\5\1\0\4\5\1\4\10\0\1\5\10\0\2\4"+
    "\2\5\2\0\12\5\12\0\6\4\2\0\2\5\1\0\22\4\3\0"+
    "\30\4\1\0\11\4\1\0\1\4\2\0\7\4\3\0\1\5\4\0"+
    "\6\5\1\0\1\5\1\0\10\5\22\0\2\5\15\0\60\4\1\5"+
    "\2\4\7\5\4\0\10\4\10\5\1\0\12\5\47\0\2\4\1\0"+
    "\1\4\2\0\2\4\1\0\1\4\2\0\1\4\6\0\4\4\1\0"+
    "\7\4\1\0\3\4\1\0\1\4\1\0\1\4\2\0\2\4\1\0"+
    "\4\4\1\5\2\4\6\5\1\0\2\5\1\4\2\0\5\4\1\0"+
    "\1\4\1\0\6\5\2\0\12\5\2\0\4\4\40\0\1\4\27\0"+
    "\2\5\6\0\12\5\13\0\1\5\1\0\1\5\1\0\1\5\4\0"+
    "\2\5\10\4\1\0\44\4\4\0\24\5\1\0\2\5\5\4\13\5"+
    "\1\0\44\5\11\0\1\5\71\0\53\4\24\5\1\4\12\5\6\0"+
    "\6\4\4\5\4\4\3\5\1\4\3\5\2\4\7\5\3\4\4\5"+
    "\15\4\14\5\1\4\17\5\2\0\46\4\1\0\1\4\5\0\1\4"+
    "\2\0\53\4\1\0\u014d\4\1\0\4\4\2\0\7\4\1\0\1\4"+
    "\1\0\4\4\2\0\51\4\1\0\4\4\2\0\41\4\1\0\4\4"+
    "\2\0\7\4\1\0\1\4\1\0\4\4\2\0\17\4\1\0\71\4"+
    "\1\0\4\4\2\0\103\4\2\0\3\5\40\0\20\4\20\0\125\4"+
    "\14\0\u026c\4\2\0\21\4\1\0\32\4\5\0\113\4\3\0\3\4"+
    "\17\0\15\4\1\0\4\4\3\5\13\0\22\4\3\5\13\0\22\4"+
    "\2\5\14\0\15\4\1\0\3\4\1\0\2\5\14\0\64\4\40\5"+
    "\3\0\1\4\3\0\2\4\1\5\2\0\12\5\41\0\3\5\2\0"+
    "\12\5\6\0\130\4\10\0\51\4\1\5\1\4\5\0\106\4\12\0"+
    "\35\4\3\0\14\5\4\0\14\5\12\0\12\5\36\4\2\0\5\4"+
    "\13\0\54\4\4\0\21\5\7\4\2\5\6\0\12\5\46\0\27\4"+
    "\5\5\4\0\65\4\12\5\1\0\35\5\2\0\13\5\6\0\12\5"+
    "\15\0\1\4\130\0\5\5\57\4\21\5\7\4\4\0\12\5\21\0"+
    "\11\5\14\0\3\5\36\4\15\5\2\4\12\5\54\4\16\5\14\0"+
    "\44\4\24\5\10\0\12\5\3\0\3\4\12\5\44\4\122\0\3\5"+
    "\1\0\25\5\4\4\1\5\4\4\3\5\2\4\11\0\300\4\47\5"+
    "\25\0\4\5\u0116\4\2\0\6\4\2\0\46\4\2\0\6\4\2\0"+
    "\10\4\1\0\1\4\1\0\1\4\1\0\1\4\1\0\37\4\2\0"+
    "\65\4\1\0\7\4\1\0\1\4\3\0\3\4\1\0\7\4\3\0"+
    "\4\4\2\0\6\4\4\0\15\4\5\0\3\4\1\0\7\4\16\0"+
    "\5\5\32\0\5\5\20\0\2\4\23\0\1\4\13\0\5\5\5\0"+
    "\6\5\1\0\1\4\15\0\1\4\20\0\15\4\3\0\33\4\25\0"+
    "\15\5\4\0\1\5\3\0\14\5\21\0\1\4\4\0\1\4\2\0"+
    "\12\4\1\0\1\4\3\0\5\4\6\0\1\4\1\0\1\4\1\0"+
    "\1\4\1\0\4\4\1\0\13\4\2\0\4\4\5\0\5\4\4\0"+
    "\1\4\21\0\51\4\u0a77\0\57\4\1\0\57\4\1\0\205\4\6\0"+
    "\4\4\3\5\2\4\14\0\46\4\1\0\1\4\5\0\1\4\2\0"+
    "\70\4\7\0\1\4\17\0\1\5\27\4\11\0\7\4\1\0\7\4"+
    "\1\0\7\4\1\0\7\4\1\0\7\4\1\0\7\4\1\0\7\4"+
    "\1\0\7\4\1\0\40\5\57\0\1\4\u01d5\0\3\4\31\0\11\4"+
    "\6\5\1\0\5\4\2\0\5\4\4\0\126\4\2\0\2\5\2\0"+
    "\3\4\1\0\132\4\1\0\4\4\5\0\51\4\3\0\136\4\21\0"+
    "\33\4\65\0\20\4\u0200\0\u19b6\4\112\0\u51cd\4\63\0\u048d\4\103\0"+
    "\56\4\2\0\u010d\4\3\0\20\4\12\5\2\4\24\0\57\4\1\5"+
    "\4\0\12\5\1\0\31\4\7\0\1\5\120\4\2\5\45\0\11\4"+
    "\2\0\147\4\2\0\4\4\1\0\4\4\14\0\13\4\115\0\12\4"+
    "\1\5\3\4\1\5\4\4\1\5\27\4\5\5\20\0\1\4\7\0"+
    "\64\4\14\0\2\5\62\4\21\5\13\0\12\5\6\0\22\5\6\4"+
    "\3\0\1\4\4\0\12\5\34\4\10\5\2\0\27\4\15\5\14\0"+
    "\35\4\3\0\4\5\57\4\16\5\16\0\1\4\12\5\46\0\51\4"+
    "\16\5\11\0\3\4\1\5\10\4\2\5\2\0\12\5\6\0\27\4"+
    "\3\0\1\4\1\5\4\0\60\4\1\5\1\4\3\5\2\4\2\5"+
    "\5\4\2\5\1\4\1\5\1\4\30\0\3\4\2\0\13\4\5\5"+
    "\2\0\3\4\2\5\12\0\6\4\2\0\6\4\2\0\6\4\11\0"+
    "\7\4\1\0\7\4\221\0\43\4\10\5\1\0\2\5\2\0\12\5"+
    "\6\0\u2ba4\4\14\0\27\4\4\0\61\4\u2104\0\u016e\4\2\0\152\4"+
    "\46\0\7\4\14\0\5\4\5\0\1\4\1\5\12\4\1\0\15\4"+
    "\1\0\5\4\1\0\1\4\1\0\2\4\1\0\2\4\1\0\154\4"+
    "\41\0\u016b\4\22\0\100\4\2\0\66\4\50\0\15\4\3\0\20\5"+
    "\20\0\7\5\14\0\2\4\30\0\3\4\31\0\1\4\6\0\5\4"+
    "\1\0\207\4\2\0\1\5\4\0\1\4\13\0\12\5\7\0\32\4"+
    "\4\0\1\4\1\0\32\4\13\0\131\4\3\0\6\4\2\0\6\4"+
    "\2\0\6\4\2\0\3\4\3\0\2\4\3\0\2\4\22\0\3\5"+
    "\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\2\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\4\3\1\1\5\3\1\24"+
    "\1\25\1\26\10\3\1\27\1\30\1\31\1\32\1\3"+
    "\2\1\1\0\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\3\3\1\43\1\3\1\44\14\3\1\45"+
    "\7\3\1\0\1\46\1\0\1\46\1\47\1\50\1\3"+
    "\1\51\5\3\1\52\10\3\1\53\12\3\1\54\3\3"+
    "\1\55\1\3\1\56\1\3\1\57\6\3\1\60\1\61"+
    "\3\3\1\62\1\3\1\63\1\64\3\3\1\65\1\3"+
    "\1\66\1\67\1\3\1\70\1\71\1\72\1\3\1\73"+
    "\1\3\1\74\1\3\1\75\1\76\1\77\1\3\1\100"+
    "\1\101";

  private static int [] zzUnpackAction() {
    int [] result = new int[164];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\76\0\174\0\76\0\272\0\370\0\u0136\0\76"+
    "\0\76\0\76\0\u0174\0\u01b2\0\u01f0\0\76\0\76\0\76"+
    "\0\76\0\76\0\76\0\76\0\u022e\0\u026c\0\u02aa\0\u02e8"+
    "\0\u0326\0\u0364\0\u03a2\0\u03e0\0\u041e\0\u045c\0\u049a\0\u04d8"+
    "\0\76\0\76\0\76\0\u0516\0\u0554\0\u0592\0\u05d0\0\u060e"+
    "\0\u064c\0\u068a\0\u06c8\0\76\0\76\0\76\0\76\0\u0706"+
    "\0\u0744\0\u0782\0\u07c0\0\76\0\76\0\76\0\76\0\76"+
    "\0\76\0\76\0\76\0\u07fe\0\u083c\0\u087a\0\272\0\u08b8"+
    "\0\76\0\u08f6\0\u0934\0\u0972\0\u09b0\0\u09ee\0\u0a2c\0\u0a6a"+
    "\0\u0aa8\0\u0ae6\0\u0b24\0\u0b62\0\u0ba0\0\272\0\u0bde\0\u0c1c"+
    "\0\u0c5a\0\u0c98\0\u0cd6\0\u0d14\0\u0d52\0\u0744\0\76\0\u0782"+
    "\0\u0782\0\u07c0\0\272\0\u0d90\0\272\0\u0dce\0\u0e0c\0\u0e4a"+
    "\0\u0e88\0\u0ec6\0\u0f04\0\u0f42\0\u0f80\0\u0fbe\0\u0ffc\0\u103a"+
    "\0\u1078\0\u10b6\0\u10f4\0\272\0\u1132\0\u1170\0\u11ae\0\u11ec"+
    "\0\u122a\0\u1268\0\u12a6\0\u12e4\0\u1322\0\u1360\0\272\0\u139e"+
    "\0\u13dc\0\u141a\0\272\0\u1458\0\272\0\u1496\0\272\0\u14d4"+
    "\0\u1512\0\u1550\0\u158e\0\u15cc\0\u160a\0\272\0\272\0\u1648"+
    "\0\u1686\0\u16c4\0\272\0\u1702\0\272\0\272\0\u1740\0\u177e"+
    "\0\u17bc\0\272\0\u17fa\0\272\0\272\0\u1838\0\272\0\272"+
    "\0\272\0\u1876\0\272\0\u18b4\0\272\0\u18f2\0\272\0\272"+
    "\0\272\0\u1930\0\272\0\272";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[164];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\5\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27"+
    "\1\30\1\5\1\31\1\32\1\5\1\33\1\34\1\35"+
    "\1\36\1\37\1\40\1\5\1\41\1\42\1\43\1\44"+
    "\1\5\1\45\1\5\1\46\1\5\1\47\1\50\1\51"+
    "\1\52\1\53\3\5\1\54\1\55\1\56\1\57\1\60"+
    "\1\61\1\4\1\62\100\0\1\4\77\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\6\5\3\0\16\5\4\0"+
    "\1\5\13\0\1\63\1\64\26\0\1\64\43\0\2\7"+
    "\1\63\1\64\26\0\1\64\51\0\1\65\76\0\1\66"+
    "\76\0\1\67\75\0\1\70\7\0\1\71\65\0\1\72"+
    "\10\0\1\73\52\0\4\5\1\0\1\5\16\0\1\5"+
    "\1\74\4\5\1\0\6\5\3\0\6\5\1\75\7\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\3\5"+
    "\1\76\2\5\1\0\6\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\4\5\1\77\1\5"+
    "\1\0\6\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\3\5\1\100\2\5"+
    "\3\0\16\5\4\0\1\5\21\0\1\101\63\0\4\5"+
    "\1\0\1\5\16\0\1\102\5\5\1\0\6\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\3\5\1\103\2\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\6\5\3\0\4\5\1\104\1\5\1\105\7\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\1\5\1\106"+
    "\4\5\1\0\1\5\1\107\4\5\3\0\14\5\1\110"+
    "\1\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\4\5\1\111\1\5\1\0\6\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\1\112\5\5"+
    "\1\0\6\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\3\5\1\113\2\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\1\5\1\114\3\5\1\115\1\0\6\5\3\0"+
    "\11\5\1\116\4\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\3\5\1\117\1\120\1\5\1\0\6\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\1\121\5\5\1\0\6\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\3\5\1\122"+
    "\2\5\1\0\6\5\3\0\16\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\6\5\1\0\6\5\3\0"+
    "\4\5\1\123\11\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\3\5\1\124\2\5\1\0\6\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\6\5\3\0\1\125\15\5\4\0\1\5"+
    "\3\0\1\126\2\0\70\126\1\127\1\0\1\126\1\130"+
    "\2\0\70\130\2\0\1\131\6\0\2\132\72\0\4\5"+
    "\1\0\1\5\16\0\2\5\1\133\3\5\1\0\6\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\6\5\1\0\6\5\3\0\6\5\1\134\7\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\5\5"+
    "\1\135\1\0\6\5\3\0\16\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\6\5\1\0\6\5\3\0"+
    "\6\5\1\136\7\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\1\5\1\137\4\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\1\5\1\140\4\5\1\0\6\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\6\5\3\0\15\5\1\141\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\1\5\1\142\4\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\2\5\1\143\3\5\1\0\6\5\3\0\16\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\6\5"+
    "\1\0\2\5\1\144\3\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\5\5\1\145\1\0"+
    "\6\5\3\0\16\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\5\5\1\146\3\0\16\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\6\5"+
    "\1\0\2\5\1\147\3\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\6\5\1\0\6\5"+
    "\3\0\3\5\1\150\12\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\2\5\1\151\3\5\1\0\2\5"+
    "\1\152\3\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\3\5\1\153\2\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\6\5\1\0\6\5\3\0\6\5\1\154\7\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\6\5"+
    "\1\0\6\5\3\0\4\5\1\155\11\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\6\5\1\0\1\5"+
    "\1\156\4\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\5\5\1\157\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\1\5\1\160\4\5\1\0\6\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\6\5\3\0\4\5\1\161\11\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\6\5\1\0\6\5\3\0"+
    "\4\5\1\162\11\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\3\5\1\163\2\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\1\5\1\164\4\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\2\5\1\165\3\5\3\0\16\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\6\5\1\0\6\5\3\0"+
    "\13\5\1\166\2\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\3\5\1\167\2\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\6\5\3\0\4\5\1\170\11\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\6\5\3\0\4\5\1\171\11\5\4\0\1\172\7\0"+
    "\4\5\1\0\1\5\16\0\6\5\1\0\3\5\1\173"+
    "\2\5\3\0\16\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\3\5\1\174\2\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\3\5\1\175\2\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\6\5\3\0\1\5\1\176\14\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\6\5\1\0\2\5\1\177"+
    "\3\5\3\0\16\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\3\5\1\200\2\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\3\5\1\201\2\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\6\5\3\0\5\5\1\202\10\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\1\5\1\203\4\5\1\0"+
    "\6\5\3\0\16\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\5\5\1\204\3\0\16\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\1\5"+
    "\1\205\4\5\1\0\6\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\2\5\1\206\3\5"+
    "\1\0\6\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\1\5\1\207\4\5\1\0\6\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\6\5\1\0\1\5\1\210\4\5\3\0\16\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\1\5"+
    "\1\211\4\5\1\0\6\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\1\212\5\5\1\0"+
    "\6\5\3\0\16\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\3\5\1\213\2\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\5\5\1\214\1\0\6\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\5\5\1\215\1\0"+
    "\6\5\3\0\16\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\6\5\3\0\11\5\1\216"+
    "\4\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\6\5\3\0\1\217\15\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\1\5\1\220\4\5"+
    "\1\0\6\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\6\5\3\0\2\5"+
    "\1\221\13\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\6\5\1\0\6\5\3\0\14\5\1\222\1\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\4\5"+
    "\1\223\1\5\1\0\6\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\6\5\1\0\2\5"+
    "\1\224\3\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\5\5\1\225\1\0\6\5\3\0"+
    "\16\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\6\5\1\0\3\5\1\226\2\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\5\5\1\227"+
    "\1\0\6\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\3\5\1\230\2\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\2\5\1\231\3\5\1\0\6\5\3\0\16\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\6\5"+
    "\1\0\6\5\3\0\10\5\1\232\5\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\6\5\1\0\6\5"+
    "\3\0\1\233\15\5\4\0\1\5\7\0\4\5\1\0"+
    "\1\5\16\0\6\5\1\0\6\5\3\0\4\5\1\234"+
    "\11\5\4\0\1\5\7\0\4\5\1\0\1\5\16\0"+
    "\2\5\1\235\3\5\1\0\6\5\3\0\16\5\4\0"+
    "\1\5\7\0\4\5\1\0\1\5\16\0\6\5\1\0"+
    "\3\5\1\236\2\5\3\0\16\5\4\0\1\5\7\0"+
    "\4\5\1\0\1\5\16\0\5\5\1\237\1\0\6\5"+
    "\3\0\16\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\6\5\1\0\2\5\1\240\3\5\3\0\16\5"+
    "\4\0\1\5\7\0\4\5\1\0\1\5\16\0\6\5"+
    "\1\0\3\5\1\241\2\5\3\0\16\5\4\0\1\5"+
    "\7\0\4\5\1\0\1\5\16\0\6\5\1\0\1\5"+
    "\1\242\4\5\3\0\16\5\4\0\1\5\7\0\4\5"+
    "\1\0\1\5\16\0\6\5\1\0\6\5\3\0\3\5"+
    "\1\243\12\5\4\0\1\5\7\0\4\5\1\0\1\5"+
    "\16\0\6\5\1\0\3\5\1\244\2\5\3\0\16\5"+
    "\4\0\1\5\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[6510];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\3\1\3\11\3\1\7\11"+
    "\14\1\3\11\10\1\4\11\3\1\1\0\10\11\5\1"+
    "\1\11\24\1\1\0\1\11\1\0\114\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[164];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2262) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 38: 
          { return symbol(sym.STRING, yytext());
          }
        case 66: break;
        case 51: 
          { return symbol(sym.FSPLIT, "split");
          }
        case 67: break;
        case 31: 
          { return symbol(sym.MENOR_IGUAL, "<=");
          }
        case 68: break;
        case 42: 
          { return symbol(sym.END, "end");
          }
        case 69: break;
        case 36: 
          { return symbol(sym.DISTINTO, "!=");
          }
        case 70: break;
        case 8: 
          { return symbol(sym.MULTIPLICACION, "*");
          }
        case 71: break;
        case 62: 
          { return symbol(sym.FVALUES, "values");
          }
        case 72: break;
        case 1: 
          { throw new ParsingException("Illegal character at line " + yyline + ", column " + yycolumn + " >> " + yytext());
          }
        case 73: break;
        case 18: 
          { return symbol(sym.MENOR, "<");
          }
        case 74: break;
        case 3: 
          { return symbol(sym.ID, yytext());
          }
        case 75: break;
        case 56: 
          { return symbol(sym.FCOUNT, "count");
          }
        case 76: break;
        case 22: 
          { return symbol(sym.COMMA, ",");
          }
        case 77: break;
        case 28: 
          { return symbol(sym.EXPONENTE, "**");
          }
        case 78: break;
        case 54: 
          { return symbol(sym.FITEMS, "items");
          }
        case 79: break;
        case 15: 
          { return symbol(sym.BOR, "|");
          }
        case 80: break;
        case 16: 
          { return symbol(sym.BXOR, "^");
          }
        case 81: break;
        case 58: 
          { return symbol(sym.FAPPEND, "append");
          }
        case 82: break;
        case 12: 
          { return symbol(sym.RPAREN, ")");
          }
        case 83: break;
        case 23: 
          { return symbol(sym.LPARENCORCHETE, "{");
          }
        case 84: break;
        case 26: 
          { return symbol(sym.SEPARADOR, ";");
          }
        case 85: break;
        case 4: 
          { return symbol(sym.INT, yytext());
          }
        case 86: break;
        case 49: 
          { return symbol(sym.FJOIN, "join");
          }
        case 87: break;
        case 37: 
          { return symbol(sym.IF, "if");
          }
        case 88: break;
        case 47: 
          { return symbol(sym.FKEYS, "keys");
          }
        case 89: break;
        case 39: 
          { return symbol(sym.FLOAT, yytext());
          }
        case 90: break;
        case 24: 
          { return symbol(sym.RPARENCORCHETE, "}");
          }
        case 91: break;
        case 55: 
          { return symbol(sym.PRINT, "print");
          }
        case 92: break;
        case 33: 
          { return symbol(sym.MAYOR_IGUAL, ">=");
          }
        case 93: break;
        case 60: 
          { return symbol(sym.FEXTEND, "extend");
          }
        case 94: break;
        case 57: 
          { return symbol(sym.WHILE, "while");
          }
        case 95: break;
        case 19: 
          { return symbol(sym.MAYOR, ">");
          }
        case 96: break;
        case 10: 
          { return symbol(sym.EQUAL, "=");
          }
        case 97: break;
        case 30: 
          { return symbol(sym.IGUAL, "==");
          }
        case 98: break;
        case 7: 
          { return symbol(sym.RESTA, "-");
          }
        case 99: break;
        case 44: 
          { return symbol(sym.FSIZE, "size");
          }
        case 100: break;
        case 53: 
          { return symbol(sym.FINDEX, "index");
          }
        case 101: break;
        case 45: 
          { return symbol(sym.ELSE, "else");
          }
        case 102: break;
        case 13: 
          { return symbol(sym.MODULO, "%");
          }
        case 103: break;
        case 9: 
          { return symbol(sym.DIVISION, "/");
          }
        case 104: break;
        case 27: 
          { return symbol(sym.LONG, yytext());
          }
        case 105: break;
        case 41: 
          { return symbol(sym.NOT, "not");
          }
        case 106: break;
        case 20: 
          { return symbol(sym.LPARENCUADRADO, "[");
          }
        case 107: break;
        case 43: 
          { return symbol(sym.FPOP, "pop");
          }
        case 108: break;
        case 11: 
          { return symbol(sym.LPAREN, "(");
          }
        case 109: break;
        case 2: 
          { /* ignore*/
          }
        case 110: break;
        case 63: 
          { return symbol(sym.FREPLACE, "replace");
          }
        case 111: break;
        case 59: 
          { return symbol(sym.FLENGTH, "length");
          }
        case 112: break;
        case 5: 
          { return symbol(sym.DOT, ".");
          }
        case 113: break;
        case 21: 
          { return symbol(sym.RPARENCUADRADO, "]");
          }
        case 114: break;
        case 32: 
          { return symbol(sym.SHIFT_IZQ, "<<");
          }
        case 115: break;
        case 40: 
          { return symbol(sym.AND, "and");
          }
        case 116: break;
        case 6: 
          { return symbol(sym.SUMA, "+");
          }
        case 117: break;
        case 65: 
          { return symbol(sym.ENDWHILE, "endwhile");
          }
        case 118: break;
        case 61: 
          { return symbol(sym.FINSERT, "insert");
          }
        case 119: break;
        case 52: 
          { return symbol(sym.ENDIF, "endif");
          }
        case 120: break;
        case 14: 
          { return symbol(sym.BAND, "&");
          }
        case 121: break;
        case 29: 
          { return symbol(sym.DIVISION_ENTERA, "//");
          }
        case 122: break;
        case 48: 
          { return symbol(sym.FFIND, "find");
          }
        case 123: break;
        case 64: 
          { return symbol(sym.FHASKEY, "has_key");
          }
        case 124: break;
        case 50: 
          { return symbol(sym.BOOLEAN, false);
          }
        case 125: break;
        case 34: 
          { return symbol(sym.SHIFT_DER, ">>");
          }
        case 126: break;
        case 25: 
          { return symbol(sym.DOSPUNTOS, ":");
          }
        case 127: break;
        case 35: 
          { return symbol(sym.OR, "or");
          }
        case 128: break;
        case 46: 
          { return symbol(sym.BOOLEAN, true);
          }
        case 129: break;
        case 17: 
          { return symbol(sym.COMPLEMENTO, "~");
          }
        case 130: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return symbol(sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
