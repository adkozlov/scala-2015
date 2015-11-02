package ru.spbau.kozlov.scala.hw05.date

import scala.language.experimental.macros
import scala.reflect.macros.blackbox

/**
  * @author adkozlov
  */
object Check {
  implicit def of(day: Int): Day = macro ofImpl

  def ofImpl(context: blackbox.Context)(day: context.Expr[Int]): context.Expr[Day] = {
    import context.universe._

    def createExpr() = context.Expr[Day](q"Day($day)")

    day.tree match {
      case Literal(Constant(value: Int)) =>
        value >= 1 && value <= 31 match {
          case true => createExpr()
          case _ => context.abort(context.enclosingPosition, s"$value is not in range [1, 31]")
        }
      case _ => createExpr()
    }
  }
}
