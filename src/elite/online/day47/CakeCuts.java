package com.elite.online.day47;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;

public class CakeCuts {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int n = scanner.nextInt();
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) cuts[i] = scanner.nextInt();
        int angle;
        if (cuts.length < 2) {
            angle = 180;
        } else if (cuts.length < 3) {
            angle = gcd(cuts[0], cuts[1]);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) list.add(Math.abs(cuts[i] - cuts[i + 1]));
            list.add(360 - cuts[n - 1] + cuts[0]);
            angle = gcd(list.get(0), list.get(1));
            for (int i = 2; i < list.size(); i++) angle = gcd(angle, list.get(i));
        }
//        System.out.println(angle);
        System.out.println((360 / angle) - n);


    }

}
