package com.elite.latest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SortArrayDiag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        HashMap<Integer, List<Integer>> hp = new HashMap<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                hp.putIfAbsent(i - j, new ArrayList<>());
                hp.get(i - j).add(scanner.nextInt());
            }
        }
        hp.forEach((k, v) -> v.sort(Integer::compareTo));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(hp.get(i - j).remove(0) + " ");

            }
            System.out.println();
        }
    }
}
