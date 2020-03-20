package com.arjuna.season26;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class President {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> votes = Arrays.stream(scanner.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> time = Arrays.stream(scanner.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> line3 = Arrays.stream(scanner.nextLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (int value : line3) {
            System.out.print(findLead(value, votes, time) + " ");
        }
    }

    private static int findLead(int i, List<Integer> votes, List<Integer> time) {
        int rangeIndex = 0;
        while (time.get(rangeIndex) <= i) {
            if (time.get(rangeIndex) == i) {
                rangeIndex++;
                break;
            }
            rangeIndex++;
        }
        //finding the value time range index of the value (above)
        int zero = Collections.frequency(votes.subList(0, rangeIndex), 0);
        int one = Collections.frequency(votes.subList(0, rangeIndex), 1);
        // counting the number of 0s and 1s in the votes and return the max and last index if equal
        if (zero == one) {
            return votes.get(rangeIndex - 1);
        } else if (zero > one) {
            return 0;
        } else {
            return 1;
        }
    }
}
