package com.elite.online.oral;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PalindromGen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in[] = sc.nextLine().split(" ");
        int l = Integer.parseInt(in[1]);
        int n = Integer.parseInt(in[0]);
        String input[] = new String[n];
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String temp[] = sc.nextLine().split(" ");
            input[i] = temp[0];
            if (map.containsKey(temp[0])) {
                map.get(temp[0]).add(Integer.parseInt(temp[1]));
            } else {
                PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
                pq.add(Integer.parseInt(temp[1]));
                map.put(temp[0], pq);
            }
        }
        int ans = 0, m = 0;
        for (int i = 0; i < n; i++) {
            //System.out.println(map+" "+ans);
            String temp = input[i];
            String rtemp = rev(temp);
            if (!temp.equals(rtemp)) {
                while (map.get(temp).peek() != null && map.get(rtemp).peek() != null && map.get(temp).peek() + map.get(rtemp).peek() > 0) {
                    ans += map.get(temp).peek() + map.get(rtemp).peek();
                    map.get(temp).poll();
                    map.get(rtemp).poll();
                }
            } else {
                while (map.get(temp).size() > 1) {
                    int val = map.get(temp).peek();
                    map.get(temp).poll();
                    if (val + map.get(temp).peek() > 0) {
                        ans += val + map.get(temp).peek();
                        m = Math.min(m, map.get(temp).peek());
                        map.get(temp).poll();
                    } else {
                        map.get(temp).add(val);
                        break;
                    }
                }
            }
        }
        m = -m;
        for (int i = 0; i < n; i++) {
            // System.out.println(m);
            String temp = input[i];
            String rtemp = rev(temp);
            if (temp.equals(rtemp) && map.get(temp).peek() != null) {
                m = Math.max(m, map.get(temp).peek());
            }

        }
        System.out.println(ans + m);
    }

    public static String rev(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}
