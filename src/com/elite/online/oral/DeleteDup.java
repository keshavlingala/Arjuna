package com.elite.online.oral;

import java.util.Scanner;
import java.util.Stack;

public class DeleteDup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine().trim();
        Stack<Character> ans = new Stack<>();
        for (int i = string.length() - 1; i >= 0; i--) {
            if (ans.isEmpty()) {
                ans.push(string.charAt(i));
            } else {
                if (ans.peek() == string.charAt(i)) {
                    ans.pop();
                } else {
                    ans.push(string.charAt(i));
                }
            }
        }
        if (ans.isEmpty())
            System.out.println(-1);
        else {
            StringBuilder result = new StringBuilder();
            for (Character c : ans) {
                result.insert(0, c);
            }
            System.out.println(result);
        }
    }
}
