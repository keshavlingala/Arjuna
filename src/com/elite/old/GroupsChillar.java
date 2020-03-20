package com.elite.old;

import java.util.Scanner;

public class GroupsChillar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = sc.nextInt();
        line = line.replaceAll("-", "").toUpperCase();
        String ans = "";
        for (int i = line.length(); i > 0; i -= n) {
            if (i - n > 0)
                ans = "-" + line.substring(i - n, i) + ans;
            else
                ans = "-" + line.substring(0, i) + ans;
        }
        System.out.println(ans.substring(1));
    }
}
