package com.arjuna.season22;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
3 3
0 1 100
1 2 100
0 2 500
0 2 1
*/


public class MinCostShip {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfShips = scanner.nextInt();
        int noOfLinks = scanner.nextInt();
        List<Vertex> ships = new ArrayList<>();
        List<Edge> links = new ArrayList<>();
        for (int i = 0; i < noOfShips; i++) {
            ships.add(new Vertex(i));
        }
        for (int i = 0; i < noOfLinks; i++) {
            links.add(new Edge(ships.get(scanner.nextInt()), ships.get(scanner.nextInt()), scanner.nextInt()));
        }
        Vertex start = ships.get(scanner.nextInt());
        Vertex end = ships.get(scanner.nextInt());
        int stops = scanner.nextInt();
        Stack<Edge> stack = new Stack<>();
        stack.addAll(start.getAdjacentList());
        start.setVisited(true);
        int sum = 0;
        int visits = 0;
        while (!stack.isEmpty()) {
            if (!stack.peek().v1.isVisited()) {
                stack.peek().v1.setVisited(true);
                stack.addAll(stack.peek().v1.getAdjacentList());
                sum += stack.peek().getWeight();
                visits++;
                stack.pop();
            }
            else if (!stack.peek().v2.isVisited()) {
                stack.peek().v2.setVisited(true);
                stack.addAll(stack.peek().v2.getAdjacentList());
                sum += stack.peek().getWeight();
                visits++;
                stack.pop();
            }


        }
    }
}

class Vertex {
    private int name;
    private List<Edge> adjacentList;
    boolean visited = false;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(int name) {
        this.name = name;
        adjacentList = new ArrayList<>();
    }

    void addEdge(Edge e) {
        adjacentList.add(e);
    }

    public List<Edge> getAdjacentList() {
        return adjacentList;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name=" + name + "}";
    }
}

class Edge {
    Vertex v1;
    Vertex v2;
    private int weight;

    public Edge(Vertex v1, Vertex v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
        v1.addEdge(this);
        v2.addEdge(this);
    }

    public Vertex getV1() {
        return v1;
    }

    public Vertex getV2() {
        return v2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", weight=" + weight +
                '}';
    }
}


