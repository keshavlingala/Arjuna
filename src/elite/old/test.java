package com.elite.old;

import java.util.function.Predicate;

class test {
    public static void main(String[] args) {
        Predicate<Integer> even = (u) -> {
            return (u & 1) == 0;
        };
        Predicate<Integer> odd = (u) -> {
            return (u & 1) == 1;
        };
        System.out.println(even.and(odd).test(2));
    }
}
