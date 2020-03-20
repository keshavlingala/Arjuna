package com.elite.latest;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int c = 0;
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            int lp = i, rp = i;
            while (lp >= 0 && rp < string.length() && string.charAt(lp) == string.charAt(rp)) {
                ans.add(string.substring(lp, rp + 1));
                lp--;
                rp++;
                c++;
            }
        }
        for (int i = 0; i < string.length() - 1; i++) {
            int lp = i, rp = i + 1;
            if (string.charAt(lp) == string.charAt(rp))
                while (lp >= 0 && rp < string.length() && string.charAt(lp) == string.charAt(rp)) {
                    ans.add(string.substring(lp, rp + 1));
                    lp--;
                    rp++;
                    c++;
                }
        }
        System.out.println(ans);
        System.out.println(c);
    }
}
/*case =1
    2 input =redivider
    3 output =13
    4
    5 case =2
    6 input =tattarattat
    7 output =22
    8
    9 case =3
   10 input =aaaaaa
   11 output =21
   12
   13 case =4
   14 input =ababbbbaba
   15 output =23
   16
   17 case =5
   18 input =abcdefghijklmnopqrstuvwxyz
   19 output =26
   20
   21 case =6
   22 input =ababababaxyzyxxxyx
   23 output =41*/