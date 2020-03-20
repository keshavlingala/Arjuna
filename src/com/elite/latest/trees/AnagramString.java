package com.elite.latest.trees;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnagramString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        List<String> a = Arrays.stream(s1.split("")).distinct().sorted().collect(Collectors.toList());
        List<String> b = Arrays.stream(s2.split("")).distinct().sorted().collect(Collectors.toList());
        System.out.println(a.equals(b));
    }
}
