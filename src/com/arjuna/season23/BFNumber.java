package com.arjuna.season23;

import java.util.Scanner;

public class BFNumber {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        boolean beautiful = false;
        int start = 0;
        for (int i = 1; i <= input.length() / 2; i++) {
            int curr = Integer.parseInt(input.substring(0, i));
            start = curr;
            String s = "" + curr;
            while (s.length() < input.length()) {
                s = s + (++curr);
            }
            if (s.equals(input)) {
                beautiful = true;
                break;
            }
        }
        if (beautiful == true) System.out.println("YES " + start);
        else System.out.println("NO");
    }
}
