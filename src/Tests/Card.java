package Tests;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Card{
    public static boolean find(String s, String first) {
        if(s == null)
            return true;
        if(s.length() == 0)
            return true;
        String next = Long.toString(Long.parseLong(first) + 1);
        if(s.startsWith(next))
            return find(s.substring(next.length()), next);
        return false;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.next();
        boolean flag = false;
        for(int i=1;i<=s.length()/2;i++){
            String first = s.substring(0, i);
            if(find(s.substring(i), first)){
                flag = true;
                System.out.println("YES " + first);
                break;
            }
        }
        if(!flag)
            System.out.println("NO");
    }
}