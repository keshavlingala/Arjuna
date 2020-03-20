package com.elite.old;

import java.util.*;
import java.util.stream.IntStream;

public class InfinitySaga {
    static int find(int[] parent, int n) {
        if (parent[n] == -1)
            return n;
        return find(parent, parent[n]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int con = scanner.nextInt();
        int[] arr = IntStream.range(0, n).map(i -> scanner.nextInt()).toArray();
        HashMap<Integer, List<Integer>> hp = new HashMap<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < con; i++) {
            int p1 = find(parent, scanner.nextInt() - 1);
            int p2 = find(parent, scanner.nextInt() - 1);
            if (p1 != p2)
                parent[p2] = p1;
        }
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            if (!hp.containsKey(p)) {
                hp.put(p, new ArrayList<>());
            }
            hp.get(p).add(i);
        }
        int sum = hp.values()
                .stream()
                .map(l -> l.stream()
                        .map(x -> arr[x])
                        .min(Integer::compareTo)
                        .get())
                .reduce(0, Integer::sum);
        System.out.println(sum);

    }
}
