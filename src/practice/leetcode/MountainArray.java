package practice.leetcode;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 3, 2, 1};
        System.out.println(validMountainArray(arr));
    }

    static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        boolean inc = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) inc = false;
            if (inc) {
                if (A[i] >= A[i + 1]) return false;
            } else if (A[i] <= A[i + 1]) return false;
        }
        return true;
    }

}
