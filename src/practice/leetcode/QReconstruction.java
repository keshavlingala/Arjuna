package practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class QReconstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        System.out.println(Arrays.deepToString(reconstructQueue(arr)));
    }

    static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        System.out.println(Arrays.deepToString(people));
        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] person : people)
            ans.add(person[1], person);
        return ans.toArray(int[][]::new);
    }
}
