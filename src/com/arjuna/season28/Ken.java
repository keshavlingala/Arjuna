package com.arjuna.season28;

import java.util.Scanner;

//TODO Deal with it 
public class Ken {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = new int[10000];
        int n = scanner.nextInt(), position, side, height = 0, j, tHeight;
        for (int i = 0; i < n; i++) {
            position = scanner.nextInt();
            side = scanner.nextInt();
            tHeight = 0;
            for (j = position; j < side + position; j++) {
                if ((x[j] + side) > tHeight) {
                    tHeight = x[j] + side;
                }
            }
            for (j = position; j < side + position; j++) {
                x[j] = tHeight;
            }

            if (height < tHeight) {
                height = tHeight;
            }
            System.out.print(height + " ");
        }
    }
}
