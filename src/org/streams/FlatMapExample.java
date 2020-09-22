package org.streams;

import org.data.Student;
import org.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        StudentDataBase.getAllStudents()
                .stream()
//                .peek(System.out::println)
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        Integer[][] dp = new Integer[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dp[i][j] = i + j + 2;
            }
        }
        Arrays.stream(dp).flatMap(Arrays::stream).forEach(FlatMapExample::printWithSpace);
    }

    static void printWithSpace(Integer gen) {
        System.out.print(gen + " ");
    }
}
