package Tests;

import java.util.*;

class AnuragBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int arr[] = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int hours = sc.nextInt();
        int min = 1, max = 100, count = 0, mid = 0;
        while (min <= max &&(max-min)!=1) {
            mid = (min + max) / 2;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= mid) {
                    count = count + (arr[i] / mid) + 1;
                }
                if (arr[i] > mid) {
                    count = count + (arr[i] / mid) + 1;
                }
            }
            if (count > hours) {
                min = mid + 1;

            }
            else
            if (count <= hours) {
                max = mid;

            }
            count = 0;
        }
        System.out.println(max);
    }
}
