package com.b07.f19.e2;

public class NodeImpl implements Node {
  
  private int id;
  
  public NodeImpl() {
    this.id = 0;
  }
  
  public NodeImpl(int id) {
    this.id = id;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public boolean equals(Node n) {
    return this.id == n.getId();  
  }

}
