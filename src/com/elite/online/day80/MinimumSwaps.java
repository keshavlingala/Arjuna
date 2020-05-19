package com.elite.online.day80;
/*
*
Input Format

The first line contains a single integer n, , the number of elements in arr.
The second line contains n space-separated integers arr[i].


Output Format

Return the minimum number of swaps needed to make the array beautiful.

Sample Input
4
2 5 3 1

Sample Output
2


*/

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MinimumSwaps {
    static int minSwaps(Integer[] ori, Integer[] sor) {
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < sor.length; i++)
            hp.put(sor[i], i);
        boolean[] visited = new boolean[ori.length];
        int swaps = 0;
        for (int i = 0; i < ori.length; i++) {
            if (!visited[i] && !ori[i].equals(sor[i])) {
                visited[i] = true;
                int next = hp.get(ori[i]);
                while (!visited[next] && !ori[next].equals(sor[next])) {
                    swaps++;
                    visited[next] = true;
                    next = hp.get(ori[next]);
                }
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] nums = IntStream.range(0, n).map(i -> scanner.nextInt()).boxed().toArray(Integer[]::new);
        Integer[] acs = Arrays.copyOf(nums, nums.length);
        Arrays.sort(acs);
        Integer[] dcs = acs.clone();
        Collections.reverse(Arrays.asList(dcs));
//        System.out.println(Arrays.toString(dcs));
//        System.out.println(Arrays.toString(acs));
//        System.out.println(minSwaps(nums, acs));
//        System.out.println(minSwaps(nums, dcs));
        System.out.println(Math.min(minSwaps(nums, acs), minSwaps(nums, dcs)));
    }
}
