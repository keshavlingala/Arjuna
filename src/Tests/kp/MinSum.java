package Tests.kp;

public class MinSum {
    public static void main(String[] args) {
        System.out.println(cum(0, false, 0, new int[]{-3, 2, 4, -1, -2, -5}));
    }

    static int cum(int i, boolean skip, int sum, int[] ratings) {
        if (i >= ratings.length)
            return sum;
        if (skip) return cum(i + 1, false, sum + ratings[i], ratings);
        return Math.max(cum(i + 1, false, sum + ratings[i], ratings), cum(i + 1, true, sum, ratings));
    }
}

