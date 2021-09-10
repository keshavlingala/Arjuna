/*
 * 
 Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).

Example 1:
Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:
Input: [4,2,1]
Output: False
Explanation: You can't get a non-decreasing array by modify at most one element.
Note: The n belongs to [1, 10,000].

========TestCases==========
case =1
input =6 1 2 3 4 5 7
output =true

case =2
input =34 52 87 78 91 92 96 99
output =true 

case =1
input =2 3 4 5 6 7 18 9 10 11
output =true 

case =1
input =6 1 2 3 4 7 5
output =false 

case =1
input =34 52 43 87 78 91 92 96 99
output =false 

case =1
input =41 42 43 44 47 45 46 49 48
output =false 


 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NonDecreasingArray {

	public static boolean checkPossibility(int[] nums) {
        int cnt = 0;                                                                    //the number of changes
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];                    //modify nums[i-1] of a priority
                else nums[i] = nums[i-1];                                                //have to modify nums[i]
            }
        }
        return cnt<=1; 
    }
	
	 public static void main(String args[] ) throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = br.readLine();
			String[] numbers = str.split(" ");
			int[] arr = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
			System.out.println(checkPossibility(arr));
			}
}
