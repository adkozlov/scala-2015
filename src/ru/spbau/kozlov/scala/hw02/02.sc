trait A {
  def foo(): Int

  def bar(): Int
}

object A$ {
  def foo($this: A): Int = 1

  def $init$(a: A): Unit = {
  }
}

class B private(o: Object) extends A {

  def this() {
    this(null)
    A$.$init$(this)
  }

  override def foo(): Int = A$.foo(this)

  override def bar(): Int = 2
}

final class C$ {
  def baz(): Int = 2

  def MODULE$: C$ = this
}

object C {
  val INSTANCE = new C$

  def baz() = INSTANCE.MODULE$.baz()
}

val b = new B()
b.foo()
b.bar()
C.baz()