package ru.spbau.kozlov.queries

import javax.swing.Icon

import com.intellij.openapi.fileTypes.LanguageFileType

/**
 * @author adkozlov
 */
class QueryLanguageFileType private() extends LanguageFileType(new QueryLanguage()) {
  override def getDefaultExtension = "gsq"

  override def getName = "Google Search Query Language"

  override def getIcon: Icon = null

  override def getDescription = "Query files"
}

object QueryLanguageFileType {
  val INSTANCE: QueryLanguageFileType = new QueryLanguageFileType
}
