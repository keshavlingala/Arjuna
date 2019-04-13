package com.arjuna.season18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Illuminati {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfHouses = scanner.nextInt();
        int range = scanner.nextInt();
        ArrayList<Integer> street = new ArrayList<Integer>();
        for (int i = 0; i < noOfHouses; i++) {
            street.add(scanner.nextInt());
        }
        int count = 0;


        while (!street.isEmpty()) {
//          taking the 1st house location as minimum
            int min = Collections.min(street);
//            the 1st light range can be upto the do min + range
            int max = min + range;
            int lightLocation=min;
            //           eliminating the houses who got illuminated
            for (int i = min; i <= max; i++) {
                if (street.contains(i)) {
//                    in the last iteration the min will be the last house location
//                here light is the location of  building the light placed
                    lightLocation = i;
                    street.remove(street.indexOf(i));
                }
            }
//            placing the light at the last building illuminates the buildings  upto the lightlocation + range
//            so removing all the building from list upto that location
            for (int i = lightLocation; i < lightLocation + range; i++) {
                if (street.contains(i)) {
                    street.remove((street.indexOf(i)));
                }
            }
            count++;
//            job with 1st lamp placement is completed
//            now all the memory in the registry will be erased and start min,max,lightlocation etc makes the program efficient
//            now next job is done considering only non-illuminated locations reduces the time complexity
        }
        System.out.println(count);
    }
}