/*
 * 
 Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input:11
1
Output: 100

Example 2:

Input:1010
1011
Output:10101


case =1
input =1010101
101010
output ="1111111"

case =2
input =111111111
1010101110
output ="10010101101"

case =3
input =00101
101
output ="01010"

case =4
input =0000101110
000101111
output ="0001011101"

case =5
input =101011101011010111
1010111101010011
output ="110110101000101010"

case =6
input =00001010111011
000001010100
output ="00001100001111"



 */

package Elite2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddBinary {

	
	 public static String addBinary(String a, String b) {
	        StringBuilder sb = new StringBuilder();
	        int i = a.length() - 1, j = b.length() -1, carry = 0;
	        while (i >= 0 || j >= 0) {
	            int sum = carry;
	            if (j >= 0) sum += b.charAt(j--) - '0';
	            if (i >= 0) sum += a.charAt(i--) - '0';
	            sb.append(sum % 2);
	            carry = sum / 2;
	        }
	        if (carry != 0) sb.append(carry);
	        return sb.reverse().toString();
	    }
	 
	 public static void main(String args[] ) throws IOException {

		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String a = br.readLine();
			String b = br.readLine();
			System.out.println(addBinary(a,b));   
			
			}
}
