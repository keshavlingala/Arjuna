package exams;

import java.util.*;

public class FCP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] code = scanner.nextLine().split(" ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < code.length; i++) {
            char[] chars = code[i].toCharArray();
            int val = (chars[chars.length - 1] - 'A' + 1);
            for (int j = chars.length - 2; j >= 0; j--) {
                val += (chars[j] - 'A' + 1) * 26;
            }
            nums.add(val);
        }
        Collections.sort(nums, (a, b) -> {
            String ab = "" + a + "" + b;
            String ba = "" + b + "" + a;
            return ba.compareTo(ab);
        });
        System.out.println(nums);
        String ans = "";
        for (Integer num : nums) {
            ans += num;
        }
        System.out.println(ans);
    }


}
