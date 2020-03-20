package com.elite.old;

import java.util.*;

public class Travel {
    static HashMap<String, ArrayList<String>> conn;
    static Set<String> all;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        conn = new HashMap<>();
        all = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] rou = scanner.nextLine().split(" ");
            all.add(rou[0]);
            all.add(rou[1]);
            if (!conn.containsKey(rou[0])) {
                conn.put(rou[0], new ArrayList<>(Collections.singletonList(rou[1])));
                continue;
            }
            conn.get(rou[0]).add(rou[1]);
            conn.get(rou[0]).sort(String::compareTo);
        }
        System.out.println(conn);
        System.out.println(rec("", "BZA", "BZA"));
    }

    static ArrayList<String> rec(String visited, String node, String path) {
        for (String key : conn.keySet()) {
            if (!visited.contains(key)) {
            }
        }
        if (visited.contains(node)) {
            return new ArrayList<>(Collections.singletonList(path));
        }
        ArrayList<String> ans = new ArrayList<>();
        for (String city : conn.get(node)) {
            if (!visited.contains(city)) {
                ArrayList<String> list = rec(visited + node, city, path + " " + city);
            }
        }
        return new ArrayList<String>(Arrays.asList(path.split(" ")));
    }

//    static String find(String node) {
//        if (next.get(node).equals("#")) {
//            return node;
//        }
//        return find(next.get(node));
//    }
}
