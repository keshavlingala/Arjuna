package com.elite.latest.chillar;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SortDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Date> dates = new ArrayList<>();
        SimpleDateFormat row = new SimpleDateFormat("dd MMM yyyy");
        for (int i = 0; i < n; i++) {
            try {
                dates.add(row.parse(scanner.nextLine()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        dates.sort(Date::compareTo);
        dates.forEach(i -> System.out.println(row.format(i)));
    }
}
