package com.DAA;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = r.nextInt(100);
        }
        System.out.println("Before Sort");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        qSort(arr, 0, arr.length - 1);
        System.out.println("\nAfter Sort");
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }

    private static void qSort(int[] arr, int start, int end) {
        if (end < start) {
            return;
        }
        int pivotIndex = (start + end) / 2;
        int pivote = arr[pivotIndex];
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (arr[left] < pivote)
                left++;
            while (arr[right] > pivote)
                right--;
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
        qSort(arr, start, pivotIndex - 1);
        qSort(arr, pivotIndex + 1, end);
    }
}
