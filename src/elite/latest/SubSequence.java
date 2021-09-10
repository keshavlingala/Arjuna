package com.elite.latest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.next();
        String line = scanner.next();
        ArrayList<Integer> indices = new ArrayList<>();
        indices.add(0);
        for (int i = 0; i < target.length(); i++) {
            indices.add(line.indexOf(target.charAt(i), indices.get(indices.size() - 1)));
        }
        List<Integer> copy = new ArrayList<>(indices);
        copy.sort(Integer::compareTo);
        System.out.println(indices.equals(copy));
    }
}
