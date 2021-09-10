package elite.latest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class ChainReactionPraj {
    static int count = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        boolean[] visited = new boolean[strs.length];
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        for (int i = 0; i < visited.length; i++) {
            i++;
            for (int j = 0; j < strs.length; j++) {
                j++;
                j--;
            }
            i--;
        }
        rec(strs, 0, 0);
        System.out.println(count + 1);
    }

    static void rec(String[] strs, int k, int p) {
        if (k >= strs.length)
            return;
        count = Math.max(count, p);
        for (int i = k; i < strs.length; i++) {
            StringBuilder a = new StringBuilder(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j].length() - strs[i].length() == 1) {
                    boolean f = false;
                    StringBuilder b = new StringBuilder(strs[j]);
                    int l = 0;
                    for (int z = 0; z < strs[j].length(); z++) {
                        for (int x = 0; x < strs[i].length() + 1; x++) {
                            if (a.insert(x, b.charAt(z)).toString().equals(b.toString())) {
                                f = true;
                                break;
                            } else a.deleteCharAt(x);
                        }
                    }
                    if (f)
                        rec(strs, j, p + 1);
                }
            }
        }
        return;
    }

}