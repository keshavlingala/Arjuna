package com.elite.online.day51;

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] acards = new int[n];
        for (int i = 0; i < n; i++) acards[i] = scanner.nextInt();
        scanner.nextInt();
        int[] mcards = new int[n];
        for (int i = 0; i < n; i++) mcards[i] = scanner.nextInt();
        boolean even = scanner.next().equalsIgnoreCase("even");
        int andscore = 0;
        for (int i = even ? 0 : 1; i < n; i += 2)
            andscore += acards[i] - mcards[i];
        System.out.println(andscore < 0 ? "Maria" : andscore == 0 ? "Tie" : "Andrea");
    }
}
