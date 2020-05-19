package com.elite.online.day76;

import java.util.Scanner;

public class MinimumCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        int edges = scanner.nextInt();

        int[][] dist = new int[nodes][nodes];
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < edges; i++) {
            int node1 = scanner.nextInt() - 1;
            int node2 = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            dist[node1][node2] = weight;
        }
        System.out.println(rec(dist, 0, 0, nodes - 1, visited));
    }

    static int rec(int[][] dist, int sum, int start, int end, boolean[] visited) {
        if (start == end)
            return sum;
        visited[start] = true;
        int ans = 9999;
        for (int i = 0; i < dist.length; i++)
            if (dist[start][i] != 0 && !visited[i])
                ans = Math.min(ans, rec(dist, sum + dist[start][i], i, end, visited));


        visited[start] = false;
        return ans;
    }
}
