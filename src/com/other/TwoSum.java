/*
 * 
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

Example 2:

Given nums = [2, 7, 11, 15], target = 25,

No possible two indices sum in the array will give 25
so return -1.



 */

package com.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TwoSum {

	public static String twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int ele = target - nums[i];
	        if (map.containsKey(ele)) {
	        	return map.get(ele)+" "+i; //Given nums = [2, 7, 11, 15], target = 9,
	        }
	        map.put(nums[i], i);
	    }
    	return "-1";
	}
	
	 public static void main(String[] args) throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray(); 		
	    	int target = Integer.parseInt(br.readLine());//(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray(); 		
	    	System.out.println(twoSum(nums,target)); 
	    
	    } 

	
}
