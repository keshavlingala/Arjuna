package exams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//https://leetcode.com/problems/maximum-profit-in-job-scheduling/ import java.util.*;
public class Earnings {
    public static void main(String[] args) {
// System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] ar = new int[n][3];
        for (int i = 0; i < n; ++i) {
            String start = sc.next();
            String end = sc.next();
            int profit = sc.nextInt();
            ar[i] = new int[]{Integer.parseInt(start), Integer.parseInt(end), profit};
        }
        Arrays.sort(ar, (x, y) -> x[1] - y[1]);
        int[] res = compute(ar, n);
        System.out.println(res[0] + " " + res[1]);
    }

    static int[] compute(int[][] ar, int n) {
        List<Integer> jobsFinish = new ArrayList<>();
        List<Integer> profits = new ArrayList<>();
        List<Integer> startTime = new ArrayList<>();
        jobsFinish.add(0);
        startTime.add(0);
        profits.add(0);
        int tot_profits = 0;
        int prev = 0;
        for (int[] arr : ar) {
            int cs = arr[0];
            int et = arr[1];
            int cp = arr[2];
            tot_profits += cp;
            int ind = binarySearch(jobsFinish, cs + 1);
            int pro = cp + profits.get(ind);
            if (pro > prev) {
                prev = pro;
                jobsFinish.add(et);
                profits.add(prev);
                startTime.add(cs);
            }
        }
        int ind = startTime.size() - 1;
        if (ind < 1) {
            return new int[]{n, tot_profits};
        }
        int res_start = startTime.get(ind--);
        int c = 1;
        while (ind > 0) {
            int t_end = jobsFinish.get(ind);
            if (t_end < res_start) {
                res_start = startTime.get(ind);
                ++c;
            }
            --ind;
        }
        return new int[]{n - c, tot_profits - prev};
    }

    static int binarySearch(List<Integer> jobsFinish, int val) {
        int l = 0, r = jobsFinish.size() - 1;
        while (l < r - 1) {
            int ind = l + (r - l) / 2;
            if (jobsFinish.get(ind) < val)
                l = ind;
            else
                r = ind - 1;
        }
        return jobsFinish.get(r) < val ? r : l;
    }

}