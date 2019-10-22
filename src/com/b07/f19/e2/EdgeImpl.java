package com.b07.f19.e2;

public class EdgeImpl implements Edge {
  
  private NodeImpl adjList[];
  
  public EdgeImpl() {
    this.adjList = new NodeImpl[2];
    
    this.adjList[0] = null;
    this.adjList[1] = null;
  }
  
  public EdgeImpl(NodeImpl a, NodeImpl b) {
    this.adjList = new NodeImpl[2];
    
    this.adjList[0] = a;
    this.adjList[1] = b;
  }
  
  @Override
  public Node getFirstNode() {
    return adjList[0];
  }

  @Override
  public Node getSecondNode() {
    return adjList[1];
  }

  @Override
  public int nodePosition(Node a) {
    
    if(adjList[0] == a) {
      return 1;
    } else if (adjList[1] == a) {
      return 2;
    }
    
    return 0;
  }

  @Override
  public boolean compareOrderAgnostic(Edge edge) {
    return (adjList[0] == edge.getFirstNode() && adjList[1] == edge.getSecondNode()) || 
        (adjList[1] == edge.getFirstNode() && adjList[0] == edge.getSecondNode());
  }

  @Override
  public boolean compare(Edge edge) {
    return adjList[0] == edge.getFirstNode() && adjList[1] == edge.getSecondNode();
  }

}
