package com.elite.latest.chillar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
