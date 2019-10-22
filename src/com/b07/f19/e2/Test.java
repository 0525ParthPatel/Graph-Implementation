package com.b07.f19.e2;

public class Test {

  public static void main(String[] args) throws NodeNotFoundException {
    Graph graph1 = new DirectedGraphImpl();
    //a and b are of type NodeImpl and are already added to the nodes in graph1
    
    NodeImpl a = new NodeImpl(1);
    NodeImpl b = new NodeImpl(2);
    NodeImpl c = new NodeImpl(3);
    NodeImpl d = new NodeImpl(4);
    NodeImpl e = new NodeImpl(500);
     
    graph1.addNode(a);
    graph1.addNode(b);
    graph1.addNode(c);
    graph1.addNode(d);
    graph1.addNode(e);
    
    graph1.addEdge(a,b);
    graph1.addEdge(b,b);
    graph1.addEdge(b,c);
    graph1.addEdge(b,c);
    graph1.addEdge(c,d);
    graph1.addEdge(d,a);
    
    ((DirectedGraphImpl) graph1).reverse();
    
    System.out.print(graph1);
    
  }

}
