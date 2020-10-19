package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Reconstruct2DArray {
    public static void main(String[] args) {
        System.out.println(reconstructMatrix(4, 7, new int[]{2, 1, 2, 2, 1, 1, 1}));
    }

    static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                ans.get(0).add(1);
                ans.get(1).add(1);
                upper--;
                lower--;
                continue;
            } else if (colsum[i] == 0) {
                ans.get(0).add(0);
                ans.get(1).add(0);
                continue;
            } else {
                ans.get(0).add(0);
                ans.get(1).add(0);
            }
        }
        System.out.println(upper + " " + lower);
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 0 || colsum[i] == 2) continue;
            if (upper > 0) {
                ans.get(0).set(i, 1);
                upper--;
            } else if (lower > 0) {
                ans.get(1).set(i, 1);
                lower--;
            } else {
                System.out.println(ans);
                return new ArrayList<>();
            }
            System.out.println(upper + " " + lower);
        }
        return ans;
    }
}
