package com.elite.latest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordPlay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        List<String> wordlist = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        List<String> ans = wordlist.stream()
                .filter(word -> isSub(word, target))
                .sorted((o1, o2) -> {
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }).collect(Collectors.toList());
        if (ans.isEmpty())
            System.out.println(-1);
        else
            System.out.println(ans.get(0));
    }

    static boolean isSub(String s, String t) {
        int n = s.length();
        int m = t.length();
        int j = 0;
        for (int i = 0; j < n && i < m; i++) {
            if (s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        return j == n;
    }

}
