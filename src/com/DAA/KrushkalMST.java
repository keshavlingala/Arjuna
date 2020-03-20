package com.DAA;/*Write a Java program for Kruskal's algorithm to find Minimum Spanning Tree of
a given connected, undirected and weighted graph 
Test case:
Enter no of Verices                                                                                                     
6                                                                                                                       
Enter source,destination,and weight                                                                                     
0 1 4                                                                                                                   
0 2 3                                                                                                                   
1 2 1                                                                                                                   
1 3 2                                                                                                                   
2 3 4                                                                                                                   
3 4 2                                                                                                                   
4 5 6                                                                                                                   
Minimum Spanning Tree:                                                                                                  
Edge-0 source: 1 destination: 2 weight: 1                                                                               
Edge-1 source: 1 destination: 3 weight: 2                                                                               
Edge-2 source: 3 destination: 4 weight: 2                                                                               
Edge-3 source: 0 destination: 2 weight: 3                                                                               
Edge-4 source: 4 destination: 5 weight: 6                                                                       
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class KruskalMST {
    static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph {
        int vertices;
        ArrayList<Edge> allEdges = new ArrayList<>();

        Graph(int vertices) {
            this.vertices = vertices;
        }

        public void addEdge(int source, int destination, int weight) {
            Edge edge = new Edge(source, destination, weight);
            allEdges.add(edge); //add to total edges
        }

        public void kruskalMST() {
            PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(), Comparator.comparingInt(o -> o.weight));

            pq.addAll(allEdges);

            int[] parent = new int[vertices];
            makeSet(parent);
            ArrayList<Edge> mst = new ArrayList<>();
            int index = 0;
            while (index < vertices - 1) {
                Edge edge = pq.remove();
                int x_set = find(parent, edge.source);
                int y_set = find(parent, edge.destination);
                if (x_set == y_set) {

                } else {
                    mst.add(edge);
                    index++;
                    union(parent, x_set, y_set);
                }
            }
            System.out.println("Minimum Spanning Tree: ");
            printGraph(mst);
        }

        public void makeSet(int[] parent) {
            for (int i = 0; i < vertices; i++) {
                parent[i] = i;
            }
        }

        public int find(int[] parent, int vertex) {
            if (parent[vertex] != vertex)
                return find(parent, parent[vertex]);
            return vertex;
        }

        public void union(int[] parent, int x, int y) {
            int x_set_parent = find(parent, x);
            int y_set_parent = find(parent, y);
            parent[y_set_parent] = x_set_parent;
        }

        public void printGraph(ArrayList<Edge> edgeList) {
            for (int i = 0; i < edgeList.size(); i++) {
                Edge edge = edgeList.get(i);
                System.out.println("Edge-" + i + " source: " + edge.source +
                        " destination: " + edge.destination +
                        " weight: " + edge.weight);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of Verices");
        int V = sc.nextInt();
        Graph graph = new Graph(V);
        System.out.println("Enter source,destination,and weight");
        for (int i = 0; i <= V; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(src, dest, weight);

        }
        graph.kruskalMST();
    }
}
