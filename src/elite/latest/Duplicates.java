package com.elite.latest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Duplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> s1 = new TreeSet<>();
        Set<String> s2 = new TreeSet<>();
        s1.addAll(Arrays.asList(scanner.nextLine().split(" ")));
        s2.addAll(Arrays.asList(scanner.nextLine().split(" ")));
        s1.retainAll(s2);
        System.out.println(s1);
    }
}
