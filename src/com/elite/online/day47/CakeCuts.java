package com.elite.online.day47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.*;

public class CakeCuts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(in);
        int cuts = scanner.nextInt();
        int[] angles = new int[cuts];
        for (int i = 0; i < cuts; i++) angles[i] = scanner.nextInt();
        if (cuts > 180) {
            out.println(360 - cuts);
            exit(0);
        }
        if (cuts == 1) {
            out.println("1");
            exit(0);
        }

        int count = 0, angle = 0;
        int[] alist = new int[cuts - 1];
        int i, diff = 360, diff1;
        Arrays.sort(angles);
        for (i = 0; i < cuts - 1; i++) {
            diff1 = angles[i + 1] - angles[i];
            alist[i] = diff1;
            if (diff1 < diff) {
                diff = diff1;
            }
        }
        Arrays.sort(alist);
        int div = diff;

        ArrayList<Integer> factors = new ArrayList<>();

        for (i = div; i >= 1; i--) {
            if (div % i == 0) {
                factors.add(i);
            }
        }
        out.println(factors);
        for (Integer factor : factors) {
            for (i = 0; i < alist.length; i++) {
                if (alist[i] % factor == 0 && 360 % factor == 0) {
                    angle = factor;
                    count++;
                    break;
                }
            }
            if (count != 0) {
                break;
            }
        }
        out.println((360 / angle) - cuts);
    }

}
