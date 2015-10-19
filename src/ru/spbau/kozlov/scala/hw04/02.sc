import scala.collection.mutable.ArrayBuffer

trait Graph {
  class Vertex

  class Edge(first: GraphVertex, second: GraphVertex)

  type GraphVertex <: Vertex
  type GraphEdge <: Edge

  val vertices = ArrayBuffer[GraphVertex]()
  val edges = ArrayBuffer[GraphEdge]()
}

class RegularGraph extends Graph {
  override type GraphVertex = Vertex
  override type GraphEdge = Edge
}

class ColoredGraph extends Graph {
  class ColoredVertex(color: Int) extends Vertex

  override type GraphVertex = ColoredVertex
  override type GraphEdge = Edge
}

class DirectedGraph extends Graph {
  class DirectedEdge(from: GraphVertex, to: GraphVertex) extends Edge(from, to)

  override type GraphVertex = Vertex
  override type GraphEdge = DirectedEdge
}

val regularGraph = new RegularGraph
regularGraph.vertices += new regularGraph.Vertex
regularGraph.vertices += new regularGraph.Vertex
regularGraph.edges += new regularGraph.GraphEdge(regularGraph.vertices.head,
  regularGraph.vertices(1))

val coloredGraph = new ColoredGraph
coloredGraph.vertices += new coloredGraph.ColoredVertex(0)
coloredGraph.vertices += new coloredGraph.ColoredVertex(1)
coloredGraph.edges += new coloredGraph.GraphEdge(coloredGraph.vertices.head,
  coloredGraph.vertices(1))

val directedGraph = new DirectedGraph
directedGraph.vertices += new directedGraph.Vertex
directedGraph.vertices += new directedGraph.Vertex
directedGraph.edges += new directedGraph.DirectedEdge(directedGraph.vertices.head,
  directedGraph.vertices(1))

