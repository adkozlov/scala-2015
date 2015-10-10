package ru.spbau.kozlov.queries.lexer;
import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;
import static ru.spbau.kozlov.queries.parsing.QueryLanguageElementTypes.*;

%%

%{
  public _QueryLanguageLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _QueryLanguageLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL="\r"|"\n"|"\r\n"
LINE_WS=[\ \t\f]
WHITE_SPACE=({LINE_WS}|{EOL})+

WHITE_SPACE=[ \t\n\x0B\f\r]+
INTEGER=[1-9][0-9]*
FLOAT=(0|([1-9][0-9]*))(\.[0-9]*)?
WORD=[a-zA-Z_0-9]+

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return com.intellij.psi.TokenType.WHITE_SPACE; }

  "OR"               { return QUERY_LANGUAGE_OR_OPERATOR_1; }
  "|"                { return QUERY_LANGUAGE_OR_OPERATOR_2; }
  "~"                { return QUERY_LANGUAGE_TILDE; }
  "\""               { return QUERY_LANGUAGE_QUOTATION_MARK; }
  "*"                { return QUERY_LANGUAGE_MULTIPLICATION_OPERATOR; }
  ".."               { return QUERY_LANGUAGE_RANGE; }
  ":"                { return QUERY_LANGUAGE_COLON; }
  "weather"          { return QUERY_LANGUAGE_WEATHER_KEYWORD; }
  "time"             { return QUERY_LANGUAGE_TIME_KEYWORD; }
  "define"           { return QUERY_LANGUAGE_DEFINE_KEYWORD; }
  "cached"           { return QUERY_LANGUAGE_CACHED_KEYWORD; }
  "translate"        { return QUERY_LANGUAGE_TRANSLATE_KEYWORD; }
  "into"             { return QUERY_LANGUAGE_INTO_KEYWORD; }
  "in"               { return QUERY_LANGUAGE_IN_KEYWORD; }
  "+"                { return QUERY_LANGUAGE_ADDITION_OPERATOR; }
  "-"                { return QUERY_LANGUAGE_SUBSTRACTION_OPERATOR; }
  "/"                { return QUERY_LANGUAGE_DIVISION_OPERATOR; }
  "%"                { return QUERY_LANGUAGE_MODULO_OPERATOR_1; }
  "mod"              { return QUERY_LANGUAGE_MODULO_OPERATOR_2; }
  "^"                { return QUERY_LANGUAGE_INVOLUTION_OPERATOR_1; }
  "**"               { return QUERY_LANGUAGE_INVOLUTION_OPERATOR_2; }
  "abs"              { return QUERY_LANGUAGE_ABS; }
  "sin"              { return QUERY_LANGUAGE_SIN; }
  "cos"              { return QUERY_LANGUAGE_COS; }
  "tan"              { return QUERY_LANGUAGE_TAN; }
  "arcsin"           { return QUERY_LANGUAGE_ARCSIN; }
  "arccos"           { return QUERY_LANGUAGE_ARCCOS; }
  "arctan"           { return QUERY_LANGUAGE_ARCTAN; }
  "ln"               { return QUERY_LANGUAGE_LN; }
  "log"              { return QUERY_LANGUAGE_LOG; }
  "lg"               { return QUERY_LANGUAGE_LG; }
  "exp"              { return QUERY_LANGUAGE_EXP; }
  "!"                { return QUERY_LANGUAGE_FACTORIAL; }
  "("                { return QUERY_LANGUAGE_LEFT_PAREN; }
  ")"                { return QUERY_LANGUAGE_RIGHT_PAREN; }
  "e"                { return QUERY_LANGUAGE_E; }
  "pi"               { return QUERY_LANGUAGE_PI; }
  "i"                { return QUERY_LANGUAGE_I; }
  "gamma"            { return QUERY_LANGUAGE_GAMMA; }
  "m"                { return QUERY_LANGUAGE_METRE; }
  "km"               { return QUERY_LANGUAGE_KILOMETRE; }
  "$"                { return QUERY_LANGUAGE_DOLLAR_SIGN; }
  "dollar"           { return QUERY_LANGUAGE_DOLLAR; }
  "€"                { return QUERY_LANGUAGE_EURO_SIGN; }
  "euro"             { return QUERY_LANGUAGE_EURO; }
  "ASTERISK"         { return QUERY_LANGUAGE_ASTERISK; }

  {WHITE_SPACE}      { return QUERY_LANGUAGE_WHITE_SPACE; }
  {INTEGER}          { return QUERY_LANGUAGE_INTEGER; }
  {FLOAT}            { return QUERY_LANGUAGE_FLOAT; }
  {WORD}             { return QUERY_LANGUAGE_WORD; }

  [^] { return com.intellij.psi.TokenType.BAD_CHARACTER; }
}
