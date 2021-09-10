package com.elite.latest.chillar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDifference {
    public static void main(String[] args) {
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        s.setLenient(false);
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        try {
            Date d = s.parse(date);
            Date year = new Date(d.getYear(), 0, 1);
//            System.out.println(d);
//            System.out.println(year);
            long diffMill = d.getTime() - year.getTime();
            int diffDays = (int) (diffMill / (60 * 60 * 1000 * 24));
            System.out.println(diffDays + 1);
        } catch (ParseException e) {
            System.out.println(-1);
        }

    }
}
