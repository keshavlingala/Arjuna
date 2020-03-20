package com.other;/*
 * 
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

 */


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RelativeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> nums = IntStream.range(0, sc.nextInt()).mapToObj(i -> sc.nextInt()).collect(Collectors.toCollection(ArrayList::new));

        int number2 = sc.nextInt();
        int[] arr2 = new int[number2];

        for (int i = 0; i < number2; i++) {
            arr2[i] = sc.nextInt();
        }
        for (int i : arr2) {
            while (nums.contains(i)) {
                nums.remove((Integer) i);
                System.out.println(i);
            }
        }
        nums.sort(Integer::compareTo);
        LinkedList<Integer> q=new LinkedList<>();

        for (int i : nums) {
            System.out.println(i);
        }
    }
}