package com.arjuna.season20;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Athelets {
    static int getFirst(List<Integer> queue, List<Integer> arr, int currF) {
// if the frequency of any element on the right of the list has more frequecy that the current element freq the return that element
        for (int i : arr)
            if (Collections.frequency(queue, i) > currF)
                return i;
        // else return -1
        return -1;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        ArrayList<Integer> queue;
        queue = IntStream.range(0, size).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < size; i++)
            result.add(getFirst(queue, queue.subList(i + 1, size), Collections.frequency(queue, queue.get(i))));
        for (int i : result)
            System.out.print(i + " ");
    }
}
