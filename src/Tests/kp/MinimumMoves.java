package Tests.kp;

import java.util.Scanner;

public class MinimumMoves {
    static int moveMin(int[] arr) {
        int[] minSeen = new int[arr.length];
        minSeen[arr.length - 1] = arr[arr.length - 1];

        for (int i = arr.length - 2; i >= 0; i--) {
            minSeen[i] = Math.min(minSeen[i + 1], arr[i]);
        }
        int count = 0;
        int maxMoved = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxMoved) {
                count++;
            } else if (arr[i] > minSeen[i]) {
                count++;
                maxMoved = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(moveMin(new int[]{6, 5, 1, 2}));
    }
}
