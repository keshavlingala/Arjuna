package com.elite.online.day83;

import java.util.Scanner;

public class SumOfSubStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.next().toCharArray();
        long sum = 0, caryy = 1;
        for (int i = s.length; i > 0; i--, caryy = caryy * 10 + 1)
            sum += (s[i - 1] - '0') * caryy * i;
        System.out.println(sum);
    }
}
