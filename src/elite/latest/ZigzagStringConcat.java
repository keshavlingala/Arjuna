package com.elite.latest;

/*
 *

Given a string and number of rows 'n'.
Print the string formed by concatenating n rows when input string is
written in row-wise Zig-Zag fashion.

Sample Input:
ABCDEFGHIJKLM
3
Sample Output:
AEIMBDFHJLCGK

Explanation: Let us write input string in Zig-Zag fashion
             in 3 rows.
A       E       I       M
  B   D   F   H   J   L
    C       G       K
Now concatenate the two rows and ignore spaces
in every row. We get "AEIMBDFHJLCGK"


 *
 */

import java.util.Arrays;
import java.util.Scanner;

class ZigzagStringConcat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int size = scanner.nextInt();
        if (size == 1) {
            System.out.println(new String(input));
            System.exit(0);
        }
        char[][] ans = new char[size][input.length];
        int i = 0, j = 0, ip = 0;
        while (ip < input.length) {
            while (i < size - 1 && ip < input.length && ip >= 0) {
                ans[i][j] = input[ip++];
                i++;
            }
            ans[size - 1][j] = '#';
            j++;
            while (i > 0 && ip < input.length && ip >= 0) {
                ans[i][j] = input[ip++];
                i--;
            }
            ans[0][j] = '#';
            j++;
        }
//        System.out.println(Arrays.deepToString(ans));
        for (char[] a : ans) {
            String n = (new String(a)).trim().replaceAll("#", "");
            System.out.print(n);
        }

    }
}
/*
NGITKMIT
1
NGITKMIT

FINISHING SCHOOL
3
FSGHIIHN COLNISO

SONETFINISHING
8
SOGNNEITHFSIIN

SONETFINISHING
13
SONETFINISHIGN*/