sealed trait Nat {
  type Next <: Nat
  type Prev <: Nat

  val prev: Prev
}

case object Zero extends Nat {
  override type Next = One.type
  override type Prev = Nothing

  override lazy val prev = ???
}

case object One extends Nat {
  override type Next = Two.type
  override type Prev = Zero.type

  override val prev = Zero
}

case object Two extends Nat {
  override type Next = Three.type
  override type Prev = One.type

  override val prev = One
}

case object Three extends Nat {
  override type Next = Nothing
  override type Prev = Two.type

  override val prev = Two
}

sealed trait HList

case object HNil extends HList

type HNil = HNil.type

final case class HCons[+H, +T <: HList](head: H, tail: T) extends HList

trait Splittable[N <: Nat, L <: HList, R <: HList] {
  def apply(n: N)(l: L): (R, HList)
}

object Splittable {
  implicit def atZeroSplittable[L <: HList] = new Splittable[Zero.type, L, HNil] {
    override def apply(n: Zero.type)(l: L) = (HNil, l)
  }

  implicit def splittable[N <: Nat, H, T <: HList, L <: HCons[H, T], R <: HList]
  (implicit splittable: Splittable[N#Prev, T, R]) = new Splittable[N, HCons[H, T], HCons[H, R]] {
    override def apply(n: N)(l: HCons[H, T]) = {
      splittable(n.prev)(l.tail) match {
        case (first, second) => (HCons(l.head, first), second)
      }
    }
  }
}

def splitAt[N <: Nat, L <: HList, R <: HList](n: N)(l: L)
                                             (implicit splittable: Splittable[N, L, R]) = splittable(n)(l)

splitAt(Zero)(HNil)
//splitAt(One)(HNil)
//splitAt(Two)(HNil)
//splitAt(Three)(HNil)

val list = HCons(1, HCons(2, HCons(3, HNil)))
splitAt(Zero)(list)
splitAt(One)(list)
splitAt(Two)(list)
splitAt(Three)(list)