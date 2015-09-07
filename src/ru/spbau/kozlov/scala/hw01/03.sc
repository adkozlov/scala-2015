type Vertex = (Double, Double)
type Polygon = List[Vertex]

def toEdges(polygon: Polygon) = {
  val p :: ps = polygon
  polygon zip (ps ::: List(p))
}

def sqr(x: Double) = x * x
def squaredDistance(u: Vertex, v: Vertex) = sqr(u._1 - v._1) + sqr(u._2 - v._2)

def perimeter(polygon: Polygon) = toEdges(polygon).map(edge => math.sqrt(squaredDistance(edge._1, edge._2))).sum

def square(polygon: Polygon) = {
  def heronsFormula(squaredA: Double, squaredB: Double, squaredC: Double) = math.sqrt(4 * squaredA * squaredB - sqr(squaredA + squaredB - squaredC)) / 4
  def square(u: Vertex, v: Vertex, w: Vertex) = heronsFormula(squaredDistance(v, w), squaredDistance(u, w), squaredDistance(u, v))

  val vertex = polygon.head
  toEdges(polygon).map(p => square(vertex, p._1, p._2)).sum
}

val polygon = List[Vertex]((0, 0), (1, 0), (1, 1), (0, 2))
perimeter(polygon)
square(polygon)