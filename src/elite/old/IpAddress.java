package com.elite.old;

import java.util.Scanner;
import java.util.TreeSet;

public class IpAddress {
    static TreeSet<String> sets = new TreeSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        generate("", str, 0);
        System.out.println(sets);
    }

    static void generate(String ip, String str, int dots) {
        if (dots == 4 || str.isEmpty()) {
            if (str.isEmpty() && dots == 4) {
                sets.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        for (int i = 0; i < Math.min(str.length(), 3); i++) {
            if (Long.parseLong(str.substring(0, i + 1)) <= 255) {
                if (str.charAt(0) != '0')
                    generate(ip + str.substring(0, i + 1) + "", str.substring(i + 1), dots + 1);
                else if (str.charAt(0) == '0' && str.substring(0, i + 1).length() == 1) {
                    generate(ip + str.substring(0, i + 1) + "", str.substring(i + 1), dots + 1);
                }
            }
        }
    }
}
