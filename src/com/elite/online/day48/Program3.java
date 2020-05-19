package com.elite.online.day48;

import java.util.Scanner;

import static java.lang.System.in;

public class Program3 {
    static String coeff(String x) {
        if (x.length() > 1) {
            char c = x.charAt(x.length() - 2);
            if (c >= '0' && c <= '9')
                return x.replace("x", "");
        }
        return x.replace("x", "1");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        String equation = scanner.nextLine().trim();
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        String ans = "";
        for (String x : lr[0].split("(?=\\+)|(?=-)"))
            if (x.contains("x"))
                lhs += Integer.parseInt(coeff(x));
            else
                rhs -= Integer.parseInt(x);

        for (String x : lr[1].split("(?=\\+)|(?=-)"))
            if (x.contains("x"))
                lhs -= Integer.parseInt(coeff(x));
            else
                rhs += Integer.parseInt(x);

        if (lhs == 0)
            if (rhs == 0)
                ans = "Infinite solutions";
            else
                ans = "No solution";
        else
            ans = "x=" + rhs / lhs;
        System.out.println(ans);
    }
}
