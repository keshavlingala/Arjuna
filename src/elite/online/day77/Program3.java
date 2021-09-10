package com.elite.online.day77;
/*
* You are working as the quality controller at Pearlpet plastic bottle factory.
Each assembly line of the factory is always supposed to produce a set of bottles
in ascending order of their heights. Sometimes there is a manufacturing defect and
the bottles come out in a different order.

You are allowed to do only ONE of the following corrections once. SWAP is prefered.
    a) Swap two bottles.
    b) Reverse one subsequence of bottles.


Input Format:
    - An integer N, indicates no of bottles
    - Next line contains N space seperated integers, h1,h2,h3,..hn
      indicates heights of bottles

Output Format:


Sample Input:
7
1 2 5 9 8 12 14
Sample Output:
swap 4 5

Explanation:
( 1 based indexes)
In this case the swap is adequate (remember you are allowed only 1 correction)


Sample Input:
7
1 2 12 9 8 5 14
Sample Output:
reverse 3 6

NOTE:
If you cannot correct either with a single swap or reverse
then you need to print "NOT POSSIBLE"

*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> nums = IntStream.range(0, scanner.nextInt()).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> backup = new ArrayList<>();
        backup.addAll(nums);
        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.addAll(nums);
        sorted.sort((Comparator.comparingInt(o -> o)));
        int c = 0;
        String ans = "";
        for (int i = 0; i < nums.size(); i++)
            if (!nums.get(i).equals(sorted.get(i))) {
                ans += (i + 1) + " ";
                c++;
            }
        if (c == 2) {
            System.out.println("swap " + ans.trim());
        } else ans = "";

//        System.out.println(nums);
//        System.out.println(sorted);
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i).equals(sorted.get(i))) {
                nums.remove((int) i);
                sorted.remove((int) i);
                i--;
            }
        }
//        System.out.println("After sort");
        Collections.reverse(sorted);
//        System.out.println(nums);
//        System.out.println(sorted);
        if (nums.equals(sorted)) {
//            System.out.println(sorted);
            int start = backup.indexOf(sorted.get(0)) + 1;
            int end = backup.indexOf(sorted.get(sorted.size() - 1)) + 1;
            System.out.println("reverse " + start + " " + end);
        } else {
            System.out.println("NOT POSSIBLE");
        }


    }
}
