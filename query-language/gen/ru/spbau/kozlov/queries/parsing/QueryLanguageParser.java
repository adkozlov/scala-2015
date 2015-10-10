// This is a generated file. Not intended for manual editing.
package ru.spbau.kozlov.queries.parsing;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static ru.spbau.kozlov.queries.parsing.QueryLanguageElementTypes.*;
import static ru.spbau.kozlov.queries.parsing.QueryLanguageParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class QueryLanguageParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t == QUERY_LANGUAGE_ADDITION_EXPRESSION_SUFFIX) {
      r = addition_expression_suffix(b, 0);
    }
    else if (t == QUERY_LANGUAGE_INVOLUTION_EXPRESSION_SUFFIX) {
      r = involution_expression_suffix(b, 0);
    }
    else if (t == QUERY_LANGUAGE_MULTIPLICATION_EXPRESSION_SUFFIX) {
      r = multiplication_expression_suffix(b, 0);
    }
    else if (t == QUERY_LANGUAGE_OR_QUERY_SUFFIX) {
      r = or_query_suffix(b, 0);
    }
    else if (t == QUERY_LANGUAGE_QUERY) {
      r = query(b, 0);
    }
    else {
      r = parse_root_(t, b, 0);
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return queries(b, l + 1);
  }

  /* ********************************************************** */
  // multiplication_expression addition_expression_suffix*
  static boolean addition_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addition_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplication_expression(b, l + 1);
    r = r && addition_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // addition_expression_suffix*
  private static boolean addition_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addition_expression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!addition_expression_suffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "addition_expression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // addition_operation multiplication_expression
  public static boolean addition_expression_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addition_expression_suffix")) return false;
    if (!nextTokenIs(b, "<addition expression suffix>", QUERY_LANGUAGE_ADDITION_OPERATOR, QUERY_LANGUAGE_SUBSTRACTION_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<addition expression suffix>");
    r = addition_operation(b, l + 1);
    r = r && multiplication_expression(b, l + 1);
    exit_section_(b, l, m, QUERY_LANGUAGE_ADDITION_EXPRESSION_SUFFIX, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ADDITION_OPERATOR | SUBSTRACTION_OPERATOR
  static boolean addition_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "addition_operation")) return false;
    if (!nextTokenIs(b, "", QUERY_LANGUAGE_ADDITION_OPERATOR, QUERY_LANGUAGE_SUBSTRACTION_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_ADDITION_OPERATOR);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_SUBSTRACTION_OPERATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // word_query+
  static boolean and_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = word_query(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!word_query(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "and_query", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // addition_expression
  static boolean arithmetic_expression(PsiBuilder b, int l) {
    return addition_expression(b, l + 1);
  }

  /* ********************************************************** */
  // CACHED_KEYWORD COLON? WORD+
  static boolean cached_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cached_query")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_CACHED_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_CACHED_KEYWORD);
    r = r && cached_query_1(b, l + 1);
    r = r && cached_query_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean cached_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cached_query_1")) return false;
    consumeToken(b, QUERY_LANGUAGE_COLON);
    return true;
  }

  // WORD+
  private static boolean cached_query_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cached_query_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_WORD);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, QUERY_LANGUAGE_WORD)) break;
      if (!empty_element_parsed_guard_(b, "cached_query_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // arithmetic_expression IN_KEYWORD suffix_dimension
  static boolean convert_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "convert_query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arithmetic_expression(b, l + 1);
    r = r && consumeToken(b, QUERY_LANGUAGE_IN_KEYWORD);
    r = r && suffix_dimension(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEFINE_KEYWORD COLON? WORD+
  static boolean define_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_query")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_DEFINE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_DEFINE_KEYWORD);
    r = r && define_query_1(b, l + 1);
    r = r && define_query_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean define_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_query_1")) return false;
    consumeToken(b, QUERY_LANGUAGE_COLON);
    return true;
  }

  // WORD+
  private static boolean define_query_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "define_query_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_WORD);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, QUERY_LANGUAGE_WORD)) break;
      if (!empty_element_parsed_guard_(b, "define_query_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // prefix_expression | postfix_expression | primary_expression
  static boolean function_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix_expression(b, l + 1);
    if (!r) r = postfix_expression(b, l + 1);
    if (!r) r = primary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unary_expression involution_expression_suffix?
  static boolean involution_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "involution_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary_expression(b, l + 1);
    r = r && involution_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // involution_expression_suffix?
  private static boolean involution_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "involution_expression_1")) return false;
    involution_expression_suffix(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // involution_operation unary_expression
  public static boolean involution_expression_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "involution_expression_suffix")) return false;
    if (!nextTokenIs(b, "<involution expression suffix>", QUERY_LANGUAGE_INVOLUTION_OPERATOR_1, QUERY_LANGUAGE_INVOLUTION_OPERATOR_2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<involution expression suffix>");
    r = involution_operation(b, l + 1);
    r = r && unary_expression(b, l + 1);
    exit_section_(b, l, m, QUERY_LANGUAGE_INVOLUTION_EXPRESSION_SUFFIX, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // INVOLUTION_OPERATOR_1 | INVOLUTION_OPERATOR_2
  static boolean involution_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "involution_operation")) return false;
    if (!nextTokenIs(b, "", QUERY_LANGUAGE_INVOLUTION_OPERATOR_1, QUERY_LANGUAGE_INVOLUTION_OPERATOR_2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_INVOLUTION_OPERATOR_1);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_INVOLUTION_OPERATOR_2);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // involution_expression multiplication_expression_suffix*
  static boolean multiplication_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplication_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = involution_expression(b, l + 1);
    r = r && multiplication_expression_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // multiplication_expression_suffix*
  private static boolean multiplication_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplication_expression_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!multiplication_expression_suffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplication_expression_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // multiplication_operation involution_expression
  public static boolean multiplication_expression_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplication_expression_suffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<multiplication expression suffix>");
    r = multiplication_operation(b, l + 1);
    r = r && involution_expression(b, l + 1);
    exit_section_(b, l, m, QUERY_LANGUAGE_MULTIPLICATION_EXPRESSION_SUFFIX, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MULTIPLICATION_OPERATOR | DIVISION_OPERATOR | MODULO_OPERATOR_1 | MODULO_OPERATOR_2
  static boolean multiplication_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplication_operation")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_MULTIPLICATION_OPERATOR);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_DIVISION_OPERATOR);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_MODULO_OPERATOR_1);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_MODULO_OPERATOR_2);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER | FLOAT | E | PI | I | GAMMA
  static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_INTEGER);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_FLOAT);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_E);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_PI);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_I);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_GAMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ( number_literal suffix_dimension) | ( prefix_dimension? number_literal )
  static boolean number_literal_with_dimension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_with_dimension")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_literal_with_dimension_0(b, l + 1);
    if (!r) r = number_literal_with_dimension_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // number_literal suffix_dimension
  private static boolean number_literal_with_dimension_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_with_dimension_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_literal(b, l + 1);
    r = r && suffix_dimension(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefix_dimension? number_literal
  private static boolean number_literal_with_dimension_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_with_dimension_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_literal_with_dimension_1_0(b, l + 1);
    r = r && number_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // prefix_dimension?
  private static boolean number_literal_with_dimension_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal_with_dimension_1_0")) return false;
    prefix_dimension(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // OR_OPERATOR_1 | OR_OPERATOR_2
  static boolean or_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_operation")) return false;
    if (!nextTokenIs(b, "", QUERY_LANGUAGE_OR_OPERATOR_1, QUERY_LANGUAGE_OR_OPERATOR_2)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_OR_OPERATOR_1);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_OR_OPERATOR_2);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // and_query or_query_suffix *
  static boolean or_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = and_query(b, l + 1);
    r = r && or_query_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // or_query_suffix *
  private static boolean or_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_query_1")) return false;
    int c = current_position_(b);
    while (true) {
      if (!or_query_suffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "or_query_1", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // or_operation and_query
  public static boolean or_query_suffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_query_suffix")) return false;
    if (!nextTokenIs(b, "<or query suffix>", QUERY_LANGUAGE_OR_OPERATOR_1, QUERY_LANGUAGE_OR_OPERATOR_2)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _LEFT_, "<or query suffix>");
    r = or_operation(b, l + 1);
    r = r && and_query(b, l + 1);
    exit_section_(b, l, m, QUERY_LANGUAGE_OR_QUERY_SUFFIX, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PAREN addition_expression RIGHT_PAREN
  static boolean paren_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expression")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_LEFT_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_LEFT_PAREN);
    r = r && addition_expression(b, l + 1);
    r = r && consumeToken(b, QUERY_LANGUAGE_RIGHT_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // primary_expression postfix_operation
  static boolean postfix_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfix_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = primary_expression(b, l + 1);
    r = r && postfix_operation(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FACTORIAL
  static boolean postfix_operation(PsiBuilder b, int l) {
    return consumeToken(b, QUERY_LANGUAGE_FACTORIAL);
  }

  /* ********************************************************** */
  // DOLLAR_SIGN | EURO_SIGN
  static boolean prefix_dimension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_dimension")) return false;
    if (!nextTokenIs(b, "", QUERY_LANGUAGE_DOLLAR_SIGN, QUERY_LANGUAGE_EURO_SIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_DOLLAR_SIGN);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_EURO_SIGN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // prefix_operation primary_expression
  static boolean prefix_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefix_operation(b, l + 1);
    r = r && primary_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ABS | SIN | COS | TAN | ARCSIN | ARCCOS | ARCTAN | LN | LOG | LG | EXP
  static boolean prefix_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefix_operation")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_ABS);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_SIN);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_COS);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_TAN);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_ARCSIN);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_ARCCOS);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_ARCTAN);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_LN);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_LOG);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_LG);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_EXP);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // paren_expression | number_literal_with_dimension
  static boolean primary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = paren_expression(b, l + 1);
    if (!r) r = number_literal_with_dimension(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // query*
  static boolean queries(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "queries")) return false;
    int c = current_position_(b);
    while (true) {
      if (!query(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "queries", c)) break;
      c = current_position_(b);
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> ( text_query | weather_query | time_query | define_query | cached_query | translate_query | convert_query | arithmetic_expression)
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, "<query>");
    r = query_0(b, l + 1);
    r = r && query_1(b, l + 1);
    exit_section_(b, l, m, QUERY_LANGUAGE_QUERY, r, false, null);
    return r;
  }

  // !<<eof>>
  private static boolean query_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_, null);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, null, r, false, null);
    return r;
  }

  // text_query | weather_query | time_query | define_query | cached_query | translate_query | convert_query | arithmetic_expression
  private static boolean query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = text_query(b, l + 1);
    if (!r) r = weather_query(b, l + 1);
    if (!r) r = time_query(b, l + 1);
    if (!r) r = define_query(b, l + 1);
    if (!r) r = cached_query(b, l + 1);
    if (!r) r = translate_query(b, l + 1);
    if (!r) r = convert_query(b, l + 1);
    if (!r) r = arithmetic_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTATION_MARK single_word_query+ QUOTATION_MARK
  static boolean quotation_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quotation_query")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_QUOTATION_MARK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_QUOTATION_MARK);
    r = r && quotation_query_1(b, l + 1);
    r = r && consumeToken(b, QUERY_LANGUAGE_QUOTATION_MARK);
    exit_section_(b, m, null, r);
    return r;
  }

  // single_word_query+
  private static boolean quotation_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "quotation_query_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = single_word_query(b, l + 1);
    int c = current_position_(b);
    while (r) {
      if (!single_word_query(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "quotation_query_1", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // number_literal_with_dimension RANGE number_literal_with_dimension
  static boolean range_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "range_query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_literal_with_dimension(b, l + 1);
    r = r && consumeToken(b, QUERY_LANGUAGE_RANGE);
    r = r && number_literal_with_dimension(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WORD | word_placeholder
  static boolean single_word_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_word_query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_WORD);
    if (!r) r = word_placeholder(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOLLAR | EURO | METRE | KILOMETRE
  static boolean suffix_dimension(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "suffix_dimension")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_DOLLAR);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_EURO);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_METRE);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_KILOMETRE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // or_query
  static boolean text_query(PsiBuilder b, int l) {
    return or_query(b, l + 1);
  }

  /* ********************************************************** */
  // TIME_KEYWORD COLON? WORD
  static boolean time_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "time_query")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_TIME_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_TIME_KEYWORD);
    r = r && time_query_1(b, l + 1);
    r = r && consumeToken(b, QUERY_LANGUAGE_WORD);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean time_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "time_query_1")) return false;
    consumeToken(b, QUERY_LANGUAGE_COLON);
    return true;
  }

  /* ********************************************************** */
  // TRANSLATE_KEYWORD COLON? WORD+ INTO_KEYWORD WORD
  static boolean translate_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translate_query")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_TRANSLATE_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_TRANSLATE_KEYWORD);
    r = r && translate_query_1(b, l + 1);
    r = r && translate_query_2(b, l + 1);
    r = r && consumeTokens(b, 0, QUERY_LANGUAGE_INTO_KEYWORD, QUERY_LANGUAGE_WORD);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean translate_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translate_query_1")) return false;
    consumeToken(b, QUERY_LANGUAGE_COLON);
    return true;
  }

  // WORD+
  private static boolean translate_query_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "translate_query_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_WORD);
    int c = current_position_(b);
    while (r) {
      if (!consumeToken(b, QUERY_LANGUAGE_WORD)) break;
      if (!empty_element_parsed_guard_(b, "translate_query_2", c)) break;
      c = current_position_(b);
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unary_operation? function_expression
  static boolean unary_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unary_expression_0(b, l + 1);
    r = r && function_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unary_operation?
  private static boolean unary_expression_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expression_0")) return false;
    unary_operation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ADDITION_OPERATOR | SUBSTRACTION_OPERATOR
  static boolean unary_operation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_operation")) return false;
    if (!nextTokenIs(b, "", QUERY_LANGUAGE_ADDITION_OPERATOR, QUERY_LANGUAGE_SUBSTRACTION_OPERATOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_ADDITION_OPERATOR);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_SUBSTRACTION_OPERATOR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WEATHER_KEYWORD COLON? WORD
  static boolean weather_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "weather_query")) return false;
    if (!nextTokenIs(b, QUERY_LANGUAGE_WEATHER_KEYWORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_WEATHER_KEYWORD);
    r = r && weather_query_1(b, l + 1);
    r = r && consumeToken(b, QUERY_LANGUAGE_WORD);
    exit_section_(b, m, null, r);
    return r;
  }

  // COLON?
  private static boolean weather_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "weather_query_1")) return false;
    consumeToken(b, QUERY_LANGUAGE_COLON);
    return true;
  }

  /* ********************************************************** */
  // ASTERISK | range_query
  static boolean word_placeholder(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word_placeholder")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_ASTERISK);
    if (!r) r = range_query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // word_query_operator? ( quotation_query | single_word_query )
  static boolean word_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word_query")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = word_query_0(b, l + 1);
    r = r && word_query_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // word_query_operator?
  private static boolean word_query_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word_query_0")) return false;
    word_query_operator(b, l + 1);
    return true;
  }

  // quotation_query | single_word_query
  private static boolean word_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word_query_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = quotation_query(b, l + 1);
    if (!r) r = single_word_query(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SUBSTRACTION_OPERATOR | TILDE
  static boolean word_query_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "word_query_operator")) return false;
    if (!nextTokenIs(b, "", QUERY_LANGUAGE_SUBSTRACTION_OPERATOR, QUERY_LANGUAGE_TILDE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUERY_LANGUAGE_SUBSTRACTION_OPERATOR);
    if (!r) r = consumeToken(b, QUERY_LANGUAGE_TILDE);
    exit_section_(b, m, null, r);
    return r;
  }

}
