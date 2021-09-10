package com.elite.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LongIncSub {
    public static void main(String[] args) {
        int[] arr = Arrays.stream((new Scanner(System.in)).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int value : arr) {
            int index = Collections.binarySearch(ans, value);
            if (index >= 0)
                continue;
            if (index == -(ans.size() + 1))
                ans.add(value);
            else
                ans.set(ans.size() - 1, value);
        }
        System.out.println(ans);
        System.out.println(ans.size());
    }
}

