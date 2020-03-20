package com.elite.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ternary {
    static char method(String exp) {
        if (exp.length() <= 1) {
            return exp.charAt(0);
        }
        int start = 0;
        int end = 0;
        boolean boo = false;
        while (exp.charAt(start) != '?') {
            if (exp.charAt(start) == 'F') {
                boo = false;
            } else if (exp.charAt(start) == 'T') {
                boo = true;
            }
            start++;
        }
        int c = 0;
        end = start;
        while (exp.charAt(end) != ':' || c!=0) {
            if (exp.charAt(end) == '?')
                c++;
            if(exp.charAt(end)==':')
                c--;
            if(exp.charAt(end)==':' && c==0)
                break;
            end++;
        }
        return method(boo ? exp.substring(start + 1, end) : exp.substring(end + 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(method(scanner.next()));
    }
}
