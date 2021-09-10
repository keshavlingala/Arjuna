/*
Given a string and a string dictionary, 
find the longest string in the dictionary that can be formed by deleting 
some characters of the given string. 

If there are more than one possible results, 
return the longest word with the smallest lexicographical order. 
If there is no possible result, return -1.

Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.

Sample Input:
abpcplea
ale apple monkey plea

Sample Output: 
apple
Example: 
Sample Input:
abpcplea
a b c

Sample Output: 
a

---------TestCases----------
case =1
input =applellkmitngit
app apple appleit applet
output =appleit

case =2
input =keshavmemorialinstitute 
kiran gopal kishore
output =-1

case =3
input =additionalaudition
addl audition addition 
output =addition

case =4
input =mentcandalloionedatewed
allowed mentioned candidate
output =candidate

case =5
input =attendroomperexammitinatappropriationanc
attendance appropriate examination permitted room
output =examination

case =6
input =prorespowrinsitebvideviedlroughd
rough write responsible provided
output =provided


*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LongestWordthroughDeleting {

	public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    public static String findLongestWord(String s, List < String > d) {
        Collections.sort(d, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String str: d) {
            if (isSubsequence(str, s))
                return str;
        }
        return "-1";
    }
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String dictionaryStr = br.readLine();
		String[] dictWords = dictionaryStr.split(" ");
	        List<String> words = Arrays.asList(dictWords);  

		System.out.println(findLongestWord(str,words));

	}
	
}