package ru.spbau.kozlov.queries.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import ru.spbau.kozlov.queries.QueryLanguageFileType
import ru.spbau.kozlov.queries.psi.api.QueryLanguageFile

/**
 * @author adkozlov
 */
class QueryLanguageFileImpl(filViewProvider: FileViewProvider, language: Language) extends PsiFileBase(filViewProvider, language) with QueryLanguageFile {

  def this(fileViewProvider: FileViewProvider) {
    this(fileViewProvider, QueryLanguageFileType.INSTANCE.getLanguage)
  }

  override def getFileType: FileType = QueryLanguageFileType.INSTANCE
}
