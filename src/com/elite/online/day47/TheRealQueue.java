package com.elite.online.day47;

import java.util.Arrays;
import java.util.Scanner;

public class TheRealQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tickets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int i = 0;
        int time = 1;
        int alex = scanner.nextInt();
        while (tickets[alex] != 0) {
            if (tickets[i] != 0) tickets[i++]--;
            else i++;
            if (tickets[alex] == 0) break;
            if (i == tickets.length) i = 0;
            if (tickets[i] == 0) continue;
            time++;
        }
        System.out.println(time);
    }
}
