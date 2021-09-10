package com.arjuna.season22;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Boats {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> packages = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int minWeight = Integer.parseInt(scanner.nextLine().trim());
        int boats = 0;
        Collections.sort(packages);
        while (!packages.isEmpty()) {
            if (packages.get(packages.size() - 1) == minWeight) {
                boats++;
                packages.remove(packages.size() - 1);
            } else {
                if (packages.size() == 1) {
                    boats++;
                    break;
                }
                if (packages.get(0) + packages.get(packages.size() - 1) <= minWeight) {
                    boats++;
                    packages.remove(packages.size() - 1);
                    packages.remove(0);
                } else {
                    boats += 2;
                    packages.remove(packages.remove(packages.size() - 1));
                    packages.remove(0);
                }
            }
        }
        System.out.println(boats);
    }
}
