package ru.spbau.kozlov.queries.psi

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.StubElement

/**
 * @author adkozlov
 */
class QueryLanguageElementImpl(astNode: ASTNode) extends QueryLanguageBaseElementImpl[StubElement[PsiElement]](astNode)
