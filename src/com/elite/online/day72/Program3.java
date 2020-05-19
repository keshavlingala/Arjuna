package com.elite.online.day72;

import java.util.*;
import java.util.stream.Collectors;

public class Program3 {
    static ArrayList<ArrayList<Integer>> rooms;
    static HashSet<Integer> keyshave;
    static boolean ans = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        rooms = new ArrayList<>();
        keyshave = new HashSet<>();
        keyshave.add(0);
        for (int i = 0; i < n; i++) {
            rooms.add(new ArrayList<>());
            List<Integer> nums = Arrays.stream(scanner.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            rooms.get(i).addAll(nums);
        }
        keyshave.addAll(rooms.get(0));
        for (int key : rooms.get(0)) {
            rec(key, n);
        }
        System.out.println(ans);
    }

    static void rec(int i, int target) {
        if (keyshave.size() >= target) {
            ans = true;
        }
        for (int key : rooms.get(i)) {
            if (keyshave.contains(key)) continue;
            keyshave.add(key);
            rec(key, target);
        }
        keyshave.addAll(rooms.get(i));
    }
}
