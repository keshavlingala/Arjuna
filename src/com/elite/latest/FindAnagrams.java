package com.elite.latest;

import java.util.*;
import java.util.stream.Collectors;

public class FindAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        LinkedHashMap<List<String>, List<String>> hp = new LinkedHashMap<>();
        for (String num : nums) {
            List<String> ar = Arrays.stream(num.split("")).sorted().collect(Collectors.toList());
            if (!hp.containsKey(ar))
                hp.put(ar, new ArrayList<>());
            hp.get(ar).add(num);
        }
        boolean yes = false;
        for (List<String> a : hp.keySet())
            if (hp.get(a).size() > 1) {
                yes = true;
                System.out.println(hp.get(a));
            }
        if (!yes)
            System.out.println(-1);
    }
}
