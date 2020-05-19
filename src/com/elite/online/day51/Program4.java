package com.elite.online.day51;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 0) {
            System.out.print(0);
            System.exit(0);
        }
        TreeSet<Integer> set = IntStream.range(0, n).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(TreeSet::new));
        int min = set.first();
        int container = 1;
        while (!set.isEmpty()) {
            if (set.first() > min + 4) {
                min = set.first();
                container++;
            }
            set.pollFirst();
        }
        System.out.println(container);

    }
}
