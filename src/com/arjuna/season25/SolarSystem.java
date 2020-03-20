package com.arjuna.season25;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolarSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt) //mapping each value to parseInt of itself and
                .collect(Collectors.toList()); // collecting it all to a list and returnning
        int leftHours = scanner.nextInt();
        int minK = list.size();
        int hoursTook = 0;
        // the minimum value should be the size of the list
//         so to reduce the time complexity loop starts from the size of the list
        for (int i = minK; i < leftHours * minK; i++) {
//            math.ceil gives the just above value of the float number
//            so as for example 5/2=2.5 gives 3
            for (int number : list) {
                hoursTook += Math.ceil(number / (float) i);
            }
//            hoursTook gives the hours took to eat all the planets
//            if that is less than hours left then success we got the answer
            if (hoursTook <= leftHours) {
                System.out.println(i); //our result
                break;
            }
//            else increment i in the loop and continue until we get the answer
//            just in case for the safe code if the death star cannot make it in time
//            to avoid te infinite loop constrain of i is leftHours * size of list
            hoursTook = 0;
        }

    }
}
