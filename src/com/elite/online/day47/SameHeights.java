package com.elite.online.day47;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SameHeights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int sum1 = 0, sum2 = 0, sum3 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        for (int i = 0; i < n1; i++) {
            int a = scanner.nextInt();
            sum1 += a;
            q1.add(a);
        }
        for (int i = 0; i < n2; i++) {
            int a = scanner.nextInt();
            sum2 += a;
            q2.add(a);
        }
        for (int i = 0; i < n3; i++) {
            int a = scanner.nextInt();
            sum3 += a;
            q3.add(a);
        }
        while (!q1.isEmpty() && !q2.isEmpty() && !q3.isEmpty()) {
            if (sum1 == sum2 && sum2 == sum3)
                break;
            if (sum1 >= sum2 && sum1 >= sum3)
                sum1 -= q1.remove();
            else if (sum2 >= sum1 && sum2 >= sum3)
                sum2 -= q2.remove();
            else sum3 -= q3.remove();
        }
        System.out.println(sum1);
    }
}
