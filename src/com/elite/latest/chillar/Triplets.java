package com.elite.latest.chillar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Triplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int sum = scanner.nextInt();
        for (int i = 0; i < nums.size() - 3; i++) {
            int a = sum - nums.get(i);
            for (int j = i + 1; j < nums.size() - 2; j++) {
                int z = a - nums.get(j);
                if (nums.subList(j + 1, nums.size()).contains(z)) {
                    System.out.println(Arrays.toString(Stream.of(nums.get(i), nums.get(j), z).sorted().toArray()));
                    System.exit(0);
                }
            }
        }
        System.out.println(-1);
    }
}
