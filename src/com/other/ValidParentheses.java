package com.other;/*
 * 
 * 
  
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true

 */
import java.util.*;
public class ValidParentheses {

	HashMap<Character, Character> map = new HashMap<>();
	 public ValidParentheses() {
	     map.put(')', '(');
	     map.put('}', '{');
	     map.put(']', '[');
	  }

  public boolean isValid(String s) {
	    Stack<Character> stack = new Stack<Character>();
	  
		for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);

	      // If the current character is a closing bracket.
	      if (map.containsKey(c)) {
	                char top = stack.empty() ? '#' : stack.pop();
	        // if top doesn't match the stack's top element, return false.
	        if (top != map.get(c)) 
	          return false;
	        }
			else {
	        // If it was an opening bracket, push to the stack.
	        stack.push(c);
	      }
	    }

	    // If the stack still contains elements, then it is an invalid expression.
	    return stack.isEmpty();
	  }
	  
	  public static void main(String args[] ) {
			 Scanner sc = new Scanner(System.in);
				String str=sc.next();
				ValidParentheses vp=new ValidParentheses();
			    System.out.println(vp.isValid(str));
		}
	  
}


