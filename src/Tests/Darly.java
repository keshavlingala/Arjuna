package Tests;

import java.util.*;

public class Darly {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(22);
        arr.add(6);
        arr.add(12);
        arr.add(21);
        arr.add(99);
        System.out.println(Arrays.toString(knear(arr, 3)));
    }

    static int[] knear(ArrayList<Integer> arr, int k) {
        arr.sort(Comparator.comparingInt(Integer::intValue));
        int minSum = Integer.MAX_VALUE;
        List<Integer> ans = arr.subList(0, k);
        for (int i = 0; i < arr.size() - k + 1; i++) {
            System.out.println(arr.subList(i, i + k));
            int sum = 0;
            List<Integer> subList = arr.subList(i, i + k);
            for (int j = 0; j < k - 1; j++) {
                sum += Math.abs(subList.get(j) - subList.get(j + 1));
            }
            if (sum < minSum) {
                minSum = sum;
                ans = arr.subList(i, i + k);
            }
            System.out.println(sum);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static int ingredients(int n, int i) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int t = n; t >= 1; t /= 2) {
            arr.add(t);
        }
        for (int j = 0; j < i - 1; j++) {
            int p = arr.size();
            for (int k = 0; k < p; k++) {
                int item = arr.get(k);
                if (item == 1) continue;
                for (int l = item / 2; l >= 1; l /= 2) {
                    arr.add(l);
                }
            }
        }
        System.out.println(arr);
        return 0;
    }

    static int noOfSoldiers(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i);
        int i = 0;
        while (list.size() > 1) {
            list.remove(i);
            i += 1;
            i = i % list.size();
        }
        return list.get(0);
    }
}
