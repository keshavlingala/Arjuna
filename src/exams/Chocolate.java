package exams;

import java.util.Scanner;

public class Chocolate {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minL = scanner.nextInt(), maxL = scanner.nextInt(), minW = scanner.nextInt(), maxW = scanner.nextInt();
        dp = new int[Math.max(maxL, maxW)][Math.max(maxL, maxW)];
        int ans = 0;
        for (int i = minL; i <= maxL; i++) {
            for (int j = minW; j <= maxW; j++) {
                ans += noc(i, j);
            }
        }
        System.out.println(ans);
    }

    static int noc(int l, int b) {
        if (dp[l - 1][b - 1] != 0) return dp[l - 1][b - 1];
        if (b > l) return noc(b, l);
        if (l == b) {
            dp[l - 1][b - 1] = 1;
            return 1;
        }
        if (l == 1 || b == 1) {
            dp[l - 1][b - 1] = dp[b - 1][l - 1] = l * b;
            return l * b;
        }
        dp[l - 1][b - 1] = dp[b - 1][l - 1] = 1 + noc(l - b, b);
        return dp[l - 1][b - 1];
    }
}
