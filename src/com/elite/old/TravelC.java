package com.elite.old;

import java.util.*;


class TravelC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String from = scanner.next();
            String to = scanner.next();
            if (map.containsKey(from))
                map.get(from).add(to);
            else
                map.put(from, new ArrayList<String>(Arrays.asList(to)));
        }
        for (String a : map.keySet())
            map.get(a).sort(String::compareTo);
        System.out.println(rec(map, n));
    }

    static List<String> rec(HashMap<String, ArrayList<String>> map, int n) {
        ArrayList<String> journey = new ArrayList<String>();
        String from = "BZA";
        journey.add(from);
        while (n >= 0) {
            n--;
            ArrayList<String> dest = map.get(from);
            for (String to : dest)
                if (map.get(to) != null && map.get(to).size() != 0) {
                    from = to;
                    journey.add(from);
                    dest.remove(to);
                    break;
                }
        }
        journey.add(map.get(from).get(0));
        return journey;
    }
}
