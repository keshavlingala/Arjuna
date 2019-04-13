package com.arjuna.season20;

import java.util.ArrayList;
import java.util.Scanner;

public class Peter {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int targetGoldCoins = scanner.nextInt();
        final int minWaste = scanner.nextInt();
        int totalwaste = 0;
        int result = 0;
        for (int i = 0; i <= targetGoldCoins; i++) {
            int coins = i;
            totalwaste = coins;
            while (totalwaste >= minWaste) {
                coins++;
                totalwaste -= minWaste;
                totalwaste++;
            }
            if (coins >= targetGoldCoins) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
