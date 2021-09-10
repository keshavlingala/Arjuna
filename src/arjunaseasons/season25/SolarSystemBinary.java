package com.arjuna.season25;

import java.util.*;
import java.util.stream.Collectors;

public class SolarSystemBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()); //mapping each value to parseInt of itself and collecting it all to a list and returning
        int leftHours = scanner.nextInt();
        int minK = 1, maxK = Collections.max(list), mid = (minK + maxK) / 2, result = 0, hoursTook = 0;
        while (mid > minK) {
            for (int number : list) {
                hoursTook += Math.ceil(number / (float) mid);
            }
            if (hoursTook <= leftHours) {
                maxK = mid;
                result = mid;
                mid = (minK + maxK) / 2;
            } else {
                minK = mid;
                mid = ((minK + maxK) / 2) + 1;
            }
            hoursTook = 0;
        }
        System.out.println(result);
    }
}
