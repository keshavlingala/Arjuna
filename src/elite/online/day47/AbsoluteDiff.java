package com.elite.online.day47;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbsoluteDiff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = IntStream.range(0, scanner.nextInt()).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        list.sort(Integer::compareTo);
        ArrayList<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i + 1)) == min) {
                ans.add(list.get(i));
                ans.add(list.get(i + 1));
            }
            if (Math.abs(list.get(i) - list.get(i + 1)) < min) {
                ans.clear();
                ans.add(list.get(i));
                ans.add(list.get(i + 1));
                min = Math.abs(list.get(i) - list.get(i + 1));
            }
        }
//        System.out.println(list);
        System.out.println(ans);

    }
}
