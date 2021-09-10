
import java.util.Scanner;

/*
 * 
Given a string S, remove all the consecutive duplicates. 
keep one character and remove all subsequent same characters.



Sample Input: 
rraabbccdf

Sample Output: 
rabcdf


=============================================================

case=1
input=tessellator
output=teselator

case=2
input=interstellar
output=interstelar

case=3
input=killbillkillbill
output=kilbilkilbil

case=4
input=jjjjwwjwxxxaaaebeeiii
output=jwjwxaebei

case=5
input=abcdefghabcdefgh
output=abcdefghabcdefgh

case=6
input=ililililllllllliiiiililiililil
output=ililililililililil

 * 
 */
public class RemoveConsecutiveDuplicates {

	// Recursively removes consecutive duplicates from str and returns
	// new string.
	static String removeDup(String str) {
		// If length of string is 1 or 0
		if (str.length() == 0 || str.length() == 1)
			return str;

		// Remove leftmost same characters and recur for remaining
		// string
		if (str.charAt(0) == str.charAt(1)) {
			// last_removed = str.charAt(0);
			while (str.length() > 1 && str.charAt(0) == str.charAt(1))
				str = str.substring(1, str.length());
			return removeDup(str);
		}

		// At this point, the first character is definitely different
		// from its adjacent. Ignore first character and recursively
		// remove characters from remaining string
		String rem_str = removeDup(str.substring(1, str.length()));

		// If the two first characters of str and rem_str don't match,
		// append first character of str before the first character of
		// rem_str
		return (str.charAt(0) + rem_str);
	}

	/* main program */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(removeDup(str));

	}

}
