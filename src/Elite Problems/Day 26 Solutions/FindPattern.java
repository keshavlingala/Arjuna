/*
 * 
Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak 
such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers 
as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: 1 2 3 4

Output: False

Explanation: There is no  pattern in the sequence.
Example 2:
Input: 3 1 4 2

Output: True

Explanation: There is a pattern in the sequence: [1, 4, 2].
Example 3:
Input: -1 3 2 0

Output: True

Explanation: There are three patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].

 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindPattern {

	public static boolean findpattern(int[] nums) {
        int min_i = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length - 1; j++) {
            min_i = Math.min(min_i, nums[j]);
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[k] < nums[j] && min_i < nums[k])
                    return true;
            }
        }
        return false;
    }
	
	 public static void main(String args[] ) throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			String[] numberline = str.split(" ");
			int[] nums = Arrays.asList(numberline).stream().mapToInt(Integer::parseInt).toArray();

			System.out.println(findpattern(nums));   
			
			}
}
