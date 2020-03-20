package org.streams;

import org.data.Student;
import org.data.StudentDataBase;

import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        StudentDataBase.getAllStudents()
                .stream()
                .peek(System.out::println)
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
