package Tests;

import java.util.Scanner;

public class Main {
    static int count(String s, String t) {
        int[][] arr = new int[256][t.length() + 1];
        int[] cnt = new int[t.length() + 1];
        cnt[0] = 1;
        char c;
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            arr[c][arr[c][0] + 1] = i + 1;
            arr[c][0]++;
        }
        for (char a : s.toCharArray()) {
            if (arr[a][0] != 0)
                for (int i = arr[a][0]; i > 0; i--)
                    cnt[arr[a][i]] += cnt[arr[a][i] - 1];
        }
        return cnt[t.length()];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(count(sc.next(), sc.next()));
    }
}