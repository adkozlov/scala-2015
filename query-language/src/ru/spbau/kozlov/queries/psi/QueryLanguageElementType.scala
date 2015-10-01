package ru.spbau.kozlov.queries.psi

import com.intellij.psi.tree.IElementType
import ru.spbau.kozlov.queries.QueryLanguageFileType

/**
 * @author adkozlov
 */
class QueryLanguageElementType(debugName: String) extends IElementType(debugName, QueryLanguageFileType.INSTANCE.getLanguage)
