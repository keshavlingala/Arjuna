package org.functionalInterfaces;

import java.util.function.Predicate;

public class EvenOdd {
    public static void main(String[] args) {
        Predicate<Integer> even = (k) -> (k & 1) == 0;
        System.out.println(even.test(20));
    }
}
