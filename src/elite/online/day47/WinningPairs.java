package com.elite.online.day47;

import java.util.Scanner;
import java.util.stream.IntStream;

public class WinningPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] numbers = IntStream.range(0, n).mapToObj(i -> scanner.next()).toArray(String[]::new);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String pair = numbers[i] + numbers[j];
                boolean valid = true;
                for (char num = '0'; num <= '9'; num++) {
                    if (!pair.contains(num + "")) {
                        valid = false;
                        break;
                    }
                }
                ans += valid ? 1 : 0;
            }
        }
        System.out.println(ans);
    }
}
