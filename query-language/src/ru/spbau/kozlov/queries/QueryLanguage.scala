package ru.spbau.kozlov.queries

import com.intellij.lang.Language

/**
 * @author adkozlov
 */
class QueryLanguage protected[queries]() extends Language("QueryLanguage") {
  override def isCaseSensitive: Boolean = true
}

object QueryLanguage {
  val INSTANCE: QueryLanguage = QueryLanguageFileType.INSTANCE.getLanguage.asInstanceOf[QueryLanguage]
}
