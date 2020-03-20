package Tests;


import java.util.Arrays;
import java.util.Scanner;

public class HonerChar {
    public static void main(String args[]) {
        Scanner scannner = new Scanner(System.in);
        String s = scannner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean honey = true;
            for (int j = i; j < s.length(); j++) {
                if (!(c >= s.charAt(j))) {
                    honey = false;
                    break;
                }
            }
            if (honey) {
                System.out.print(c);
            }
        }
    }
}
