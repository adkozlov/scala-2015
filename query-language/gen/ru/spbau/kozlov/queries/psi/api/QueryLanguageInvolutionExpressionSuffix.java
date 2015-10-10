// This is a generated file. Not intended for manual editing.
package ru.spbau.kozlov.queries.psi.api;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface QueryLanguageInvolutionExpressionSuffix extends QueryLanguagePsiElement {

  @NotNull
  List<QueryLanguageAdditionExpressionSuffix> getAdditionExpressionSuffixList();

  @NotNull
  List<QueryLanguageInvolutionExpressionSuffix> getInvolutionExpressionSuffixList();

  @NotNull
  List<QueryLanguageMultiplicationExpressionSuffix> getMultiplicationExpressionSuffixList();

}
