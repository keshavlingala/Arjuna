package com.arjuna.season29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DisneyLand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> days = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> prices = IntStream.range(0, 3).mapToObj(i -> scanner.nextInt()).collect(Collectors.toList());
        int dayPass = 0, weekCost = 0, monthCost = 0;
        int temp = 0;
        int w = 0, m = 0;
        for (int i : days) {
            dayPass += prices.get(0);
            if (i > w) {
                weekCost += prices.get(1);
                w += 7;
            }
            if (i > m) {
                monthCost += prices.get(2);
                m += 30;
            }
        }
    }
}
