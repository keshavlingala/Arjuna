package com.leetcode;

import java.util.Scanner;

public class ParenthesisLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int k = 0;
        int count = 0;
        for (int i = 0; i < in.length(); i++) {
            if (in.charAt(i) == '(') {
                count = count + k + 1;
                k = 0;
            } else {
                count--;
                if (count < 0) {
                    k++;
                    count = 0;
                }
            }
        }
        System.out.println(Math.abs(count));
    }
}
