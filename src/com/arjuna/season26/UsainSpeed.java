package com.arjuna.season26;

import java.util.*;

public class UsainSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfDays = scanner.nextInt();
        int speeds = scanner.nextInt();
//         I don't know why this value is given
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < noOfDays; i++) {
            int key = scanner.nextInt();
            int value = scanner.nextInt();
            hashMap.merge(key, value, (v1, v2) -> v1 > v2 ? v1 : v2);
            // hash merge takes and puts value if value associated
            // to the key already then the BiFunction returns the max of the both values
        }
//        creating a list of all the values in the HashMap
        List<Integer> sortedValues = new ArrayList<>(hashMap.values());
        sortedValues.sort(Collections.reverseOrder());
//        Sorting a list in descending order and printing the sum of top 2
        System.out.println(sortedValues.get(0) + sortedValues.get(1));
    }
}
