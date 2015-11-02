package ru.spbau.kozlov.scala.hw05.date

import scala.language.experimental.macros

/**
  * @author adkozlov
  */
case class Date(day: Int, month: Int, year: Int) {
  assert(month >= 1 && month <= 12, "Month should be represented with a number between 1 and 12")

  assert(day >= 1, "Day should be represented with a number greater than 0")
  Date.assertDaysNumber(day, month match {
    case 1 => ("January", 31)
    case 2 => ("February", if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) 29 else 28)
    case 3 => ("March", 31)
    case 4 => ("April", 30)
    case 5 => ("May", 31)
    case 6 => ("June", 30)
    case 7 => ("July", 31)
    case 8 => ("August", 31)
    case 9 => ("September", 30)
    case 10 => ("October", 31)
    case 11 => ("November", 30)
    case 12 => ("December", 31)
  })

  assert(year >= 2000, "There is no data on this date")

  override def toString = f"$year-$month%02d-$day%02d"
}

object Date {
  private def assertDaysNumber(day: Int, month: (String, Int)) = month match {
    case (monthName, daysCount) => assert(day <= daysCount, s"There are only $daysCount days in $monthName")
  }
}
