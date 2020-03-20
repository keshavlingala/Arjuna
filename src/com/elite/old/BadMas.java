package com.elite.old;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BadMas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.nextLine();
        List<Integer> fin = rec(exp);
        fin.sort(Integer::compareTo);
        System.out.println(fin);
    }

    static List<Integer> rec(String exp) {
        if (exp.isEmpty())
            return new ArrayList<>();
        if (exp.length() == 1)
            return Collections.singletonList(Integer.parseInt(exp));
        List<Integer> fans = new ArrayList<>();
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                for (int i1 : rec(exp.substring(0, i))) {
                    for (int i2 : rec(exp.substring(i + 1))) {
                        switch (exp.charAt(i)) {
                            case '*':
                                fans.add(i1 * i2);
                                break;
                            case '+':
                                fans.add(i1 + i2);
                                break;
                            case '-':
                                fans.add(i1 - i2);
                                break;
                        }
                    }
                }
            }
        }
        return fans;
    }
}
