package com.elite.online;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


/*

9
1 2 3 4 5 6 7 8 9
7 8
4 9
1 5
3 1
3 2
2 7
2 6
1 4




* */
public class MinimumCut {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Node[] nodes = new Node[N];
        int totalSum = 0;
        for (int i = 0; i < N; i++) {
            int v = scanner.nextInt();
            totalSum += v;
            nodes[i] = new Node(v);
        }
        int[] degree = new int[N];
        int rootIndex = 0;
        for (int i = 0; i < N - 1; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            if (nodes[x].degree >= nodes[y].degree) {
//                degree[y] += degree[x] + 1;
                nodes[x].addChild(nodes[y]);
            } else {
//                degree[x] += degree[y] + 1;
                nodes[y].addChild(nodes[x]);
            }
        }
        Arrays.stream(nodes).forEach(node -> {
            System.out.print(node.degree + " ");
        });
        for (int i = 0; i < N; i++) if (degree[rootIndex] > degree[i]) rootIndex = i;
        nodes[rootIndex].cs = dfs(nodes[rootIndex], 0);
        for (Node node : nodes) {
            min = Math.min(Math.abs(totalSum - 2 * node.cs), min);
        }
        System.out.println(min);
    }

    static int dfs(Node node, int sum) {
        if (node.children.size() == 0) {
            node.cs = node.data;
            return node.cs;
        }
        int cs = node.data;
        for (Node n : node.children) {
            cs += dfs(n, cs);
        }
        node.cs = cs;
        return cs;
    }

    static class Node {
        public int cs, data, degree;
        ArrayList<Node> children = new ArrayList<>();

        Node(int i) {
            this.data = i;
        }

        void addChild(Node n) {
            children.add(n);
            n.decent(this);
        }

        void decent(Node n) {
            this.degree += n.degree + 1;
            for (Node child : children) {
                child.decent(n);
            }
        }

        @Override
        public String toString() {
            return "Node[ " + cs + " " + data + " ]";
        }
    }
}