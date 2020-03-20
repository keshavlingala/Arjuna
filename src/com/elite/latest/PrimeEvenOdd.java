package com.elite.latest;

import java.util.Scanner;
import java.util.function.Predicate;

public class PrimeEvenOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<Integer> prime = (x) -> {
            for (int i = 2; i <= x / 2; i++) {
                if (x % i == 0)
                    return false;
            }
            return true;
        };
        Predicate<Integer> even = x -> (x & 1) == 0;
        Predicate<Integer> odd = x -> (x & 1) == 1;
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println(-1);
            System.exit(0);
        }
        if (prime.test(n)) {
            int s = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(s++ + " ");
                }
                System.out.println();
            }
        } else if (even.test(n)) {
            int s = 0;
            for (int i = 1; i <= n; i++) {
                if (even.test(i)) {
                    s = s + i - 1;
                    for (int j = 0; j < i; j++) {
                        System.out.print(s-- + " ");
                    }
                } else {
                    s += i;
                    for (int j = 0; j < i; j++) {
                        System.out.print(s++ + " ");
                    }
                }
                System.out.println();
            }

        } else if (odd.test(n)) {
            int s = 1;
            for (int i = 1; i <= n; i++) {
                if (odd.test(i)) {
                    s = s + i - 1;
                    for (int j = 0; j < i; j++) {
                        System.out.print(s-- + " ");
                    }
                } else {
                    s += i;
                    for (int j = 0; j < i; j++) {
                        System.out.print(s++ + " ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println(-1);
        }

    }
}
