package com.elite.latest.chillar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DayNumber {
    public static void main(String[] args) {
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        int year = Integer.parseInt(date.substring(6));
        if (year < 1901 || year > 2099) {
            System.out.println(-2);
            System.exit(0);
        }
        try {
            s.setLenient(false);
            Date d = s.parse(date);
            Calendar c = new GregorianCalendar();
//            System.out.println(d);
//            System.out.println(d.getDay());
            Date start = s.parse("01-01-1901");
            Date end = s.parse("31-12-2099");
            if (d.compareTo(start) != 1 || d.compareTo(end) != -1) {
                System.out.println(-2);
                System.exit(0);
            }
            switch (d.getDay()) {
                case 0:
                    System.out.println("Sunday");
                    break;
                case 1:
                    System.out.println("Monday");
                    break;
                case 2:
                    System.out.println("Tuesday");
                    break;
                case 3:
                    System.out.println("Wednesday");
                    break;
                case 4:
                    System.out.println("Thursday");
                    break;
                case 5:
                    System.out.println("Friday");
                    break;
                case 6:
                    System.out.println("Saturday");
                    break;

            }

        } catch (ParseException e) {

            System.out.println(-1);
        }

    }
}
