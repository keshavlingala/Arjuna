package practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RightView {
    public HashMap<Integer, List<Integer>> tree = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, List<Integer>> hp = new HashMap<>();
        hp.putIfAbsent(0, new ArrayList<>());
        hp.getOrDefault(0, new ArrayList<>()).add(1);
        System.out.println(hp);
    }
}
