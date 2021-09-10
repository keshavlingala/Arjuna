/*
 * 
Given a string s. Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. 
(Trailing spaces are not allowed).

Each word would be put on only one column and that in one column there will be only one word.

Example 1:
	Input: s = HOW ARE YOU
	Output:= [HAY, ORO, WEU]
	Explanation: Each word is printed vertically. 
	 "HAY"
	 "ORO"
	 "WEU"

Example 2:
	Input: s =TO BE OR NOT TO BE
	Output = [TBONTB, OEROOE,    T]
	Explanation: Trailing spaces is not allowed. 
	"TBONTB"
	"OEROOE"
	"   T"

Example 3:
	Input: s = CONTEST IS COMING
	Output= [CIC, OSO, N M, T I, E N, S G, T]

====================================

Find the size of the longest word;
Iterate chars of all words at index 0, 1, ..., max - 1, pack with space if the index if out of the range of current word;
Remove the trailing space for each string.

-------TestCases--------
case =1
input =kmit ngit ksjc kmes
output ="knkk,mgsm,iije,ttcs,"

case =2
input =Hello I am Who Are you Waiting
output ="HIaWAyW,e mhroa,l  oeui,l     t,o     i,      n,      g,"

case =3
input =RAMMOHAN NAGIREDDY NEILGOGTE SRIKANTH
output ="RNNS,AAER,MGII,MILK,ORGA,HEON,ADGT,NDTH, YE"

case =4
input =ACTIVATE WINDOWS IN VRITUAL BOX IN MAC OS
output ="AWIVBIMO,CINRONAS,TN IX C,ID T,VO U,AW A,TS L,E"

case =5
input =A B C D E
output ="ABCDE"

case =6
input =A BC DEF GHIJ KLMNO PQRSTU VWXYZ
output ="ABDGKPV, CEHLQW,  FIMRX,   JNSY,    OTZ,     U"

 */

import java.util.*;

public class PrintWordsVertically {
	
	 public static List<String> printVertically(String s) {
	        String[] words = s.split(" ");
	        int mx = 0;
	        for (int i = 0; i < words.length; ++i)
	            mx = Math.max(mx, words[i].length());
	        List<String> ans = new ArrayList<>();
	        for (int i = 0; i < mx; ++i) {
	            StringBuilder sb = new StringBuilder();
	            for (String word : words)
	                sb.append(i < word.length() ? word.charAt(i) : " ");
	            while (sb.charAt(sb.length() - 1) == ' ')
	                sb.deleteCharAt(sb.length() - 1); // remove trailing space.
	            ans.add(sb.toString());
	        }
	        return ans;
	    }
	 
	 public static void main(String args[] ) {
		 Scanner sc = new Scanner(System.in);
			String str=sc.nextLine();
		    System.out.println(printVertically(str));
	}

}
