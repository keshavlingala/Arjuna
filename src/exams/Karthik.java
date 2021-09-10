package exams;

import java.util.Arrays;

class UserMainCode
{
    public int minPenalty(int input1, int[] input2) {
        // Read only region end
        // Write code here...
        Arrays.sort(input2);
        System.out.println(Arrays.toString(input2));
        int ans = 0;
        for (int i = 0; i < input1 - 1; i++)
            ans += Math.abs(input2[i] - input2[i + 1]);
        return ans;
    }
}
