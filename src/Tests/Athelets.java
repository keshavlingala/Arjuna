package Tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Athelets {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = IntStream.range(0, n).mapToObj(i -> sc.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < n - 1; i++) {
            int f = 0;
            for (int j = i + 1; j < n; j++) {
                if (Collections.frequency(a, a.get(i)) < Collections.frequency(a, a.get(j))) {
                    System.out.print(a.get(j) + " ");
                    f = 1;
                    break;
                }
            }
            if (f == 0) {
                System.out.print("-1 ");
            }
        }
        System.out.print("-1");
    }
}
