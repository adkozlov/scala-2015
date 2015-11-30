package ru.spbau.kozlov.scala.hw06.types

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

/**
  * @author adkozlov
  */
object ExpressionType {
  def `type`(expression: Any): String = macro typeImpl

  def typeImpl(context: blackbox.Context)(expression: context.Expr[Any]): context.Expr[String] = {
    import context.universe._
    context.Expr(q"${show(expression.actualType)}")
  }
}
