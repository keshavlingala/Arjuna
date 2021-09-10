/*
Given a string, we can shift each of its letter to its successive/predecessive letter, 
for example: "abc" -> "bcd" or  "bcd" -> "abc". We can keep shifting the letters to form the sequence:
"abc" -> "bcd" -> ... -> "xyz"	or	 "mno"->"bcd"->"abc"->....->"xyz"

Given a list of strings which contains english alphabets, 
group all strings that belong to the same shifting sequence.

Example-1:
	Input: abc bcd acef xyz az ba A Z
	Output: [[abc, bcd, xyz], [acef], [az, ba], [A, Z]]

Example-2:
	Input: yurp qmjh gdba jfca
	Output:[[jfca, qmjh, yurp], [gdba]]

Example-3:
	Input: AcF bD UwZ sU MoR
	Output: [[AcF, MoR, UwZ], [bD, sU]]
Note: Output should be as foloows, Groups should be formed as per input order
each group should be a sorted group.

-----------TestCases---------
case =1
input =acf dca jkl gil tvy mor gfd pqr hge
output ='[[acf, gil, mor, tvy], [dca, gfd, hge], [jkl, pqr]]'

case =2
input =Ace Kmo abC lmN Prt Gik aB eF PqR gH kL opQ AbC DeF
output ='[[Ace, Gik, Kmo, Prt], [abC, lmN, opQ], [aB, eF, gH, kL], [AbC, DeF, PqR]]'

case =3
input =cab pot rpq igh vuz jin zxy
output ='[[cab, igh, rpq, zxy], [jin, pot, vuz]]'

case =4
input =jfca qmjh gdba yurp
output ='[[jfca, qmjh, yurp], [gdba]]'

case =5
input =AcF EgJ bD UwZ eG sU MoR nP
output ='[[AcF, EgJ, MoR, UwZ], [bD, eG, nP, sU]]'

case =6
input =cab Kmo igh gfd hge Prt rpq zxy Ace Gik
output ='[[cab, igh, rpq, zxy], [Ace, Gik, Kmo, Prt], [gfd, hge]]'

*/

import java.util.*;

public class GroupShiftedStrings {
	    public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> result = new ArrayList<List<String>>();
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		for (String str : strings) {
		    int offset = str.charAt(0) - 'a';
		    String key = "";
		    for (int i = 0; i < str.length(); i++) {
			char c = (char) (str.charAt(i) - offset);
			if (c < 'a') {
			    c += 26;
			}
			key += c;
		    }
		    if (!map.containsKey(key)) {
			List<String> list = new ArrayList<String>();
			map.put(key, list);
		    }
		    map.get(key).add(str);
		}
		for (String key : map.keySet()) {
		    List<String> list = map.get(key);
		    Collections.sort(list);
		    result.add(list);
		}
		//Collections.sort(result);
		return result;
	    }

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String[] words=s.split(" ");
		System.out.println(groupStrings(words));
	}
}