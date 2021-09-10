package com.elite.latest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class HotDog {
    static List<String> list;
    static String second;
    static int min;

    static {
        min = Integer.MAX_VALUE;
        list = new ArrayList<>();
    }

    static void recur(int count, String current, int[] visited) {
        if (current.equals(second)) min = Math.min(count, min);
        for (int i = 0; i < current.length(); i++) {
            for (int k = 0; k < list.size(); k++) {
                String j = list.get(k);
                if (visited[k] != 1 && (current.substring(0, i) + current.substring(i + 1)).equals(j.substring(0, i) + j.substring(i + 1))) {
                    visited[k] = 1;
                    recur(count + 1, j, visited);
                    visited[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(in);
        String first;
        first = sc.nextLine();
        second = sc.nextLine();
        String[] s;
        s = sc.nextLine().split(" ");
        Collections.addAll(list, s);
        if (!list.contains(second)) {
            out.println(0);
            exit(0);
        }
        int[] visited = new int[list.size()];
        recur(0, first, visited);
        out.println(min + 1);

    }
}