package ru.spbau.kozlov.queries.parsing

import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.{IElementType, IFileElementType, TokenSet}
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile}
import ru.spbau.kozlov.queries.lexer.QueryLanguageLexer
import ru.spbau.kozlov.queries.psi.{QueryLanguageElementType, QueryLanguageFileElementType, QueryLanguageFileImpl}

/**
 * @author adkozlov
 */
class QueryLanguageParserDefinition extends ParserDefinition {
  private val whitespaceTokens = TokenSet.create(QueryLanguageParserDefinition.SPACE)

  override def getWhitespaceTokens: TokenSet = whitespaceTokens

  override def spaceExistanceTypeBetweenTokens(astNode: ASTNode, astNode1: ASTNode): SpaceRequirements = SpaceRequirements.MAY

  override def createFile(fileViewProvider: FileViewProvider): PsiFile = new QueryLanguageFileImpl(fileViewProvider)

  override def getCommentTokens: TokenSet = TokenSet.EMPTY

  override def createElement(astNode: ASTNode): PsiElement = QueryLanguageElementTypes.Factory.createElement(astNode)

  override def getStringLiteralElements: TokenSet = TokenSet.EMPTY

  override def createLexer(project: Project): Lexer = new QueryLanguageLexer

  override def getFileNodeType: IFileElementType = QueryLanguageParserDefinition.FILE

  override def createParser(project: Project): PsiParser = new QueryLanguageParser
}

object QueryLanguageParserDefinition {
  val SPACE: IElementType = new QueryLanguageElementType("SPACE")

  val FILE: IFileElementType = new QueryLanguageFileElementType
}
