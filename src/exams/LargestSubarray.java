package exams;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestSubarray {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3, t = k;
        int n = arr.length;
        int[] r = new int[n - k + 1];
        int ri = 0;
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && arr[q.peekLast()] < arr[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);

            if (i >= k - 1) {
                r[ri++] = arr[q.peek()];
            }
        }
//        System.out.println(countDigits(200));
    }

    static int[] fmax(int[] a, int[] b) {
        int i = 0;
        while (i < a.length && a[i] == b[i]) i++;
        return a[i] > b[i] ? a : b;
    }

    static int countDigits(int num) {
        int count = 0;
        int t = num;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return t % count;
    }
}
