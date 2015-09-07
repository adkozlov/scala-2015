import scala.annotation.tailrec

def gcd(x: Int, y: Int) = {
  def next(pair: (Int, Int), quotient: Int) = (pair._2, pair._1 - pair._2 * quotient)

  @tailrec
  def gcd(x: Int, y: Int, xc: (Int, Int) = (0, 1), yc: (Int, Int) = (1, 0)): (Int, Int, Int) =
    x match {
      case 0 => (y, xc._1, yc._1)
      case _ =>
        val quotient = y / x
        gcd(y % x, x, next(xc, quotient), next(yc, quotient))
    }

  gcd(x, y)
}

gcd(5, 13)