package exams;

import java.util.Scanner;

public class MaxXor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ele = {3, 7, 19, 18, 7, 12, 17};
        String s = "aababc";
        String s1 = s.substring(0, s.length() / 2);
        String s2 = s.substring(s.length() / 2);
        int gc = 0, lc = 0, ec = 0;
        System.out.println(gc + " " + lc + " " + ec);
        System.out.println(Math.min(gc, Math.min(lc, ec)));
    }
}
