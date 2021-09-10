package com.arjuna.season19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PerfectTen {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int col = scanner.nextInt();
        int row = scanner.nextInt();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < row; i++)
            arrayList.add(scanner.next());
        ArrayList<Integer> counts = new ArrayList<Integer>();
        int count = 0;
        for (String s : arrayList) {
            if (s.substring(0,col).contains("M") || s.substring(0,col).contains("m")) {
                count = 0;
            } else {
                count += 1;
                counts.add(count);
            }
        }
        System.out.println(Collections.max(counts));
    }
}


