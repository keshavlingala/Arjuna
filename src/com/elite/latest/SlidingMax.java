package com.elite.latest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SlidingMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = scanner.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] dpl = new int[nums.length];
        int[] dpr = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            if (i % size == 0)
                dpl[i] = nums[i];
            else
                dpl[i] = Math.max(dpl[i - 1], nums[i]);
        dpr[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((i + 1) % size == 0)
                dpr[i] = nums[i];
            else
                dpr[i] = Math.max(nums[i], dpr[i + 1]);
        }
        for (int i = 0; i < nums.length - size + 1; i++) {
            ans.add(Math.max(dpl[i + size - 1], dpr[i]));
        }
        System.out.println(Arrays.toString(dpl));
        System.out.println(Arrays.toString(dpr));
        System.out.println(ans);

    }
}
//*
//  case =1
//    2 input =76 2 4 23 5 67 4 89
//    3 3
//    4 output =76 23 23 67 67 89
//    5
//    6 case =2
//    7 input =7 2 14 -23 55 6 42 8 23 46 82
//    8 4
//    9 output =[14, 55, 55, 55, 55, 42, 46, 82]
//   10
//   11 case =3
//   12 input =71 2 14 123 55 6 62 38 23 46 82
//   13 5
//   14 output =[123, 123, 123, 123, 62, 62, 82]
//   15
//   16 case =4
//   17 input =2 14 -23 55 6 42 8 23 46
//   18 6
//   19 output =[55, 55, 55, 55]
//   20
//   21 case =5
//   22 input =76 2 4 23 5 67 4 89 2 14 -23 55 6 42 8 23 46
//   23 6
//   24 output =[76, 67, 89, 89, 89, 89, 89, 89, 55, 55, 55, 55]
//   25 */