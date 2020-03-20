package Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*Given two arrays,write a java program to  print which number is not present in the second array.(Array size=5)

Note :- If more than one element is not present  in the second array print the elements in the order which they occur.

 if no elements are not present in the second array print -1.

Input: 1 2 3 4 5
            2 3 1 0 5
output: 4

Input: 6 2 5 1 7
            1 3 4 2 9
output:
6
5
7
*/
public class ArrEle {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> strings = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> number = new ArrayList<>();
        for (int s : strings) {
            number.add(Integer.parseInt(s + ""));
        }

        ArrayList<Integer> arr1 = IntStream.range(0, 5).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> arr2 = IntStream.range(0, 5).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr1.forEach(a -> {
            System.out.println(a);
        });

        for (int i : arr1) {
            if (arr2.contains(i)) {
                continue;
            } else {
                arr3.add(i);
            }
        }
        if (arr3.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < arr3.size(); i++) {
                System.out.println(arr3.get(i));
            }
        }

    }
}
