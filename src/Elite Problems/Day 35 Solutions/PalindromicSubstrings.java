/*

You have given a task,
to count number of substrings which are pallindromes from a given String.

Example 1:
    Input= abc
    Output= 3
    Explanation= Three substrings are pallindrome: "a", "b", "c".
 

Example 2:
    Input= aaa
    Output= 6
    Explanation= Six substrings are pallindrome: "a", "a", "a", "aa", "aa", "aaa".

=====TestCases========
case =1
input =redivider
output =13

case =2
input =tattarattat
output =22

case =3
input =aaaaaa
output =21

case =4
input =ababbbbaba
output =23

case =5
input =abcdefghijklmnopqrstuvwxyz
output =26

case =6
input =ababababaxyzyxxxyx
output =41

*/

import java.util.Scanner;

public class PalindromicSubstrings {

    static int count = 0;
    
    public static int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private static void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
    
    public static void main(String args[] ) {
		 Scanner sc = new Scanner(System.in);
			String str=sc.next();

		    System.out.println(countSubstrings(str));
	}
}