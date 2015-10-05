object Complex {
  val ZERO = new Complex(0, 0)
  val ONE = new Complex(1, 0)
  val I = new Complex(0, 1)

  def fromPolar(pair: (Double, Double)) = pair match {
    case (abs, arg) => Complex(abs * math.cos(arg), abs * math.sin(arg))
  }

  def exp(complex: Complex) = Complex.fromPolar(math.exp(complex.re), complex.im)

  private def addPeriodic(arg: Double, k: Int) = {
    val period = 2 * math.Pi * (k / 2)
    if (k % 2 == 0) arg + period else arg - period
  }

  def ln(complex: Complex) = complex match {
    case Complex.ZERO => throw new IllegalArgumentException("Ln is not defined at zero")
    case _ =>
      val re = math.log(complex.abs)
      Stream.from(1).map(k => Complex(re, Complex.addPeriodic(complex.arg, k)))
  }

  def sqrt(complex: Complex) = nthRoot(complex, 2)

  def nthRoot(complex: Complex, n: Int) = n >= 1 match {
    case false => throw new IllegalArgumentException("n should be greater than one")
    case true => complex.abs match {
      case 0 => Stream(Complex.ZERO)
      case _ =>
        val abs = math.pow(complex.abs, 1 / n)
        Range(1, n + 1).map(Complex.addPeriodic(complex.arg, _) / n).map(Complex.fromPolar(abs, _))
    }
  }

  def apply(re: Double) = new Complex(re, 0)

  def apply(pair: (Double, Double)) = pair match {
    case (re, im) => new Complex(re, im)
  }

  def unapply(s: String): Option[Complex] = {
    val decimalRegex = """-?\d+\.\d*"""
    val complexRegex = s"""\\(($decimalRegex),\\s+($decimalRegex)\\)""".r
    s match {
      case complexRegex(x, y) => Some(Complex(x.toDouble, y.toDouble))
      case _ => None
    }
  }

  def unapply(re: Double) = Some(Complex(re))

  def unapply(pair: (Double, Double)) = Some(Complex(pair))

  def unapply(complex: Complex) = Some((complex.re, complex.im))
}

implicit def int2Complex(x: Int): Complex = Complex(x.toDouble)
implicit def double2Complex(x: Double): Complex = Complex(x)

final class Complex(val re: Double, val im: Double) {
  private val squaredAbs = re * re + im * im
  val abs = math.sqrt(squaredAbs)
  val arg = math.atan2(im, re)

  def conjugation() = Complex(re, -im)

  def +(complex: Complex) = Complex(re + complex.re, im + complex.im)

  def unary_+ = this

  def -(complex: Complex) = Complex(re - complex.re, im - complex.im)

  def unary_- = Complex(-re, -im)

  def *(complex: Complex) = Complex(re * complex.re - im * complex.im,
    im * complex.re + re * complex.im)

  def /(complex: Complex) = complex match {
    case Complex.ZERO => throw new IllegalArgumentException("Division by zero")
    case _ => Complex((re * complex.re + im * complex.im) / complex.squaredAbs,
      (im * complex.re - re * complex.im) / complex.squaredAbs)
  }

  def ^(complex: Complex) = this match {
    case Complex.ZERO => throw new IllegalArgumentException("Involution is not defined at zero")
    case _ => Complex.ln(this).map(c => Complex.exp(c * complex))
  }

  override def toString = s"($re, $im)"

  override def equals(other: Any): Boolean = other match {
    case that: Complex => re == that.re && im == that.im
    case _ => false
  }

  override def hashCode(): Int = {
    Seq(re, im).map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}

Complex.I.toString match {
  case Complex(complex) => complex
  case _ =>
}

Complex.I match {
  case Complex(x, y) => (x, y)
}

(1.0, 0.0) match {
  case Complex(complex) => complex
}

Complex.ln(Complex.I).take(10).foreach(println)
Complex.nthRoot(Complex.ONE, 5).foreach(println)

1 + Complex.I