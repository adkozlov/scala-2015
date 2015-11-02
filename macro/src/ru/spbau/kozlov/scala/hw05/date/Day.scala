package ru.spbau.kozlov.scala.hw05.date

/**
  * @author adkozlov
  */
case class Day(day: Int) {
  def january(year: Int) = Date(day, 1, year)

  def february(year: Int) = Date(day, 2, year)

  def march(year: Int) = Date(day, 3, year)

  def april(year: Int) = Date(day, 4, year)

  def may(year: Int) = Date(day, 5, year)

  def june(year: Int) = Date(day, 6, year)

  def july(year: Int) = Date(day, 7, year)

  def august(year: Int) = Date(day, 8, year)

  def september(year: Int) = Date(day, 9, year)

  def october(year: Int) = Date(day, 10, year)

  def november(year: Int) = Date(day, 11, year)

  def december(year: Int) = Date(day, 12, year)
}
