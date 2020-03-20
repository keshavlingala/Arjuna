package org.streams;

import org.data.Student;
import org.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExaple {
    public static void main(String[] args) {
        Predicate<Student> p1 = (s) -> s.getGradeLevel() > 2;
        Predicate<Student> p2 = (s) -> s.getGpa() > 2.0;
        Map<String, List<String>> collect = StudentDataBase.getAllStudents().stream()
                .filter(p1.and(p2))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));
        System.out.println(collect);

    }
}
