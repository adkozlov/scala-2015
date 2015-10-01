package ru.spbau.kozlov.queries.psi

import com.intellij.extapi.psi.StubBasedPsiElementBase
import com.intellij.lang.{ASTNode, Language}
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.StubElement
import ru.spbau.kozlov.queries.QueryLanguageFileType
import ru.spbau.kozlov.queries.psi.api.QueryLanguagePsiElement

/**
 * @author adkozlov
 */
class QueryLanguageBaseElementImpl[T <: StubElement[PsiElement]](astNode: ASTNode) extends StubBasedPsiElementBase[T](astNode) with QueryLanguagePsiElement {
  override def getLanguage: Language = QueryLanguageFileType.INSTANCE.getLanguage

  override def toString = getNode.getElementType.toString
}
