package Tests;

import java.util.ArrayList;

public class Exam {
    static int ans;
    static ArrayList<Integer> limit;

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(8);
        arr.add(3);
        arr.add(10);
        arr.add(7);
        System.out.println(solve(10, arr));

    }

    public static int solve(int A, ArrayList<Integer> B) {
        // if only one day no. of activities is ans
        if (A == 1) {
            return B.size();
        }
        limit = B;
        for (int i = 0; i < B.size(); i++) {
            rec(i, limit.get(i) - 1, A - 1);
        }
        return ans;
    }

     static private void rec(int activityIndex, int activityLimit, int dayCount) {
        if (dayCount == 0) {
            ans++;
            return;
        }
        for (int i = 0; i < limit.size(); i++) {
            if (activityIndex == i && activityLimit == 0) continue;
            if (activityIndex == i && activityLimit > 0) {
                rec(i, activityLimit - 1, dayCount - 1);
            } else {
                rec(i, limit.get(i)-1, dayCount - 1);
            }
        }

    }

}