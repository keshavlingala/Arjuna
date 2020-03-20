package com.arjuna.season26;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeeraShares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfDays = scanner.nextInt();
        int shareCount = scanner.nextInt();
        List<Integer> days = IntStream.range(0, noOfDays).mapToObj(i -> scanner.nextInt()).collect(Collectors.toList());
        int[] profits = new int[days.size()];
        // Simple for Loop to find the profits she can get for each day if she invest
        for (int i = 0; i < days.size(); i++) {
            profits[i] = (Collections.max(days.subList(i, days.size())) * shareCount) - days.get(i) * shareCount;
        }
        // Get the max profits
        int max = Arrays.stream(profits).max().getAsInt();
        // if she gets loss then 0 profits
        System.out.println(max < 0 ? "0" : max);
    }
}
