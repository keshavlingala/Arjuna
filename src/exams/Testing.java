package exams;

import java.util.Arrays;
import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int x = scanner.nextInt();
        int ans = 0;
        for (int i : nums)
            if (x == i)
                ans++;
        System.out.println(ans);
    }
}

