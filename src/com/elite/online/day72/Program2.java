package com.elite.online.day72;

import java.util.Scanner;

public class Program2 {
    static boolean win = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stick = scanner.nextLine().replaceAll(" ", "-").trim();
        rec(stick, 0, 0, true);
        System.out.println(win);
    }

    static void rec(String stick, int p1, int p2, boolean p1choice) {
        if (stick.isEmpty()) {
            if (p1 > p2)
                win = true;
            return;
        }
        int start = stick.indexOf("-");
        int end = stick.lastIndexOf("-");
        if (p1choice) {
            rec(stick.substring(1), p1 + Integer.parseInt(stick.charAt(0) + ""), p2, false);
            rec(stick.substring(stick.length() - 1), p1 + Integer.parseInt(stick.charAt(stick.length() - 1) + ""), p2, false);
        } else {
            rec(stick.substring(1), p1, p2 + Integer.parseInt(stick.charAt(0) + ""), true);
            rec(stick.substring(stick.length() - 1), p1, p2 + Integer.parseInt(stick.charAt(stick.length() - 1) + ""), true);
        }

    }
}

/*
answer java lo rale python lo chesina po
# -*- coding: utf-8 -*-
        """
Created on Tue May  5 19:54:02 2020

@author: keshav
"""

lines=tuple(map(int,input().split()))
ans=False
def rec(stick,p1,p2,p1choice):
    global ans
    if len(stick)<=0:
        if p1>p2:
            ans=True
        return
    if(p1choice):
        rec(stick[1:],p1+stick[0],p2,False)
        rec(stick[:-1],p1+stick[-1],p2,False)
    else:
        if stick[0]>=stick[-1]:
            rec(stick[1:],p1,p2+stick[0],True)
        else:
            rec(stick[:-1],p1,p2+stick[-1],True)

rec(lines,0,0,True)
print('true' if ans else 'false')
*/
