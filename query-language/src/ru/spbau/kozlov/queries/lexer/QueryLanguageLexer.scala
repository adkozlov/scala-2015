package ru.spbau.kozlov.queries.lexer

import com.intellij.lexer.{FlexAdapter, MergingLexerAdapter}
import com.intellij.psi.tree.TokenSet
import ru.spbau.kozlov.queries.parsing.QueryLanguageParserDefinition

/**
 * @author adkozlov
 */
class QueryLanguageLexer extends MergingLexerAdapter(new FlexAdapter(new _QueryLanguageLexer), QueryLanguageLexer.TOKENS_TO_MERGE)

object QueryLanguageLexer {
  private val TOKENS_TO_MERGE: TokenSet = TokenSet.create(QueryLanguageParserDefinition.SPACE)
}
