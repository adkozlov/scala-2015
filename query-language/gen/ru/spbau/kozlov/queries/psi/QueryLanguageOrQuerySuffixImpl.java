// This is a generated file. Not intended for manual editing.
package ru.spbau.kozlov.queries.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static ru.spbau.kozlov.queries.parsing.QueryLanguageElementTypes.*;
import ru.spbau.kozlov.queries.psi.api.*;

public class QueryLanguageOrQuerySuffixImpl extends QueryLanguageElementImpl implements QueryLanguageOrQuerySuffix {

  public QueryLanguageOrQuerySuffixImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof QueryLanguageVisitor) ((QueryLanguageVisitor)visitor).visitOrQuerySuffix(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public QueryLanguageOrQuerySuffix getOrQuerySuffix() {
    return findNotNullChildByClass(QueryLanguageOrQuerySuffix.class);
  }

}
