package com.DAA;
/*
Find the mitakes for given single source shortest path algorithm and correct the
mistakes 
Testcase:
Enter no of vertices
7
Enter No of Edges
6
Enter source,destination and weight
0 1 4
0 2 3
1 2 1
1 3 2
2 3 4
3 4 2
4 5 6
Path from vertex 0 to vertex 1 has minimum cost of 4 and the route is [ 0 1 ]
Path from vertex 0 to vertex 2 has minimum cost of 3 and the route is [ 0 2 ]
Path from vertex 0 to vertex 3 has minimum cost of 6 and the route is [ 0 1 3 ]
Path from vertex 0 to vertex 4 has minimum cost of 8 and the route is [ 0 1 3 4 ]
Path from vertex 0 to vertex 5 has minimum cost of 14 and the route is [ 0 1 3 4 5 ]
*/

import java.util.*;

class Edge {
    int source, dest, weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
};

class Node {
    int vertex, weight;

    public Node(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
};

class Graph {
    List<List<Edge>> adjList = null;

    Graph(List<Edge> edges, int N) {
        adjList = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            adjList.add(i, new ArrayList<>());
        }
        for (Edge edge : edges) {
            adjList.get(edge.source).add(edge);
        }
    }
}

class DijkstraSP {
    private static void printRoute(int prev[], int i) {
        if (i < 0)
            return;
        printRoute(prev, prev[i]);
        System.out.print(i + " ");
    }

    public static void shortestPath(Graph graph, int source, int N) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>((lhs, rhs) -> lhs.weight - rhs.weight);
        minHeap.add(new Node(source, 0));
        List<Integer> dist = new ArrayList<>(Collections.nCopies(N, Integer.MAX_VALUE));
        dist.set(source, 0);
        boolean[] done = new boolean[N];
        done[0] = true;
        int prev[] = new int[N];
        prev[0] = -1;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int u = node.vertex;
            for (Edge edge : graph.adjList.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;
                if (!done[v] && (dist.get(u) + weight) < dist.get(v)) {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new Node(v, dist.get(v)));
                }
            }
            done[u] = true;
        }

        for (int i = 1; i < N; ++i) {
            System.out.print("Path from vertex 0 to vertex " + i +
                    " has minimum cost of " + dist.get(i) +
                    " and the route is [ ");
            printRoute(prev, i);
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Edge> edges = new ArrayList<Edge>();
        Edge e;
        System.out.println("Enter no of Vertices");
        int V = sc.nextInt();
        System.out.println("Enter No of Edges");
        int E = sc.nextInt();
        System.out.println("Enter source,destination and weight");
        for (int i = 0; i < V; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            e = new Edge(src, dest, wt);
            edges.add(e);
        }
        Graph graph = new Graph(edges, V);
        shortestPath(graph, 0, E);
    }
}