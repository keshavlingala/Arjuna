/*
* 
Given a string s, return the maximum number of ocurrences of any substring under the following rules:

The number of unique characters in the substring must be less than or equal to maxLetters.
The substring size must be between minSize and maxSize inclusive.
 

Example 1:
	Input= aababcaab	//given string
			2			//Maximun Letters
			3			//Minimum Size
			4			//Maximum Size
	Output= 2
	Explanation: Substring "aab" has 2 ocurrences in the original string.
	It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).

Example 2:
	Input= aaaa
			1
			3
			3
	Output= 2
	Explanation: Substring "aaa" occur 2 times in the string. It can overlap.

Example 3:
	Input= aabcabcab
			2
			2
			3
	Output= 3

Example 4:
	Input= abcde
			2
			3
			3
	Output= 0

-------Test Cases---------
case =1
input =abaaabababababbbababababa
2
2
4
output =10

case =2
input =kshkjysjhsjkhsjkyskjshkjsyshkhskjyksksyksyshkjsy
3
3
6
output =4

case =3
input =qwertyqwertyqwerqwertyqwertyuiqwertyqwerwertyuwertyuiqwerty
6
5
8
output =8

case =4
input =kmitkmtkmitmkitkitkmitkmitngitngigitititkitmitnit
2
2
4
output =13

case =5
input =qwertywertyertyrtytyy
2
6
7
output =0

case =6
input =aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
1
3
6
output =31

 */
import java.util.HashMap;
import java.util.Scanner;

public class MaxOccurrenceSubstring {

    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        int n = s.length(), resCnt = 0;
        if(minSize > n) return 0;
        for(int i = 0; i < n; i++){            
            Map<Character, Integer> map = new HashMap<>();
            for(int distNum = 0, j = 0; j < maxSize; j++){
                if(i + j >= n) break;
                map.put(s.charAt(i + j), map.getOrDefault(s.charAt(i + j), 0) + 1);
                if(map.get(s.charAt(i + j)) == 1) distNum++;
                if(distNum > maxLetters) break;
                if(j >= minSize - 1)
                    res.put(s.substring(i, i + j + 1), res.getOrDefault(s.substring(i, i + j + 1), 0) + 1);       
            }
        }
        for(String str: res.keySet()){            
            if(res.get(str) > resCnt)
                resCnt = res.get(str);
        }
        return resCnt;        
    }

  public static void main(String args[] ) {
		 Scanner sc = new Scanner(System.in);
			String str=sc.next();
			int maxletters=sc.nextInt();
			int minsize=sc.nextInt();
			int maxsize=sc.nextInt();
		    System.out.println(maxFreq(str,maxletters,minsize,maxsize));
	}
}
