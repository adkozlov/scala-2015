package ru.spbau.kozlov.queries.psi

import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.tree.IStubFileElementType
import ru.spbau.kozlov.queries.QueryLanguage

/**
 * @author adkozlov
 */
class QueryLanguageFileElementType extends IStubFileElementType(QueryLanguage.INSTANCE) {
  override def indexStub(t: Nothing, indexSink: IndexSink) {}

  override def getStubVersion = 2
}
