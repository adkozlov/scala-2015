package ru.spbau.kozlov.scala.hw05.date

/**
  * @author adkozlov
  */
object NoCheck {
  implicit def of(day: Int): Day = Day(day)
}
