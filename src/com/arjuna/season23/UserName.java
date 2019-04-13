package com.arjuna.season23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserName {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfStrings = scanner.nextInt();
        List<String> usernames = new ArrayList<>();
        for (int i = 0; i < noOfStrings; i++) {
            String user = scanner.next();
            String generated = user;
            int k = 1;
            while (true) {
                if (usernames.contains(generated)) {
                    generated = user + k++;
                } else {
                    usernames.add(generated);
                    break;
                }
            }
        }
        for (String u : usernames) {
            System.out.println(u);
        }
    }
}
