package com.elite.old;
/*
Problem: write a program to find Maximum area for given sequence of plots.
In a layout of plots, all plots are having equal width, which is 10 meters, but these
plots varies in length For a given sequence of plots lengths, you need find what is maximum
rectangle area you can make ?

		 ----------
 		 |		  |
---------|        |
|		 | 		  |---------
| 30*10	 | 40*10  |	25*10  |
|		 |		  |		   |---------
|		 |		  |		   |  20*10 |
-------------------------------------

Sample Input:
4
30 40 25 20

Sample Output:
800

Explanation:
	 Max Area is 4*10*20 = 800 sq meters

 */

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class MaxAreaOfSeqOfPlots {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = IntStream.range(0, n).map(i -> sc.nextInt()).toArray();
        Stack<Integer> s = new Stack<Integer>();
        int maxA = 0;
        int i = 0;
        while (i < blocks.length) {
            if (s.isEmpty() || blocks[s.peek()] <= blocks[i]) {
                s.push(i++);
            } else {
                int top = s.pop();
                maxA = Math.max(maxA, blocks[top] * (s.isEmpty() ? i : i - s.peek() - 1)*10);

            }
        }
        while (!s.isEmpty()) {
            int top = s.pop();
            maxA = Math.max(maxA, blocks[top] * (s.isEmpty() ? i : i - s.peek() - 1)*10);
        }
        System.out.println(maxA);
    }

}
