package com.codevita;

import java.util.Scanner;

public class NumberSortSpell {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        boolean result = false;
        while (a < 99999 || b < 99999) {
            if (a == b) {
                result = true;
                break;
            }
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if (convert(a).compareTo(convert(b)) > 0) {
                a = b = a + b;
                result = true;
                break;
            } else {
                a = a + a;
                b = b + b;
            }
        }
        System.out.print(result ? a : "Out of bounds");
    }


    public static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    public static final String[] tens = {
            "",        // 0
            "",        // 1
            "Twenty",  // 2
            "Thirty",  // 3
            "Forty",   // 4
            "Fifty",   // 5
            "Sixty",   // 6
            "Seventy", // 7
            "Eighty",  // 8
            "Ninety"   // 9
    };

    public static String convert(final int n) {
        if (n < 0) {
            return "Minus " + convert(-n);
        }

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }

        if (n < 1000000) {
            return convert(n / 1000) + " Thousand" + ((n % 1000 != 0) ? " " : "") + convert(n % 1000);
        }

        if (n < 1000000000) {
            return convert(n / 1000000) + " Million" + ((n % 1000000 != 0) ? " " : "") + convert(n % 1000000);
        }

        return convert(n / 1000000000) + " Billion" + ((n % 1000000000 != 0) ? " " : "") + convert(n % 1000000000);
    }


}

