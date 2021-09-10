package hc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Intersection {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersect(new int[]{1,2,2,1},new int[]{2,2})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> c1 = new HashMap<>();
        HashMap<Integer, Integer> c2 = new HashMap<>();
        for (int i : nums1)
            c1.put(i, c1.getOrDefault(i, 0) + 1);
        for (int i : nums2)
            c2.put(i, c2.getOrDefault(i, 0) + 1);
        var common = c1.keySet();
        common.retainAll(c2.keySet());
        ArrayList<Integer> ans=new ArrayList<>();
        for (int key : common) {
            int mCount = Math.min(c1.get(key), c2.get(key));
            System.out.println(key+" "+mCount);
            while(mCount-->0)ans.add(key);
        }
        return ans.stream().mapToInt(i->i).toArray();

    }
}

