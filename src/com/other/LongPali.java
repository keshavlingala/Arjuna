package com.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LongPali {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        ArrayList<String> palindromes = new ArrayList<>();
        for (String i : line) {
            String reverse = new StringBuilder(i).reverse().toString();
            if (i.equals(reverse)) {
                palindromes.add(i);
            }
        }
        if (palindromes.isEmpty()) {
            System.out.println("null");
        } else {
            String max = Collections.max(palindromes, (s1, s2) -> s1.length() - s2.length());
            System.out.println(max);
        }
    }
}
