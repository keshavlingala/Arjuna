package com.elite.old;

import java.util.Arrays;
import java.util.Scanner;

/*Example 1:
        Input:3
        test.email+venkaty@kmit.com
        test.e.mail+venkat.sai@kmit.com
        testemail+gopi@kmit.eng.com

Output: 2
        Explanation: "testemail@kmit.com" and "testemail@kmit.eng.com" actually receive mails*/
public class EmailParser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        String[] parts = line.split("@");
        parts[0] = parts[0].split("/+")[0].replaceAll("", "");
        System.out.println(Arrays.toString(parts));
    }
}
