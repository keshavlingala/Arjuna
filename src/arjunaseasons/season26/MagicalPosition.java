package com.arjuna.season26;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicalPosition {
    public static void main(String[] args) {
//        So basically my solution is finding all
//        the permutations from 0000 to 9999 and
//        find the number of steps took to from 0000 to that number and put it at that position of x-axis
//        as path is reversible we need to iterate twice once from 0 to 9999 and another from 9999 to 0
//        replace the previous value with minimum steps took

        Scanner scanner = new Scanner(System.in);
        String[] deadLocks = scanner.nextLine().split(" ");
        int target = scanner.nextInt();
        int[] x_axis = new int[10010];
//        10010 is due to an iteration may lead outOfBoundException
        Arrays.fill(x_axis, Integer.MAX_VALUE - 10);
//        filling all elements in array(size of 10000) to maximum
        x_axis[0] = 0;
        x_axis[10000] = 0;
//        back of 9999 and 0000 are making it zero
        for (String i : deadLocks) {
            try {
                x_axis[Integer.parseInt(i.trim())] = -1;
            } catch (NumberFormatException ignored) {
            }
//            if there are bad inputs in the line that is ignored
        }
        for (int i = 0; i < 10000; i++) {
            if (x_axis[i] == -1) continue;
//            if deadlock at that position ignore (let it stay max value)
            for (int j = 0; j < 4; j++) {
                int incrementedValue = increment(i, j, false);
//                i is one of the number from 0000 to 9999 j is position in the number itself
                if (x_axis[incrementedValue] == -1) {
                    continue;
                }
//                if incremented value is deadlock then also skip that means that number cannot be reached
                x_axis[incrementedValue] = Math.min(x_axis[incrementedValue], x_axis[i] + 1);
            }
        }
//        exactly same but in reverse order
        for (int i = 10000; i > 0; i--) {
            if (x_axis[i] == -1) continue;
            for (int j = 0; j < 4; j++) {
                int incrementedValue = increment(i, j, true);
//                here true means the number gets decremented
                if (x_axis[incrementedValue] == -1) {
                    continue;
                }
//                finally the moves at the target position is stored at the axis
                x_axis[incrementedValue] = Math.min(x_axis[incrementedValue], x_axis[i] + 1);
            }
        }
        System.out.println(x_axis[target] >= Integer.MAX_VALUE - 10 ? "-1" : x_axis[target]);
    }

    static Integer increment(int number, int position, boolean decrement) {
        String x = toString(number);
        List<Integer> chars;
        try {
            chars = Arrays.stream(x.split("")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (NumberFormatException ignored) {
            chars = null;
        }
        if (!decrement) {
            //single method increment can also decrement depends on the boolean value at 3rd parameter
            chars.set(position, chars.get(position) + 1);
            if (chars.get(position) > 9)
                chars.set(position, 0);
        } else {
            chars.set(position, chars.get(position) - 1);
            if (chars.get(position) < 0)
                chars.set(position, 9);
        }
        StringBuilder incrementedValue = new StringBuilder();
        for (int i : chars) incrementedValue.append(i);
        try {
            return Integer.parseInt(incrementedValue.toString());
        } catch (NumberFormatException ignored) {
            return null;
        }
    }

    private static String toString(int x) {
//        converting an int to 4 digit string
        String number = "" + x;
        if (number.length() == 4) return number;
        if (number.length() == 3) return "0" + number;
        if (number.length() == 2) return "00" + number;
        if (number.length() == 1) return "000" + number;
        else return "0000";
    }
}
