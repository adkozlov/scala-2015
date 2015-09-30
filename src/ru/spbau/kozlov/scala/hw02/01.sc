trait Type {
  def accept(visitor: TypeVisitor) {}
}

trait InternalType extends Type

case class Foo() extends InternalType {
  override def accept(visitor: TypeVisitor) = visitor.visit(this)
}

case class Bar() extends InternalType {
  override def accept(visitor: TypeVisitor) = visitor.visit(this)
}

case class Baz(children: Seq[Type]) extends InternalType {
  override def accept(visitor: TypeVisitor) {
    children.foreach(_.accept(visitor))
    visitor.visit(this)
  }
}

trait TypeVisitor {
  def visit(foo: Foo) {}

  def visit(bar: Bar) {}

  def visit(baz: Baz) {}
}

class PrintVisitor extends TypeVisitor {
  override def visit(foo: Foo) = println(foo)

  override def visit(bar: Bar) = println(bar)

  override def visit(baz: Baz) = println(baz)
}

new Baz(Seq(new Baz(Seq(new Foo)), new Foo, new Bar)).accept(new PrintVisitor)