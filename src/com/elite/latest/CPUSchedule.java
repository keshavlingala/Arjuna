package com.elite.latest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CPUSchedule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCount = 0;
        List<String> processes = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        int limit = scanner.nextInt();
        List<Integer> counts = processes
                .stream().distinct()
                .map(i -> Collections
                        .frequency(processes, i))
                .collect(Collectors.toList());
        while (counts.size() > 0) {
            tCount += counts.size();
            int size = counts.size();
            counts = counts.stream()
                    .map(i -> i - 1)
                    .filter(p -> p > 0)
                    .collect(Collectors.toList());
            if (counts.isEmpty())
                break;
            if (size <= limit) {
                tCount += limit - size + 1;
            }
        }
        System.out.println(tCount);
    }
}
