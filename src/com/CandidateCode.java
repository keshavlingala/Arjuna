package com;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CandidateCode {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testcases = Integer.parseInt(scanner.nextLine().trim());
        for (int t = 0; t < testcases; t++) {
            int n = scanner.nextInt();
            long[] gRev = new long[n];
            long[] aStar = new long[n];
            for (int i = 0; i < n; i++) gRev[i] = scanner.nextLong();
            for (int i = 0; i < n; i++) aStar[i] = scanner.nextLong();
            TreeMap<Long, Integer> hp = new TreeMap<>();
            for (long l : gRev) hp.put(l, hp.getOrDefault(l, 0) + 1);
            int ans = 0;
//            System.out.println(hp);
            for (long l : aStar) {
                hp.putIfAbsent(l, 0);
                Map.Entry<Long, Integer> index = hp.higherEntry(l);
                if (hp.get(l) == 0) hp.remove(l);
                if (index == null) continue;
                long next = index.getKey();
                hp.put(next, hp.get(next) - 1);
                ans++;
                if (hp.get(next) == 0) hp.remove(next);
            }
            System.out.println(ans);
        }
    }
}
