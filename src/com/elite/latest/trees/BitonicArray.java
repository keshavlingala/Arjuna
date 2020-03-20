package com.elite.latest.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.System.*;

public class BitonicArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(br.readLine());
        int l = 0, r = arr.length - 1;
        int mid = (l + r) / 2;
        if (arr[r] == key) {
            out.println(r);
            exit(0);
        }
        if (arr[l] == key) {
            out.println(l);
        }
        while (l < r) {
            mid = (l + r) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                break;
            }
            if (arr[mid] < arr[mid + 1]) {
                l = mid - 1;
            } else {
                r = mid + 1;
            }
        }
        if (key == arr[mid]) {
            out.println(mid);
            exit(0);
        } else {
            int index = Arrays.binarySearch(arr, 0, mid, key);
            if (index >= 0) {
                out.println(index);
                exit(0);
            } else {
                l = mid;
                r = arr.length - 1;
                while (l < r) {
                    mid = (l + r) / 2;
                    if (key == mid) {
                        break;
                    }
                    if (arr[mid] > key) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }
        out.println(arr[mid] == key ? mid : -1);
    }
}