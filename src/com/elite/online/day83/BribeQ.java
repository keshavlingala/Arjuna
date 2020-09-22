package com.elite.online.day83;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;


public class BribeQ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = IntStream.range(0, n).mapToObj(i -> sc.nextInt()).toArray(Integer[]::new);
        int ans = 0;
        Predicate<Integer> greaterThanOrEqualsToZero = (i) -> i >= 0;
        Predicate<Integer> checkIfNotInSamePosition = (i) -> arr[i] != i + 1;
        Predicate<Integer> checkIfBribeIsGreaterThanTwo = (i) -> arr[i] - i - 1 > 2;
        Predicate<Integer> checkIfBribeIsOne = (i) -> i - 1 >= 0 && arr[i - 1] == i + 1;
        Predicate<Integer> checkIfBribeIsTwo = (i) -> i - 2 >= 0 && arr[i - 2] == i + 1;
        UnaryOperator<Integer> decrementByOne = (i) -> i - 1;
        UnaryOperator<Integer> incrementByOne = (i) -> i += 1;
        BiConsumer<Integer, Integer> swapInArr = (i, j) -> Collections.swap(Arrays.asList(arr), i, j);
        Consumer<String> print = System.out::println; //For Debug Purpose
        int i = n - 1;
        for (; greaterThanOrEqualsToZero.test(i); i = decrementByOne.apply(i)) {
            if (checkIfNotInSamePosition.test(i)) {
                if (checkIfBribeIsGreaterThanTwo.test(i)) {
                    print.accept("Not Possible");
                    return;
                } else if (checkIfBribeIsOne.test(i)) {
                    swapInArr.accept(i, i - 1);
                    ans = incrementByOne.apply(ans);
                } else if (checkIfBribeIsTwo.test(i)) {
                    swapInArr.accept(i - 1, i - 2);
                    swapInArr.accept(i, i - 1);
                    ans = incrementByOne.andThen(incrementByOne).apply(ans); //incrementByTwo
                }
            }
        }
        System.out.println(ans);
    }
}
