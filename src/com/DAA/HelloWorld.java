package com.DAA;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        try {
            List lines = Files.readAllLines(Paths.get("C:\\Favorites\\Arjuna\\out\\production\\Arjuna\\com\\DAA\\file1.txt"));
            System.out.println(lines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

//class MergeAlgorithm implements Runnable {
//
//    int[] mSort(int[] array) {
//        if (array.length <= 1) {
//            return array;
//        }
//        int midpoint = array.length / 2;
//        int[] left = new int[midpoint];
//        int[] right = array.length % 2 == 0 ? (new int[midpoint]) : new int[midpoint + 1];
//
////        System.arraycopy(array, 0, left, 0, midpoint);
//        for (int i = 0; i < midpoint; i++) {
//            left[i] = array[i];
//        }
//        for (int j = 0; j < right.length; j++) {
//            right[j] = array[midpoint + j];
//        }
//        left = mSort(left);
//        right = mSort(right);
//
//        int[] result = mergeMe(left, right);
//        return null;
//    }
//
//    private int[] mergeMe(int[] left, int[] right) {
//        int i = 0, j = 0, k = 0;
//        int[] result = new int[left.length + right.length];
//        while (i < left.length || j < right.length) {
//            if (left[i] <= right[j]) {
//                result[k++] = left[i++];
//            } else {
//                result[k++] = right[j++];
//            }
//        }
//        if (i == left.length) {
//
//        }
//
//
//    }
//
//    @Override
//    public void run() {
//
//    }
//}

