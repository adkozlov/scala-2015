import scala.annotation.tailrec

def cycleLength(n: Int) = {
  @tailrec
  def cycleLength(value: Int = 1, remainders: List[Int] = List()): Int = {
    if (remainders.contains(value)) remainders.size - remainders.indexOf(value) else cycleLength((value * 10) % n, remainders :+ value)
  }

  cycleLength()
}

def hasMaxCycleLength(n: Int) = (1 to n).maxBy(cycleLength)

hasMaxCycleLength(1000)