package com.arjuna.season23;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardsGame {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> andrea = IntStream.range(0, scanner.nextInt())
                .mapToObj(i -> scanner.nextInt())
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> maria = IntStream.range(0, scanner.nextInt())
                .mapToObj(i -> scanner.nextInt())
                .collect(Collectors.toCollection(ArrayList::new));
        String call = scanner.next();
        int andreaScore = 0, mariaScore = 0;
        while (true) {
            if (call.equals("Even")) {
                andreaScore += andrea.get(0) - maria.get(0);
                mariaScore += maria.get(0) - andrea.get(0);
                if (maria.isEmpty()) break;
                if (andrea.isEmpty()) break;
                andrea.remove(0);
                maria.remove(0);
                call = "Odd";
            }
            if (call.equals("Odd")) {
                if (maria.isEmpty()) break;
                if (andrea.isEmpty()) break;
                andrea.remove(0);
                maria.remove(0);
                call = "Even";
            }
        }
        if(mariaScore==andreaScore){
            System.out.println("Tie");
        }else{
            System.out.println(andreaScore>mariaScore?"Andrea":"Maria");
        }

    }
}
