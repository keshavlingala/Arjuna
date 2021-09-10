package com.elite.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProduceBraces {
    public static List<String> generateBarces(int n) {
        List<String> ans = new ArrayList();
        abGenerate(ans, "", 0, 0, n);
        Collections.sort(ans);
        return ans;
    }

    public static void abGenerate(List<String> ans, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            abGenerate(ans, cur + "A", open + 1, close, max);
        if (close < open)
            abGenerate(ans, cur + "B", open, close + 1, max);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        System.out.println(generateBarces(n));
    }
}
