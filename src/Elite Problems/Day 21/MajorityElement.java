/*
Given an array of size n, find the majority element. 
The majority element is the element that appears more than [ n/2 ] times.

You may assume that the array is non-empty 
and the majority element always exist in the array.

Example 1:
	Input: 3 2 3
	Output: 3

Example 2:
	Input: 2 2 1 1 1 2 2
	Output: 2
NOTE: if there are two such elements exist print the first one.

------TestCases-------
case =1
input =1 2 3 4 3 2 2 2 1 2 2
output =2

case =2
input =9 1 9 2 9 3 9 4 9 5 9 6 9 7 9 8 9
output =9

case =3
input =11 12 13 14 11 12 12 12 13 13 13 12 12 11 12 12 12
output =12

case =4
input =10 10 2 3 10 10 4 10 10 10 4
output =10

case =5
input =1 1 1 1 1 6 6 6 6 6 6
output =6

case =6
input =1 2 3 4 5 5 5 5 6 5 57 5
output =5

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
    public static void main(String args[] ) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] numberline = str.split(" ");
		int[] nums = Arrays.asList(numberline).stream().mapToInt(Integer::parseInt).toArray();
		System.out.println(majorityElement(nums));   
	}
}