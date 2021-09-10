package com.elite.online.day76;

import java.util.Scanner;


public class Program4 {
    public static int rec(int[][] graph, int node, int end, int sum, boolean[] visited) {
        if (node == end)
            return sum;
        int ans = 999999;
        visited[node] = true;
        for (int i = 1; i < graph.length; i++)
            if (graph[node][i] != 0 && !visited[i])
                ans = Math.min(ans, rec(graph, i, end, sum + Math.max(0, graph[node][i] - sum), visited));
        visited[node] = false;
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();
        int[][] dist = new int[nodes][nodes];
        for (int i = 0; i < edges; i++) {
            int node1 = scanner.nextInt() - 1;
            int node2 = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            dist[node1][node2] = weight;
        }
        boolean[] visited = new boolean[nodes];
        int ans = rec(dist, 0, nodes - 1, 0, visited);
        System.out.println(ans == 999999 ? -1 : ans);
    }
}