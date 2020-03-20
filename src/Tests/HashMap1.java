package Tests;

/*
7)Given an array of strings, return a Map<String, Integer> with a key for each different string, with the value the number of times that string appears in the array.

output:
-------
Count= {a=3, b=2, c=2}
*/

import java.util.*;

class Count {
    public static Map<String, Integer> wordCount(String[] strings) {

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strings.length; i++)
            map.put(strings[i], Collections.frequency(Arrays.asList(strings), strings[i]));
        return map;
    }
}

class HashMap1 {
    public static void main(String a[]) {

        System.out.println("Count= " + Count.wordCount(new String[]{"a", "b", "a", "c", "b", "a", "c"}));

    }
};
