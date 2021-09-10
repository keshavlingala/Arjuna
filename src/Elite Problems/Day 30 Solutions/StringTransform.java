/*
 * 
 Given two strings A and B of the same length, determine whether you can transform A into B by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in A to any other lowercase English character.

Return true if and only if you can transform A into B.

 
Time Complexity should be O(N) 


Input: aabcc
ccdee
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.

Example 2:

Input:google
amazon
Output: false
Explanation: There is no way to transform A to B.


Note:

1 <= A.length == B.length <= 10^4
Both A and B contain only lowercase English letters.




========================================

Explanation
Scan s1 and s2 at the same time,
record the transform mapping into a map/array.
The same char should transform to the same char.
Otherwise we can directly return false.

To realise the transformation:

transformation of link link ,like a -> b -> c:
we do the transformation from end to begin, that is b->c then a->b

transformation of cycle, like a -> b -> c -> a:
in this case we need a tmp
c->tmp, b->c a->b and tmp->a
Same as the process of swap two variable.

In both case, there should at least one character that is unused,
to use it as the tmp for transformation.
So we need to return if the size of set of unused characters < 26.


Complexity
Time O(N) for scanning input
Space O(26) to record the mapping
running time can be improved if count available character during the scan.




 */

package Elite2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringTransform {

	public static boolean canConvert(String s1, String s2) {
        if (s1.equals(s2)) return true;
        Map<Character, Character> dp = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            if (dp.getOrDefault(s1.charAt(i), s2.charAt(i)) != s2.charAt(i))
                return false;
            dp.put(s1.charAt(i), s2.charAt(i));
        }
        return new HashSet<Character>(dp.values()).size() < 26;
    }
	
	   public static void main(String args[] ) throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str1 = br.readLine();
			String str2 = br.readLine();

			
			System.out.println(canConvert(str1,str2));   
			
			}
	   
}
