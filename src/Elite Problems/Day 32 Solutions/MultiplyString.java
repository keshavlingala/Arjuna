/*
Hemanth is playing with Strings, He got an idea to multiply two strings contains [0-9] only.
Please help him to find out the result of multiplication of two strings.

Example 1:
	Input=	5 4
	Output= 20

Example 2:
	Input=	121 432 
	Output= 52272

Note:
Input should contain digits only, and shouldnot contain leading 0's except 0.
There will be no leading minus '-' symbol also/
Should not use built-in BigInteger library.
Should not convert the given strings into integers.

==========TestCases===========

case =1
input =123 45
output ="5535"

case =2
input =345 0
output ="0"

case =3
input =1000 234
output ="234000"

case =4
input =1564 9841
output ="15391324"

case =5
input =68761 452
output ="31079972"

case =6
input =11111 11111
output ="123454321"

*/

import java.util.*;

class MultiplyString{
public static String multiply(String num1, String num2) {
    int m = num1.length(), n = num2.length();
    int[] pos = new int[m + n];
   
    for(int i = m - 1; i >= 0; i--) {
        for(int j = n - 1; j >= 0; j--) {
            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
            int p1 = i + j, p2 = i + j + 1;
            int sum = mul + pos[p2];

            pos[p1] += sum / 10;
            pos[p2] = (sum) % 10;
        }
    }  
    
    StringBuilder sb = new StringBuilder();
    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
    return sb.length() == 0 ? "0" : sb.toString();
}
public static void main(String args[])
{
	Scanner sc=new Scanner(System.in);
	String[] S=sc.nextLine().split(" ");
	System.out.println(multiply(S[0],S[1]));	
}
}