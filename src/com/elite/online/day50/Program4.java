package com.elite.online.day50;

import java.util.*;
import java.util.stream.Collectors;

public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int teams = scanner.nextInt();
        ArrayList<Integer> time = new ArrayList<>();
        BigLoop:
        for (int team = 0; team < teams; team++) {
            int members = scanner.nextInt();
            int cond = scanner.nextInt();
            int[] degree = new int[members];
            int max = 0;
            for (int i = 0; i < cond; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                degree[y] = Math.max(degree[x] + 1, degree[y]);
                max = Math.max(max, degree[y]);
            }
            TreeSet<Integer> set = Arrays.stream(degree).boxed().collect(Collectors.toCollection(TreeSet::new));
            for (int i = 0; i < max; i++) {
                if (!set.contains(i)) {
                    time.add(Integer.MAX_VALUE);
                    continue BigLoop;
                }
            }
            time.add(max);
        }
        int min = time.stream().min(Integer::compareTo).get();
        System.out.println(Collections.frequency(time, min) == 1 ? time.indexOf(min) + 1 : "0");
    }
}
