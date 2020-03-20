package com.arjuna.season16;

import java.util.Scanner;

public class ShippingGold {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int checkpoints = s.nextInt();
        int startingPoint = s.nextInt();
        int endingPoint = s.nextInt();
        boolean[] x = new boolean[endingPoint];
        for (int i = 0; i < checkpoints; i++) {
            int position = s.nextInt();
            int guards = s.nextInt();
            int x1 = position - guards;
            int x2 = position + guards;
            if (x2 > endingPoint)
                x2 = endingPoint;
            if (x1 < startingPoint)
                x1 = startingPoint;
            for (int j = x1; j < x2; j++)
                x[j] = true;
        }
        int count = 0;
        for (int i = startingPoint; i < x.length; i++) {
            if (!x[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}