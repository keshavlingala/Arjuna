package com.arjuna.season17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ToyBox {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
//        inputs
        int noOfBoxes = scanner.nextInt();
        ArrayList<Integer> arrangement = new ArrayList<Integer>();
        for (int i = 0; i < noOfBoxes; i++) {
            arrangement.add(scanner.nextInt());
        }
//        Taking a new sorted array to check if the arrangements array is sorted or not to reduce the number of iterations
        ArrayList<Integer> checkList = new ArrayList<>(arrangement);
        Collections.sort(checkList, Collections.reverseOrder());
        
        int rounds = 0; 
        while (true) {
            if (arrangement.equals(checkList)) break; //if array is already sorted return nothing
            for (int i = 0; i < noOfBoxes; i++) {
                //finding all possile pattern occurence of [0,1] in the arrrangements
                if (i < arrangement.size() - 1 && arrangement.get(i).equals(0) && arrangement.get(i + 1).equals(1)) {
                    // if found swap it using the collections
                    Collections.swap(arrangement, i, i + 1);
                    i++; // this is to make sure the loop not to change the same boxes again because i and i+1 are already moved
                }
            }
//            after all the moves done in one round count of rount++
            rounds++;
//            if the arrangements are sorted the next loop breaks at 22 line
        }
        System.out.println(rounds);
    }
}
