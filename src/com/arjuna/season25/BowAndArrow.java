package com.arjuna.season25;

import java.util.Scanner;

public class BowAndArrow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String magicNo = scanner.next();
        String guess = scanner.next();
        int a = 0;
        int b = 0;

        // as the length f the number can be very low so without using additional array may optimize code i think
        // check for arrows
        for (int i = 0; i < magicNo.length(); i++) {
            if (guess.charAt(i) == magicNo.charAt(i)) {
                a++;
                guess = guess.substring(0, i) + guess.substring(i + 1);
                magicNo = magicNo.substring(0, i) + magicNo.substring(i + 1);
                i--;
                // as a char is removed decrement the i pointer
            }
        }
        // after calculating and removing all the arrows
        // now for bows an dif found remove it in magic number so that not to repeat same again
        for (int i = 0; i < guess.length(); i++) {
            if (magicNo.contains(guess.charAt(i) + "")) {
                b++;
                int r = magicNo.indexOf(guess.charAt(i));
                magicNo = magicNo.substring(0, r) + magicNo.substring(r + 1);
            }
        }
        System.out.print(a + "A" + b + "B");
    }
}