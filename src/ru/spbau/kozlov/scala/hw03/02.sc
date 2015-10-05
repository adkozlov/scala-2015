case class Foo() {
  def foo() = "foo"
}

case class Bar() {
  def bar() = "bar"
}

case class Baz() {
  def baz() = "baz"
}

implicit def foo2Bar[F](f: F)(implicit evidence: F => Foo): Bar = new Bar
implicit def bar2Baz[B](b: B)(implicit evidence: B => Bar): Baz = new Baz

new Foo().baz()