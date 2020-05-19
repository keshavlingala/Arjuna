package com.elite.online.day48;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
* Shakuni, a self-employed photo frame maker, has started his business. In short time,
he became popular as the frames were quite good and more importantly the prices were
reasonable. Now that the business is on track, Shakuni, in order to make more money, has
devised a cunning formula for the prices. According to the new formula, in a given transaction,
per customer, the price of a frame shall be equal to
its current price * (number of frames purchased previously + 1).

Bheem and his friends wanted to purchase some photo frames. After knowing the pricing
formula of Sakuni to maximize the cost of frames, he is looking for someone to help him with
an idea that gives the minimum cost and buy the required number of photo frames for him and
his friends.

Given, the total number of Frames (F), the number of friends (N) and the price list of all
frames,write a program to find the minimum total cost that
Bheem must pay to purchase F number of frames from Shakuni.

Sample:
    Input
        3 2
        2 5 6
    Output
        15
    Comments
        The first line 3 2 – Total Frames (F=3) and Friends(N=2)
        Second line 2 5 6 – Prices of Frames

    Explanation:
        First person
        o purchases Frame of 5 so its cost is
        (0+1)*5 = 5
        o Purchases Frame of 2 so its cost is
        (1+1)*2 = 4

        Second Person
        o Purchases Frame of 6 so its cost is
        (0+1)*6 = 6

        Total Cost of Frames = 5 + 4 + 6 = 15

Sample 2
    input:
        3 2
        5 6 2
    output:
        15
*/
public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int frames = scanner.nextInt();
        int friends = scanner.nextInt();
        Integer[] cost = new Integer[frames];
        for (int i = 0; i < frames; i++) cost[i] = scanner.nextInt();
        Arrays.sort(cost, Collections.reverseOrder());
        int[] prev = new int[friends];
        int j = 0;
        int ans = 0;
        for (int i = 0; i < frames; i++) {
            ans += (prev[j] + 1) * cost[i];
            prev[j]++;
            j++;
            if (j == friends) j = 0;
        }
        System.out.println(ans);

    }
}
