package com.elite.online.day46;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SahooJet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();// input all heights of skyscrapers
        Stack<List<Integer>> start = new Stack<>();
        long c = 0;
        for (int value : a) {
            //make sure skyscraper heights are in descending order.
            //if not , remove the less height skyscraper from the stack
            while (!start.empty() && start.peek().get(0) < value) {
                start.pop();
            }
            //compare top of the stack skyscraper height with current skyscraper height
            //if both are equal,
            if (!start.empty() && start.peek().get(0) == value) {
                c += start.peek().get(1);//increment the count by frequency of current skyscraper
                start.peek().set(1, start.peek().get(1) + 1);//update the frequency of current skyscraper in stack
            } else {
                List<Integer> newStart = new ArrayList<>(2);
                newStart.add(value);//add height of the skyscraper
                newStart.add(1);//add its initial frequency as 1.
                start.push(newStart);
            }

        }
        System.out.println(c * 2); // multiply by 2 because from right to left  jump is also possible
    }
}
