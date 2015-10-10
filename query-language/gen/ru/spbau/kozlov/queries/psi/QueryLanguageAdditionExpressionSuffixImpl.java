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

public class QueryLanguageAdditionExpressionSuffixImpl extends QueryLanguageElementImpl implements QueryLanguageAdditionExpressionSuffix {

  public QueryLanguageAdditionExpressionSuffixImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof QueryLanguageVisitor) ((QueryLanguageVisitor)visitor).visitAdditionExpressionSuffix(this);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<QueryLanguageAdditionExpressionSuffix> getAdditionExpressionSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QueryLanguageAdditionExpressionSuffix.class);
  }

  @Override
  @NotNull
  public List<QueryLanguageInvolutionExpressionSuffix> getInvolutionExpressionSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QueryLanguageInvolutionExpressionSuffix.class);
  }

  @Override
  @NotNull
  public List<QueryLanguageMultiplicationExpressionSuffix> getMultiplicationExpressionSuffixList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, QueryLanguageMultiplicationExpressionSuffix.class);
  }

}
