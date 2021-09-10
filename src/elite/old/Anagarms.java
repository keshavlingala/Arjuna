package com.elite.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Anagarms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().trim();
        String target = scanner.next();
        System.out.println(searchAnagrams(line, target));
    }

    static ArrayList<Integer> searchAnagrams(String s, String p) {
        int M = p.length();
        int N = s.length();
        if (N < M)
            return new ArrayList<Integer>();
        char[] countP = new char[256];
        char[] countTW = new char[256];
        for (int i = 0; i < M; i++) {
            (countP[p.charAt(i)])++;
            (countTW[s.charAt(i)])++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = M; i < N; i++) {
            if (Arrays.equals(countP, countTW))
                ans.add(i - M);
            (countTW[s.charAt(i)])++;
            countTW[s.charAt(i - M)]--;
        }
        if (Arrays.equals(countP, countTW)) ans.add(N - M);
        return ans;
    }
}
