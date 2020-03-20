package com.other;

import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        HashMap<Integer, String> hp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hp.put(scanner.nextInt(), scanner.next());
        }
        ArrayList<Integer> list = new ArrayList<Integer>(hp.keySet());
        list.sort(Collections.reverseOrder());
        System.out.println(hp.get(list.get(0)));
        System.out.println(hp.get(list.get(1)));
    }
}
