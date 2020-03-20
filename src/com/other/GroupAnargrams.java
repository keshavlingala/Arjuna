package com.other;/*
 * 
 
 Given an array of strings, group anagrams together.

Example:

Input:eat tea tan ate nat bat
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GroupAnargrams {

	 public static List<List<String>> groupAnagrams(String[] strs) {
	        if (strs.length == 0) return new ArrayList();
	        Map<String, List> ans = new HashMap<String, List>();
	        for (String s : strs) {
	            char[] ca = s.toCharArray();
	            Arrays.sort(ca);
	            String key = String.valueOf(ca);
	            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
	            ans.get(key).add(s);
	        }
	        return new ArrayList(ans.values());
	    }
	 
	 public static void main(String args[] ) throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = br.readLine();
			String[] list = str.split(" ");
			System.out.println(groupAnagrams(list));
	 } 
}
