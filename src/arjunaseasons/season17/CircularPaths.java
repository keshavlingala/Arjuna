package com.arjuna.season17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CircularPaths {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Vertex> vertexList = new CircularArrayList<>();
        int noOfVertices = scanner.nextInt();
        for (int i = 0; i < noOfVertices; i++) {
            vertexList.add(new Vertex(Integer.toString(i)));
        }
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < noOfVertices; i++) {
            int edgeWeight = scanner.nextInt();
            edgeList.add(new Edge(edgeWeight, vertexList.get(i), vertexList.get(i + 1)));
        }
        Algorithm algorithm = new Algorithm(vertexList, edgeList);
        int startVertex = scanner.nextInt();
        int endVertex = scanner.nextInt();
        algorithm.shortestPath(vertexList.get(startVertex - 1), vertexList.get(endVertex - 1));
    }
}

class Vertex {
    private String name;
    private boolean visited = false;
    private List<Edge> adjacenciesList;
    private int minDistance = Integer.MAX_VALUE;
    private Vertex previousVertex;
    private int visits = 0;

    public boolean isVisited() {
        return visited;
    }

    public void setAdjacenciesList(List<Edge> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }

    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public int getMinDistance() {
        return minDistance;
    }
}

class Edge {
    private int weight;
    private Vertex startVertex;
    private int visited = 0;
    private Vertex targetVertex;

    public Edge(int weight, Vertex startVertex, Vertex targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    public boolean isVisited() {
        if (visited >= 2) {
            return true;
        } else return false;
    }

    public void visit() {
        this.visited++;
    }

    public boolean isEqual(Edge e) {
        if (this.startVertex == e.startVertex && this.targetVertex == e.targetVertex || this.targetVertex == e.startVertex && this.startVertex == e.targetVertex) {
            return true;
        }
        return false;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Vertex targetVertex) {
        this.targetVertex = targetVertex;
    }
}

class Algorithm {
    private List<Vertex> vertexList;
    private List<Edge> edgeList;
    ArrayList<Boolean> visitedList = new ArrayList<Boolean>();
    boolean hasNegativeEdge = false;

    public Algorithm(List<Vertex> vertexList, List<Edge> edgeList) {

        this.vertexList = vertexList;
        this.edgeList = edgeList;
        for (Vertex v : vertexList)
            visitedList.add(false);
    }

    public void shortestPath(Vertex sourceVertex, Vertex targetVertex) {
        sourceVertex.setMinDistance(0);

        int length = this.vertexList.size();
        for (Edge edge : this.edgeList) {
//                    if (edge.getTargetVertex().isVisited()) continue;
            Vertex v = edge.getStartVertex();
            Vertex u = edge.getTargetVertex();
            int newDistance = v.getMinDistance() + edge.getWeight();
            if (newDistance < u.getMinDistance()) {
                u.setMinDistance(newDistance);
                u.setPreviousVertex(v);
            }
        }
        for (Edge edge : this.edgeList) {
//                    if (edge.getTargetVertex().isVisited()) continue;
            Vertex v = edge.getTargetVertex();
            Vertex u = edge.getStartVertex();
            int newDistance = v.getMinDistance() + edge.getWeight();
            if (newDistance < u.getMinDistance()) {
                u.setMinDistance(newDistance);
                u.setPreviousVertex(v);
            }
        }

        for (Edge edge : edgeList) {
            if (edge.getStartVertex().getMinDistance() != Integer.MAX_VALUE) {
                if (hasCycle(edge)) {
                    this.hasNegativeEdge = true;
                }
            }
        }
        if (targetVertex.getMinDistance() == Integer.MAX_VALUE) {
            System.out.println("No Path");
        } else {
            if (hasNegativeEdge) {
                System.out.println(targetVertex.getMinDistance());
            } else {
                System.out.println(targetVertex.getMinDistance());
            }
        }

    }

    private boolean hasCycle(Edge edge) {
        return (edge.getStartVertex().getMinDistance() + edge.getWeight()) < edge.getTargetVertex().getMinDistance();
    }


}

class CircularArrayList<E> extends ArrayList<E> {
    private static final long serialVersionUID = 1L;

    public E get(int index) {
        if (index == -1) {
            index = size() - 1;
        } else if (index == size()) {
            index = 0;
        }
        return super.get(index);
    }
}