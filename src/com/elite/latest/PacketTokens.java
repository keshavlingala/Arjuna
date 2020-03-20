package com.elite.latest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PacketTokens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Integer> q;
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        q = IntStream.range(0, nums.length).boxed().collect(Collectors.toCollection(LinkedList::new));
        int i = 0;
        int[] ans = new int[nums.length];
        while (!q.isEmpty()) {
            int first = q.poll();
            ans[first] = nums[i++];
            if (!q.isEmpty())
                q.add(q.poll());
        }
        System.out.println(Arrays.toString(ans));
    }
}
