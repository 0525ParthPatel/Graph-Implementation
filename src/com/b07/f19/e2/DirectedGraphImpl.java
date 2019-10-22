package com.b07.f19.e2;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphImpl implements Graph, Reversible{
  private List<NodeImpl> nodeList;
  private List<EdgeImpl> edgeList; 

  public DirectedGraphImpl() {
    nodeList = new ArrayList<NodeImpl>();
    edgeList = new ArrayList<EdgeImpl>();
  }

  @Override
  public boolean addEdge(Node a, Node b) throws NodeNotFoundException {

    if(!contains(a) || !contains(b)) {
      throw new NodeNotFoundException();
    }

    EdgeImpl edge = new EdgeImpl((NodeImpl)a,(NodeImpl) b); 

    for(EdgeImpl e: edgeList) {
      if(edge.compare(e)) {
        return false;
      }
    }

    edgeList.add(edge);

    return true;

  }

  @Override
  public boolean addNode(Node a) {

    if(contains(a)) {
      return false;
    }

    nodeList.add((NodeImpl)a);

    return true;

  }

  @Override
  public boolean removeEdge(Node a, Node b) throws NodeNotFoundException {

    if(!contains(a) || !contains(b)) {
      throw new NodeNotFoundException();
    }

    EdgeImpl edge = new EdgeImpl((NodeImpl)a,(NodeImpl) b); 

    for(EdgeImpl e: edgeList) {
      if(edge.compare(e)) {
        edgeList.remove(e);
        return true;
      }
    }

    return false;

  }

  @Override
  public boolean contains(Node a) {
    return this.nodeList.contains(a);
  }

  @Override
  public int size() {
    return this.nodeList.size();
  }

  @Override
  public List<Node> getConnectedNodes(Node a) throws NodeNotFoundException {

    if(!contains(a)) {
      throw new NodeNotFoundException();
    }

    List<Node> list = new ArrayList<Node>();

    for(EdgeImpl e: edgeList) {
      if(e.getFirstNode() == a) {
        list.add(e.getSecondNode());
      }
    }

    return list;

  }

  @Override
  public List<Edge> getEdges() {

    List<Edge> list = new ArrayList<Edge>();

    for(EdgeImpl e: edgeList) {
      list.add((Edge)e);
    }

    return list;
  }

  @Override
  public void reverse() {

    NodeImpl aTemp;
    NodeImpl bTemp;
    List<EdgeImpl> eAddListTemp = new ArrayList<EdgeImpl>();
    List<EdgeImpl> eRemoveListTemp = new ArrayList<EdgeImpl>();
    EdgeImpl eTemp;

    for(EdgeImpl e: edgeList) {
      aTemp = new NodeImpl(e.getFirstNode().getId());
      bTemp = new NodeImpl(e.getSecondNode().getId());

      eTemp = new EdgeImpl(bTemp, aTemp);
      eAddListTemp.add(eTemp);

      eTemp = new EdgeImpl(aTemp, bTemp);
      eRemoveListTemp.add(eTemp);
    }

    edgeList.clear();

    for(EdgeImpl e: eAddListTemp) {
      edgeList.add(e);
    }

  } 

  @Override
  public String toString() { 

    String response= "";
    ArrayList<String> connections = new ArrayList<String>();
    ArrayList<NodeImpl> temp = new ArrayList<NodeImpl>();

    for(EdgeImpl e: edgeList) {
      temp.add((NodeImpl)e.getFirstNode());
      temp.add((NodeImpl)e.getSecondNode());

      connections.add(Integer.toString(e.getFirstNode().getId()) + "->" + Integer.toString(e.getSecondNode().getId()));
    } 

    for (NodeImpl n: nodeList) {
      if(!temp.contains(n)) {
        connections.add(Integer.toString(n.getId()));
      }  
    }

    for(String s : connections) {
      response = response.concat(s) + ";";
    }

    return response;

  }

}
