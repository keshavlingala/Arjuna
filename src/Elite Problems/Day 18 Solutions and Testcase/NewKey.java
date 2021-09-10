/*
You are given a key represented as a string S which consists only alphanumeric 
character and dashes. The string is separated into N+1 groups by N dashes.

Given a number K, we want you to reformat the strings such that, 
each group contains exactly K characters, except for the first group 
which could be shorter than K, but still must contain at least one character.
Furthermore, there must be a dash inserted between two groups 
and all lowercase letters should be converted to uppercase.

Given a non-empty string S and a number K, 
format the string according to the rules described above.

Example 1:
	Input: S = "5F3Z-2e-9-w", K = 4
	Output= "5F3Z-2E9W"
	Explanation: The string S has been split into two parts, each part has 4 characters.	
	Note that the two extra dashes are not needed and can be removed.

Example 2:
	Input: S = "2-5g-3-J", K = 2
	Output= "2-5G-3J"
	Explanation: The string S has been split into three parts, each part has 2 characters 
	except the first part as it could be shorter as mentioned above.

-------Test Cases-------

case =1
input =a-b-c-d-e-f-g-h-j-i-k-l
4
output =ABCD-EFGH-JIKL

case =2
input =maskj-fjkewgiu-njk-fkjlju-klJFEF-MKLJF-KWEJF2-4U89-LJFOE
9
output =MAS-KJFJKEWGI-UNJKFKJLJ-UKLJFEFMK-LJFKWEJF2-4U89LJFOE

case =3
input =AB-C-DEF-gh-jKl-2476hfgr-t
5
output =ABCDE-FGHJK-L2476-HFGRT

case =4
input =AB-C-DEF-gh-jKl-2476hfgr-t
6
output =AB-CDEFGH-JKL247-6HFGRT

case =5
input =keshav-memo-rial-insti-tuteofTec-hnology
6
output =KESHA-VMEMOR-IALINS-TITUTE-OFTECH-NOLOGY

case =6
input =this-is--very---special-string
4
output =THI-SISV-ERYS-PECI-ALST-RING

 */

import java.util.Arrays;
import java.util.Scanner;

public class NewKey {
	public static String newKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            if (s.charAt(i) != '-')
                sb.append(sb.length() % (k + 1) == k ? '-' : "").append(s.charAt(i));
        return sb.reverse().toString().toUpperCase();
    } 
	
	 public static void main(String args[] ) {
		 Scanner sc = new Scanner(System.in);
			String str=sc.next();
			int k=sc.nextInt();

		    System.out.println(newKeyFormatting(str,k));
	}
}
