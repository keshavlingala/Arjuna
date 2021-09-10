package com.arjuna.season28;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
0 1 2
3 4 5
6 7 8
9
*/
public class Gulliver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] number = scanner.next().split("");
        int currPosition = 0;
        for (int i = 0; i < number.length; i++) {
            int next = Integer.parseInt(number[i]);
            while ((next / 3 - currPosition / 3) > 0) {
                System.out.print("D");
                currPosition += 3;
            }
            while ((next / 3 - currPosition / 3) < 0) {
                System.out.print("U");
                currPosition -= 3;
            }
            while ((next % 3 - currPosition % 3) > 0) {
                System.out.print("R");
                currPosition++;
            }
            while ((next % 3 - currPosition % 3) < 0) {
                System.out.print("L");
                currPosition--;
            }
            if (currPosition == next) System.out.print("-");
        }
    }
}
