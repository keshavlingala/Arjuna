/*
 * 
Given two strings A and B, check if A is subsequence of B.

B is a very long string, and A is a short string 

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "def" is a subsequence of "adheazgbf" while "zab" is not).

Example 1:

input:
def
adheazgbf

output:
true

Example 2:

input:
zab
adheazgbf

output:
false
===========================================

public int indexOf(char ch, int strt)

Parameters:
ch :a character.
strt : the index to start the search from.


case=1
input=ramraj
shivramaraju
output=true

case=2
input=akhil
arkahmiul
output=true

case=3
input=reddy
raaaaebbdbbdxzy
output=true

case=4
input=reddy
eaaaarbbdbbdxzy
output=false

case=5
input=mohan
nahom
output=false

case=5
input=nagi
nrghahiygjj
output=false

 */



import java.util.Scanner;

public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }
	
	  public static void main(String args[] ) {
			 Scanner sc = new Scanner(System.in);
				String s=sc.next();
				String t=sc.next();
			    System.out.println(isSubsequence(s,t));
		}
	
}
