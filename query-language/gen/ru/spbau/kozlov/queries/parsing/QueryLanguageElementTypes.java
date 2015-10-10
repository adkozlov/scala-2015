// This is a generated file. Not intended for manual editing.
package ru.spbau.kozlov.queries.parsing;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import ru.spbau.kozlov.queries.psi.QueryLanguageElementType;
import ru.spbau.kozlov.queries.psi.*;

public interface QueryLanguageElementTypes {

  IElementType QUERY_LANGUAGE_ADDITION_EXPRESSION_SUFFIX = new QueryLanguageElementType("QUERY_LANGUAGE_ADDITION_EXPRESSION_SUFFIX");
  IElementType QUERY_LANGUAGE_INVOLUTION_EXPRESSION_SUFFIX = new QueryLanguageElementType("QUERY_LANGUAGE_INVOLUTION_EXPRESSION_SUFFIX");
  IElementType QUERY_LANGUAGE_MULTIPLICATION_EXPRESSION_SUFFIX = new QueryLanguageElementType("QUERY_LANGUAGE_MULTIPLICATION_EXPRESSION_SUFFIX");
  IElementType QUERY_LANGUAGE_OR_QUERY_SUFFIX = new QueryLanguageElementType("QUERY_LANGUAGE_OR_QUERY_SUFFIX");
  IElementType QUERY_LANGUAGE_QUERY = new QueryLanguageElementType("QUERY_LANGUAGE_QUERY");

  IElementType QUERY_LANGUAGE_ABS = new QueryLanguageElementType("abs");
  IElementType QUERY_LANGUAGE_ADDITION_OPERATOR = new QueryLanguageElementType("+");
  IElementType QUERY_LANGUAGE_ARCCOS = new QueryLanguageElementType("arccos");
  IElementType QUERY_LANGUAGE_ARCSIN = new QueryLanguageElementType("arcsin");
  IElementType QUERY_LANGUAGE_ARCTAN = new QueryLanguageElementType("arctan");
  IElementType QUERY_LANGUAGE_ASTERISK = new QueryLanguageElementType("ASTERISK");
  IElementType QUERY_LANGUAGE_CACHED_KEYWORD = new QueryLanguageElementType("cached");
  IElementType QUERY_LANGUAGE_COLON = new QueryLanguageElementType(":");
  IElementType QUERY_LANGUAGE_COS = new QueryLanguageElementType("cos");
  IElementType QUERY_LANGUAGE_DEFINE_KEYWORD = new QueryLanguageElementType("define");
  IElementType QUERY_LANGUAGE_DIVISION_OPERATOR = new QueryLanguageElementType("/");
  IElementType QUERY_LANGUAGE_DOLLAR = new QueryLanguageElementType("dollar");
  IElementType QUERY_LANGUAGE_DOLLAR_SIGN = new QueryLanguageElementType("$");
  IElementType QUERY_LANGUAGE_E = new QueryLanguageElementType("e");
  IElementType QUERY_LANGUAGE_EURO = new QueryLanguageElementType("euro");
  IElementType QUERY_LANGUAGE_EURO_SIGN = new QueryLanguageElementType("€");
  IElementType QUERY_LANGUAGE_EXP = new QueryLanguageElementType("exp");
  IElementType QUERY_LANGUAGE_FACTORIAL = new QueryLanguageElementType("!");
  IElementType QUERY_LANGUAGE_FLOAT = new QueryLanguageElementType("FLOAT");
  IElementType QUERY_LANGUAGE_GAMMA = new QueryLanguageElementType("gamma");
  IElementType QUERY_LANGUAGE_I = new QueryLanguageElementType("i");
  IElementType QUERY_LANGUAGE_INTEGER = new QueryLanguageElementType("INTEGER");
  IElementType QUERY_LANGUAGE_INTO_KEYWORD = new QueryLanguageElementType("into");
  IElementType QUERY_LANGUAGE_INVOLUTION_OPERATOR_1 = new QueryLanguageElementType("^");
  IElementType QUERY_LANGUAGE_INVOLUTION_OPERATOR_2 = new QueryLanguageElementType("**");
  IElementType QUERY_LANGUAGE_IN_KEYWORD = new QueryLanguageElementType("in");
  IElementType QUERY_LANGUAGE_KILOMETRE = new QueryLanguageElementType("km");
  IElementType QUERY_LANGUAGE_LEFT_PAREN = new QueryLanguageElementType("(");
  IElementType QUERY_LANGUAGE_LG = new QueryLanguageElementType("lg");
  IElementType QUERY_LANGUAGE_LN = new QueryLanguageElementType("ln");
  IElementType QUERY_LANGUAGE_LOG = new QueryLanguageElementType("log");
  IElementType QUERY_LANGUAGE_METRE = new QueryLanguageElementType("m");
  IElementType QUERY_LANGUAGE_MODULO_OPERATOR_1 = new QueryLanguageElementType("%");
  IElementType QUERY_LANGUAGE_MODULO_OPERATOR_2 = new QueryLanguageElementType("mod");
  IElementType QUERY_LANGUAGE_MULTIPLICATION_OPERATOR = new QueryLanguageElementType("*");
  IElementType QUERY_LANGUAGE_OR_OPERATOR_1 = new QueryLanguageElementType("OR");
  IElementType QUERY_LANGUAGE_OR_OPERATOR_2 = new QueryLanguageElementType("|");
  IElementType QUERY_LANGUAGE_PI = new QueryLanguageElementType("pi");
  IElementType QUERY_LANGUAGE_QUOTATION_MARK = new QueryLanguageElementType("\"");
  IElementType QUERY_LANGUAGE_RANGE = new QueryLanguageElementType("..");
  IElementType QUERY_LANGUAGE_RIGHT_PAREN = new QueryLanguageElementType(")");
  IElementType QUERY_LANGUAGE_SIN = new QueryLanguageElementType("sin");
  IElementType QUERY_LANGUAGE_SUBSTRACTION_OPERATOR = new QueryLanguageElementType("-");
  IElementType QUERY_LANGUAGE_TAN = new QueryLanguageElementType("tan");
  IElementType QUERY_LANGUAGE_TILDE = new QueryLanguageElementType("~");
  IElementType QUERY_LANGUAGE_TIME_KEYWORD = new QueryLanguageElementType("time");
  IElementType QUERY_LANGUAGE_TRANSLATE_KEYWORD = new QueryLanguageElementType("translate");
  IElementType QUERY_LANGUAGE_WEATHER_KEYWORD = new QueryLanguageElementType("weather");
  IElementType QUERY_LANGUAGE_WORD = new QueryLanguageElementType("WORD");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
       if (type == QUERY_LANGUAGE_ADDITION_EXPRESSION_SUFFIX) {
        return new QueryLanguageAdditionExpressionSuffixImpl(node);
      }
      else if (type == QUERY_LANGUAGE_INVOLUTION_EXPRESSION_SUFFIX) {
        return new QueryLanguageInvolutionExpressionSuffixImpl(node);
      }
      else if (type == QUERY_LANGUAGE_MULTIPLICATION_EXPRESSION_SUFFIX) {
        return new QueryLanguageMultiplicationExpressionSuffixImpl(node);
      }
      else if (type == QUERY_LANGUAGE_OR_QUERY_SUFFIX) {
        return new QueryLanguageOrQuerySuffixImpl(node);
      }
      else if (type == QUERY_LANGUAGE_QUERY) {
        return new QueryLanguageQueryImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
