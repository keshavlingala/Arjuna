package org.functionalInterfaces;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DPridicate {
    public static void main(String[] args) {
        Function<Integer, Double> f = (i) -> (double) i;
        UnaryOperator<Integer> plusTwo = (integer -> integer + 2);
        System.out.println(plusTwo.apply(5));
    }
}
