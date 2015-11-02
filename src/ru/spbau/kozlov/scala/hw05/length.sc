sealed trait LengthUnit {
  val value: Double
  val symbol: String

  override def toString = f"$value%.6f $symbol"
}

implicit class Meters(val value: Double) extends LengthUnit {
  def m = Meters(value)

  override val symbol = "m"
}

object Meters {
  val METERS_PER_KILOMETER = 1000

  implicit def m2km(m: Meters): KiloMeters = KiloMeters(m.value / METERS_PER_KILOMETER)
}

implicit class KiloMeters(val value: Double) extends LengthUnit {
  def km = KiloMeters(value)

  override val symbol = "km"
}

object KiloMeters {
  val KILOMETERS_PER_MILE = 1.609344

  implicit def km2m(km: KiloMeters): Meters = Meters(Meters.METERS_PER_KILOMETER * km.value)
  implicit def km2mi(km: KiloMeters): Miles = Miles(km.value / KILOMETERS_PER_MILE)
}

implicit class Inches(val value: Double) extends LengthUnit {
  def in = Inches(value)

  override val symbol = "in"
}

object Inches {
  val INCHES_PER_FOOT = 12

  implicit def in2Ft(in: Inches): Feet = Feet(in.value / INCHES_PER_FOOT)
}

implicit class Feet(val value: Double) extends LengthUnit {
  def ft = Feet(value)

  override val symbol = "ft"
}

object Feet {
  val FEET_PER_YARD = 3

  implicit def ft2in(ft: Feet): Inches = Inches(Inches.INCHES_PER_FOOT * ft.value)
  implicit def ft2Yd(ft: Feet): Yards = Yards(ft.value / FEET_PER_YARD)
}

implicit class Yards(val value: Double) extends LengthUnit {
  def yd = Yards(value)

  override val symbol = "yd"
}

object Yards {
  val YARDS_PER_MILE = 1760

  implicit def yd2Ft(yd: Yards): Feet = Feet(Feet.FEET_PER_YARD * yd.value)
  implicit def yd2Mi(yd: Yards): Miles = Miles(yd.value / YARDS_PER_MILE)
}

implicit class Miles(val value: Double) extends LengthUnit {
  def mi = Miles(value)

  override val symbol = "mi"
}

object Miles {
  implicit def mi2km(mi: Miles): KiloMeters = KiloMeters(KiloMeters.KILOMETERS_PER_MILE * mi.value)
  implicit def mi2yd(mi: Miles): Yards = Yards(Yards.YARDS_PER_MILE * mi.value)
}

implicit class LengthUnitsConverter[F <: LengthUnit](val from: F) {
  // TODO extends AnyVal
  def to[T <: LengthUnit](to: F => T) = to(from)
}

def m(length: LengthUnit): Meters = length match {
  case m: Meters => m
  case _ => length to km
}

def km(length: LengthUnit): KiloMeters = length match {
  case m: Meters => m
  case km: KiloMeters => km
  case _ => length to mi
}

def in(length: LengthUnit): Inches = length match {
  case in: Inches => in
  case _ => length to ft
}


def ft(length: LengthUnit): Feet = length match {
  case in: Inches => in
  case ft: Feet => ft
  case _ => length to yd
}

def yd(length: LengthUnit): Yards = length match {
  case in: Inches => in to ft
  case ft: Feet => ft
  case yd: Yards => yd
  case _ => length to mi
}

def mi(length: LengthUnit): Miles = length match {
  case m: Meters => (length to km) to mi
  case km: KiloMeters => km
  case in: Inches => in to yd
  case ft: Feet => ft to yd
  case yd: Yards => yd
  case mi: Miles => mi
}

for (l <- List(1.0.m, 1.0.km, 1.0.in, 1.0.ft, 1.0.yd, 1.0.mi)) {
  for (f <- List(m _, km _, in _, ft _, yd _, mi _)) {
    print(s"${l to f}\t")
  }
  println()
}