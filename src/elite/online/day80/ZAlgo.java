package com.elite.online.day80;
/*
* Input Format :
        - A String 'S' to Process

Output Format :
        - The sum of similarities of a string S with each of it's suffixes

Sample Input

acacaa

Sample Output

11



Explanation :

For the first case, the suffixes of the string are "acacaa", "cacaa", "acaa", "caa", "aa" and "a".
The similarities of these strings with the string "ababaa" are 6,0,3,0,1, & 1 respectively.

Thus, the answer is 6 + 0 + 3 + 0 + 1 + 1 = 11.


Sample Input
cc

Sample Output
3

the answer is 2 + 1 = 3.

*/

import java.util.Arrays;
import java.util.Scanner;

public class ZAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.toString(zAlgorithm("ginnestinggin gniinginging$gni")));

    }

    static void printPermutn(String str, String ans) {

        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            printPermutn(ros, ans + ch);
        }
    }

    static int[] zAlgorithm(String s) {
        int n = s.length();
        int[] z = new int[n];
        for (int i = 1, l = 0, r = 0; i < n; ++i) {
            if (i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                ++z[i];
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
}
