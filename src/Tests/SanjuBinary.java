package Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class SanjuBinary {
    static boolean feasible(int a[], int mid, int h) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % mid == 0) {
                sum = sum + (a[i] / mid);
            } else {
                sum = sum + (a[i] / mid) + 1;
            }
        }
        return sum <= h;

    }

    public static int speed(int a[], int h) {
        int max = a[a.length - 1];
        int min = 1;

        while (min < max) {
            int mid = (min + max) / 2;
            if (!feasible(a, mid, h)) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        int hours = s.nextInt();

        String b[] = input.split(" ");
        int a[] = new int[b.length];

        ArrayList<Integer> arr = new ArrayList<>(b.length);
        for (int i = 0; i < b.length; i++) {
            arr.add(Integer.parseInt(b[i]));
        }
        Collections.sort(arr);
        for (int i = 0; i < b.length; i++) {
            a[i] = arr.get(i);
        }
        int k = speed(a, hours);
        System.out.println(k);
    }
}
