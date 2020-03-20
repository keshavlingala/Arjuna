package com.elite.latest.chillar;

import java.util.Scanner;

public class EncodeStringNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int index = scanner.nextInt();
        long size = 0;
        int N = s.length();
        for (int i = 0; i < N; ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) size *= c - '0';
            else size++;
        }
        try {
            for (int i = N - 1; i >= 0; --i) {
                char c = s.charAt(i);
                index %= size;
                if (index == 0 && Character.isLetter(c)) {
                    System.out.println(c);
                    System.exit(0);
                }
                if (Character.isDigit(c))
                    size /= c - '0';
                else
                    size--;
            }
        } catch (ArithmeticException e) {
            System.out.print('$');
        }
    }
}
