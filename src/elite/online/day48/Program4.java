package com.elite.online.day48;

import java.util.*;

/*
* The member of  Olympic Council of Asia (OCA) is planning to select people for the Asian Games.
They want to choose two from different states.

You will be given a list of pairs of athlete id's.
Each pair is made of athletes from the same state. Determine how many pairs of athletes from
different states they can choose from.

For example, we have the following data on 2 pairs of athletes, and 4 athletes total, numbered
0 through 3.
ID State ID
1  2
2  3
athletes by state are [0] and [1,2,3]. There are 3 pairs to choose from:[0,1],[0,2] and [0,3].


Input Format:
-----------------
The first line contains two integers n and p, the number of athletes and the number of pairs.
Each of the p next lines contains 2 space-separated integers denoting athlete ID's of two athletes
who share the same state.

Output Format
-------------
An integer that denotes the number of ways to choose a pair of athletes from different states.

Sample Input 1:
--------------
    5 3
    0 1
    2 3
    0 4

Sample Output 1:
---------------
    6

Explanation:
    Persons numbered [0,1,4] belong to one state, and those numbered [2,3] belong to another.
    The member has 6 ways of choosing a pair [0,2],[0,3],[1,2],[1,3],[4,2],[4,3]

Sample Input 2:
---------------
    4 1
    0 2

Sample Output 2:
----------------
    5

Explanation:
    Persons numbered [0,2] belong to one state. but persons 1 & 3 don't share states with anyone else.
    The member has 5 ways of choosing a pair [0,1],[0,3],[2,1],[2,3],[1,3].
*/
public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int n = scanner.nextInt();
        int nP = scanner.nextInt();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < nP; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int xP = find(parent, x);
            int yP = find(parent, y);
            if (xP != yP)
                parent[yP] = xP;
        }
//        System.out.println(Arrays.toString(parent));

        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            map.putIfAbsent(p, new HashSet<>());
            map.get(p).add(i);
        }
//        System.out.println(map);
        ArrayList<HashSet<Integer>> vals = new ArrayList<>(map.values());
        int ans = 0;
        for (int i = 0; i < map.size(); i++) {
            for (int j = i + 1; j < map.size(); j++) {
                ans += vals.get(i).size() * vals.get(j).size();
            }
        }
        System.out.println(ans);
    }

    static int find(int[] parent, int node) {
        if (parent[node] == -1)
            return node;
        return find(parent, parent[node]);
    }
}
