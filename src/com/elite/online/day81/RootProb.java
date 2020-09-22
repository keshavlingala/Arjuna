package com.elite.online.day81;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RootProb {
    static int[][] degree;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<Integer>> hp = new HashMap<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int x = scanner.nextInt() - 1, y = scanner.nextInt() - 1;
            hp.putIfAbsent(x, new ArrayList<>());
            hp.putIfAbsent(y, new ArrayList<>());
            hp.get(x).add(y);
            hp.get(y).add(x);
        }
        degree = new int[n][n];
        for (int i = 0; i < n; i++) rec(i, hp, new boolean[n], i, 0);
        int numerator = 0, denominator = n;
        int[][] relations = new int[scanner.nextInt()][2];
        int target = scanner.nextInt();
        for (int i = 0; i < relations.length; i++)
            relations[i] = new int[]{scanner.nextInt() - 1, scanner.nextInt() - 1};
        for (int i = 0, possibles = 0; i < degree.length; i++, possibles = 0) {
            for (int[] pc : relations)
                if (degree[i][pc[0]] < degree[i][pc[1]]) possibles++;
            if (possibles >= target) numerator++;
        }
        int gcd = BigInteger.valueOf(numerator).gcd(BigInteger.valueOf(denominator)).intValue();
        System.out.println(numerator / gcd + "/" + denominator / gcd);
    }

    static void rec(int root, HashMap<Integer, List<Integer>> hp, boolean[] visited, int cur, int depth) {
        if (visited[cur]) return;
        degree[root][cur] = depth;
        visited[cur] = true;
        for (int i : hp.get(cur)) rec(root, hp, visited, i, depth + 1);
    }
}