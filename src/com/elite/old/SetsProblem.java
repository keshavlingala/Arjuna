package com.elite.old;

/*
Given a string s, and a list of pair's of indices where pair[i] = [x, y]
        indicates 2 indices(0-indexed) of the string.

        You can swap the characters at any pair of indices in the given pairs any number of times.

        Return the lexicographically smallest string that s can be changed to after using the swaps.

        Example 1:
        Input=  dcab
        2
        0 3
        1 2
        Output= bacd
        Explaination:
        Swap s[0] and s[3], s = "bcad"
        Swap s[1] and s[2], s = "bacd"

        Example 2:
        Input=  dcab
        3
        0 3
        1 2
        0 2
        Output= abcd
        Explaination:
        Swap s[0] and s[3], s = "bcad"
        Swap s[0] and s[2], s = "acbd"
        Swap s[1] and s[2], s = "abcd"

        Example 3:
        Input=  cba
        2
        0 1
        1 2
        Output: abc
        Explaination:
        Swap s[0] and s[1], s = "bca"
        Swap s[1] and s[2], s = "bac"
        Swap s[0] and s[1], s = "abc"

        Constraints:
        1 <= s.length <= 10^5
        0 <= pairs.length <= 10^5
        0 <= pairs[i][0], pairs[i][1] < s.length
        s only contains lower case English letters.

*/

import java.util.*;

class SetsProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        int[] parent = new int[s.length()];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            int p1 = find(parent, scanner.nextInt());
            int p2 = find(parent, scanner.nextInt());
            if (p1 != p2)
                parent[p2] = p1;
        }
        HashMap<Integer, List<Integer>> hp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int p = find(parent, i);
            if (!hp.containsKey(p)) {
                hp.put(p, new ArrayList<>());
            }
            hp.get(p).add(i);
        }
        HashMap<Integer, Character> string = new HashMap<>();
        Iterator<Integer> iter = hp.keySet().iterator();
        for (int i = 0; i < hp.size(); i++) {
            List<Integer> list = hp.get(iter.next());
            char[] group = new char[list.size()];
            for (int j = 0; j < list.size(); j++)
                group[j] = s.charAt(list.get(j));
            Arrays.sort(group);
            for (int j = 0; j < list.size(); j++)
                string.put(list.get(j), group[j]);
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res += string.get(i);
        }
        System.out.println(res);
    }


    static int find(int[] parent, int num) {
        if (parent[num] == -1)
            return num;
        return find(parent, parent[num]);
    }
}

