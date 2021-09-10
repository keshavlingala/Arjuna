package com.arjuna.season16;

import java.util.ArrayList;
import java.util.Scanner;

public class SellingGold {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int months = scanner.nextInt();
        ArrayList<Integer> prices = new ArrayList<Integer>();

        for (int i = 0; i < months; i++) {
            prices.add(scanner.nextInt());
        }
        //algoritm
        int min = 9999;
        for (int i = 0; i < prices.size(); i++) {
            for (int j = i; j < prices.size(); j++) {
                int diff = prices.get(i) - prices.get(j);
                if (diff < min && diff > 0) {
                    min = diff;
                }
            }
        }
        System.out.println(min);

    }
}
