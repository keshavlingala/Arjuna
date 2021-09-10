package com.elite.online.day77;
/*
* You are given the grayscale image of a biopsy of a patient,
you are also given the grayscale pattern of a potential malignant tumour.
You have to print whether the patient has cancer or not.

Input Format:
    - The first line contains two space-separated integers R and C,
      indicating the number of rows and columns in the biopsy image.
    - This is followed by R lines, each with a string of C digits
      representing the gray scale intensities of the biopsy image.
    - The following line contains two space-separated integers, r and c,
      indicating the number of rows and columns in the tumor image .
    - This is followed by r lines, each with a string of c digits
      representing the gray scale intensities of the tumous image.

Output Format:
    - Print "YES",if patient has cancer
      otherwise, "NO"

Sample Input:
4 4
5424
2459
3341
2644
2 2
34
64
Sample Output:
YES*/
import java.util.ArrayList;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        int width = scanner.nextInt();
        ArrayList<String> image = new ArrayList<>();
        for (int i = 0; i < height; i++)
            image.add(scanner.next());
        ArrayList<String> tumer = new ArrayList<>();
        int tumerHeight = scanner.nextInt();
        int tumerWidth = scanner.nextInt();
        for (int i = 0; i < tumerHeight; i++)
            tumer.add(scanner.next());
        boolean ans = false;
        for (int i = 0; i < height; i++) {
            int t = 0;
            int k = i;
            int index = image.get(k).indexOf(tumer.get(t));
            while (k < image.size() && t < tumer.size() && image.get(k).contains(tumer.get(t))) {
                if (index != image.get(k).indexOf(tumer.get(t))) break;
                t++;
                k++;
            }
            if (t == tumerHeight) {
                ans = true;
                break;
            }
        }
        System.out.println(ans ? "YES" : "NO");

    }
}
