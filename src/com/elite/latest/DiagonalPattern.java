package com.elite.latest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DiagonalPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        if (row < 0 || col < 0) {
            System.out.println(-1);
            System.exit(0);
        }
        HashMap<Integer, ArrayList<Integer>> hp = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                hp.putIfAbsent(i + j, new ArrayList<>());
                hp.get(i + j).add(scanner.nextInt());
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        hp.forEach((k, v) -> {
            if (k % 2 == 1) {
                list.addAll(v);
            } else {
                Collections.reverse(v);
                list.addAll(v);
            }
        });
        System.out.println(list);
    }
}
