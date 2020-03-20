package com.codevita;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleLove {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        System.out.println(Arrays.stream(a).reduce(0, Integer::sum));
    }
}
