package Tests;

/*
6)Write a java program to Remove duplicates from ArrayList

sample output:
-------------
Before Removal:[10, 20, 10, 40, 50, 20, 30, 20, 40, 10]
After Removal:[10, 20, 40, 50, 30]
*/

import java.util.ArrayList;
import java.util.*;

public class ArrayList1 {
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<Integer>();

        al.add(10);
        al.add(20);
        al.add(10);
        al.add(40);
        al.add(50);
        al.add(20);
        al.add(30);
        al.add(20);
        al.add(40);
        al.add(10);

        System.out.println("Before Removal:" + al);
        ArrayList<Integer> al2 = new ArrayList<>();
        for (int i : al) {

            if (!al2.contains(i)) {
                al2.add(i);
            }
        }
        al.clear();
        al.addAll(al2);


        System.out.println("After Removal:" + al);
    }
}
