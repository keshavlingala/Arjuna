package com.elite.online.day50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, ArrayList<Integer>> hp = new HashMap<>();
        int nodes = scanner.nextInt();
        int con = scanner.nextInt();
        HashMap<Integer, ArrayList<Integer>> exc = new HashMap<>();
        for (int i = 0; i < con; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            exc.putIfAbsent(x, new ArrayList<>());
            exc.get(x).add(y);
            exc.putIfAbsent(y, new ArrayList<>());
            exc.get(y).add(x);
        }
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (i == j) {
                    continue;
                }
                if (exc.containsKey(i))
                    if (exc.get(i).contains(j)) continue;
                hp.putIfAbsent(i, new ArrayList<>());
                hp.get(i).add(j);
            }
        }
        int source = scanner.nextInt() - 1;
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            if (i == source) {
                continue;
            }
            ans.put(i, shortest(hp, source, i, 0, ""));
        }
        ans.values().forEach(x -> System.out.print(x + " "));
    }

    static int shortest(HashMap<Integer, ArrayList<Integer>> hp, int source, int dest, int cost, String visited) {
        if (!hp.containsKey(source)) {
            return cost;
        }
        if (source == dest) {
            return cost;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int edge : hp.get(source)) {
            if (!visited.contains(edge + ""))
                list.add(shortest(hp, edge, dest, cost + 1, visited + source));
        }
        return list.stream().min(Integer::compareTo).orElse(Integer.MAX_VALUE);
    }


}
