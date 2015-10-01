package ru.spbau.kozlov.queries.psi.api

import com.intellij.psi.NavigatablePsiElement

/**
 * @author adkozlov
 */
trait QueryLanguagePsiElement extends NavigatablePsiElement {
  val EMPTY_ARRAY: Array[QueryLanguagePsiElement] = new Array(0)
}
