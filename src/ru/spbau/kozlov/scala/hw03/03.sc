object Both {
  def apply[T](x: T, y: T) = (x, y)

  def unapply[T](x: T) = Some(Both(x, x))
}

List(1, 'a', "ab").foreach { case Both(x, y) => println(x, y) }