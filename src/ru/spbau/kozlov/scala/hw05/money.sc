import ru.spbau.kozlov.scala.hw05.date.Date
import ru.spbau.kozlov.scala.hw05.date.Check._

sealed trait ExchangeRate {
  val value: Double

  val symbol: String
  val name: String

  override def toString = f"$symbol$value%.2f"
}

implicit class RubRate(val value: Double) extends ExchangeRate {
  def rub = RubRate(value)

  override val symbol = "\u20BD"
  override val name = "RUB"
}

implicit class EuroRate(val value: Double) extends ExchangeRate {
  def euro = EuroRate(value)

  override val symbol = "€"
  override val name = "EUR"
}

implicit class USDRate(val value: Double) extends ExchangeRate {
  def usd = USDRate(value)

  override val symbol = "$"
  override val name = "USD"
}

sealed trait ConvertedExchangeRate extends ExchangeRate {
  val from: ExchangeRate
}

object ConvertedExchangeRate {
  def getRate(from: ExchangeRate, to: String, maybeDate: Option[Date] = None) = {
    val source = scala.io.Source.fromURL(s"http://api.fixer.io/${
      maybeDate match {
        case Some(date) => date.toString
        case _ => "latest"
      }
    }?base=${from.name}&symbols=$to").mkString

    "(\\d+\\.\\d+)".r.findFirstIn(source) match {
      case Some(s) => from.value * s.toDouble
      case _ => throw new RuntimeException("Exchange rate not found")
    }
  }
}

case class ConvertedRubRate(from: ExchangeRate, maybeDate: Option[Date] = None)
  extends RubRate(ConvertedExchangeRate.getRate(from, "RUB", maybeDate)) with ConvertedExchangeRate

case class ConvertedEuroRate(from: ExchangeRate, maybeDate: Option[Date] = None)
  extends EuroRate(ConvertedExchangeRate.getRate(from, "EUR", maybeDate)) with ConvertedExchangeRate

case class ConvertedUSDRate(from: ExchangeRate, maybeDate: Option[Date] = None)
  extends USDRate(ConvertedExchangeRate.getRate(from, "USD", maybeDate)) with ConvertedExchangeRate

object RubRate {
  implicit def rub2euro(rate: RubRate): ConvertedEuroRate = ConvertedEuroRate(rate)

  implicit def rub2usd(rate: RubRate): ConvertedUSDRate = ConvertedUSDRate(rate)
}

object EuroRate {
  implicit def euro2rub(rate: EuroRate): ConvertedRubRate = ConvertedRubRate(rate)

  implicit def euro2usd(euro: EuroRate): ConvertedUSDRate = ConvertedUSDRate(euro)
}

object USDRate {
  implicit def usd2rub(rate: USDRate): ConvertedRubRate = ConvertedRubRate(rate)

  implicit def usd2euro(rate: USDRate): ConvertedEuroRate = ConvertedEuroRate(rate)
}

implicit class ExchangeRateConverter(val rate: ExchangeRate) {
  def to(convert: ExchangeRate => ExchangeRate) = convert(rate)

  def at(date: Date) = {
    rate match {
      case convertedRate: ConvertedExchangeRate =>
        val from = convertedRate.from
        val someDate = Some(date)
        rate match {
          case _: ConvertedRubRate => ConvertedRubRate(from, someDate)
          case _: ConvertedEuroRate => ConvertedEuroRate(from, someDate)
          case _: ConvertedUSDRate => ConvertedUSDRate(from, someDate)
          case _ => ???
        }
      case _ => rate
    }
  }
}

def rub(rate: ExchangeRate): RubRate = rate match {
  case rub: RubRate => rub
  case euro: EuroRate => euro
  case usd: USDRate => usd
}

def euro(rate: ExchangeRate): EuroRate = rate match {
  case rub: RubRate => rub
  case euro: EuroRate => euro
  case usd: USDRate => usd
}

def usd(rate: ExchangeRate): USDRate = rate match {
  case rub: RubRate => rub
  case euro: EuroRate => euro
  case usd: USDRate => usd
}

for (r <- List(1.0.rub, 1.0.euro, 1.0.usd)) {
  for (f <- List(rub _, euro _, usd _)) {
    print(s"${r to f}\t")
  }
  println()
}

1.0.usd to rub at 32.february(2008)