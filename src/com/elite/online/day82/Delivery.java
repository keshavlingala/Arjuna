package com.elite.online.day82;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Delivery {
    static Integer[] dists;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int letters = scanner.nextInt();
        int[] need = new int[letters];
        for (int i = 0; i < letters; i++)
            need[i] = scanner.nextInt() - 1;
        ArrayList<ArrayList<Edge>> edges = IntStream.range(0, n).<ArrayList<Edge>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < n - 1; i++) {
            int node1 = scanner.nextInt() - 1;
            int node2 = scanner.nextInt() - 1;
            int weight = scanner.nextInt();
            edges.get(node1).add(new Edge(node1, node2, weight));
            edges.get(node2).add(new Edge(node2, node1, weight));
        }

        boolean[] l = new boolean[n];
        for (int i : need) l[i] = true;
        int sum = rec(need[0], -1, edges, l);
        System.out.println("SUM " + sum);
        dists = new Integer[n];
        System.out.println(Arrays.toString(dists));
        farthestSum(dists, edges, 0, 0, l);
        System.out.println(Arrays.toString(dists));
        System.out.println(Arrays.toString(l));
        int temp = Arrays.asList(dists).indexOf(Arrays.stream(dists).map(i -> i == null ? 0 : i).max(Integer::compareTo).get());
        System.out.println(temp);
        dists = new Integer[n];
        farthestSum(dists, edges, temp, 0, l);
        System.out.println(Arrays.toString(dists));
        System.out.println(sum - Arrays.stream(dists).map(i -> i == null ? 0 : i).max(Integer::compareTo).get());
    }

    private static void farthestSum(Integer[] dists, ArrayList<ArrayList<Edge>> edges, int curr, int sum, boolean[] lNodes) {
        dists[curr] = sum;
        for (Edge e : edges.get(curr)) {
            if (lNodes[e.end] && dists[e.end] == null) {
                dists[e.end] = sum;
                farthestSum(dists, edges, e.end, sum + e.weight, lNodes);
            }
        }
    }


    private static int rec(int start, int prev, ArrayList<ArrayList<Edge>> edges, boolean[] lNodes) {
        int sum = 0;
        for (Edge e : edges.get(start)) {
            int v = e.end;
            if (v != prev) {
                sum += rec(v, start, edges, lNodes);
                if (lNodes[v]) {
                    lNodes[start] = true;
                    sum += 2 * e.weight;
                }
            }
        }
        return sum;
    }


    static class Edge {
        public int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }


}
