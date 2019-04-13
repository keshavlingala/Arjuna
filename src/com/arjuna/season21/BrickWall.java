package com.arjuna.season21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BrickWall {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfRows = Integer.parseInt(scanner.nextLine());
        //reading 1st line for no of rows
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < noOfRows; i++)
            listList.add(Arrays
                    .asList(scanner.nextLine().split(" "))  //splitting the long string with whitespace and converting it to list
                    .stream().map(s -> Integer.parseInt(s)) // then parsing each string element as integer
                    .collect(Collectors.toList())); //then returning the list
        int rowSum = listList.get(0).stream().mapToInt(i -> i).sum(); // as observed wall each layer in wall have same length
        int minCuts = noOfRows;
        for (int part = 1; part < rowSum - 1; part++) {
            int brokenBricks = 0;
            for (List<Integer> l : listList) {
                int innerSum = 0;
                for (int i : l) {
                    innerSum += i;
                    if (innerSum == part) {
                        break;
                    } else if (innerSum > part) {
                        brokenBricks++;
                        break;
                    }
                }
            }
            if (minCuts > brokenBricks)
                minCuts = brokenBricks;
        }
        System.out.println(minCuts);
    }
}