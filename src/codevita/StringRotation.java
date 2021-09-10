package com.codevita;

import java.util.ArrayList;
import java.util.Scanner;

public class StringRotation extends Exception {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String original = scanner.nextLine();
        String str = "";
        int numberOfRotation = 0;
        try {
            str = scanner.nextLine();
            numberOfRotation = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            if (str.equals("")) {
                System.out.println("You've entered empty string.");
            } else if (str.length() == 1) {
                System.out.println("You've entered a single char");
            } else {
                System.out.println("You've entered non-intereger number");
            }
            System.out.println("This caused " + e);
        }

        char[] d = new char[numberOfRotation];
        int[] m = new int[numberOfRotation];

        String second = "";

        for (int i = 0; i < numberOfRotation; i++) {


            d[i] = scanner.next().charAt(0);
            m[i] = scanner.nextInt();


            if (d[i] == 'L' || d[i] == 'l') {
//                Left
                original = rotateLeft(original, m[i]);
                second += original.substring(0, 1);
            } else { // Right
                original = rotateRight(original, m[i]);
                second += original.substring(0, 1);
            }
        }

        permutation(second);
        boolean result = false;
        for (String s : arr) {
            if (original.contains(s)) {
                result = true;
            }
        }
        System.out.print(result ? "YES" : "NO");

    }

    private static String rotateRight(String original, int i) {
        String changedString = original.substring(original.length() - i) + original.substring(0, original.length() - i);
        original = changedString;
        return changedString;
    }

    private static String rotateLeft(String original, int i) {
        String changedString = original.substring(i) + original.substring(0, i);
        original = changedString;
        return changedString;
    }

    private static void permutation(String str) {
        permutation("", str);
    }

    static ArrayList<String> arr = new ArrayList<>();

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) arr.add(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
        }
    }

}

