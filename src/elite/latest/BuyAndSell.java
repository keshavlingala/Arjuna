package elite.latest;

import java.util.Arrays;
import java.util.Scanner;

public class BuyAndSell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int m = nums[0];
        left[0] = m;
        for (int i = 1; i < left.length; i++) {
            if (nums[i] < m)
                m = nums[i];
            left[i] = m;
        }
        m = nums[nums.length - 1];
        for (int i = right.length - 1; i >= 0; i--) {
            if (nums[i] > m)
                m = nums[i];
            right[i] = m;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, right[i] - left[i]);
        }
        System.out.println(ans);
    }
}
