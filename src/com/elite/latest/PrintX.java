package com.elite.latest;

import java.util.Scanner;

public class PrintX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        if (str.length() < 3 || str.length() % 2 == 0) {
            System.out.println(-1);
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == str.length() / 2 && j == str.length() / 2) {
                    System.out.print(str.charAt(i));
                } else if (j == i) {
                    System.out.print(str.charAt(i));
                } else if (j == str.length() - i - 1) {
                    System.out.print(str.charAt(str.length() - i - 1));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
