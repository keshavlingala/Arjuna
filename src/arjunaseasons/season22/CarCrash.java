package com.arjuna.season22;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarCrash {
    static List<Integer> cars;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        cars = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean changed = false;
        while (!changed) {
            changed = true;
            for (int i = 0; i < cars.size() - 1; i++) {
                if (cars.get(i) > 0 && cars.get(i + 1) < 0) {
                    if (Math.abs(cars.get(i)) == Math.abs(cars.get(i + 1))) {
                        cars.remove(i);
                        cars.remove(i + 1);
                    } else {
                        if (Math.abs(cars.get(i)) > Math.abs(cars.get(i + 1)))
                            cars.remove(i + 1);
                        else cars.remove(i);
                    }
                    changed = false;
                    break;
                }
            }
        }
        if (cars.size() == 0)
            System.out.print("-1");
        else
            for (int i : cars)
                System.out.print(i + " ");
    }
}