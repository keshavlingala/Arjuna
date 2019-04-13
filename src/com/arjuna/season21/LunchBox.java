package com.arjuna.season21;


import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LunchBox {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfStudents = scanner.nextInt();
//        taking inputs using InrStream from Java Util instead of using a loop
        Stack<Integer> lunchBoxes = IntStream.range(0, noOfStudents).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(Stack::new));
        Collections.reverse(lunchBoxes);
//        as it is a stack the entered elements are entered in reverse order so we have to reverse it
        LinkedList<Integer> students = IntStream.range(0, noOfStudents).mapToObj(i -> scanner.nextInt()).collect(Collectors.toCollection(LinkedList::new));
        while (!students.isEmpty()) { //a continuous loop untill all students got the lunchboxes
            if (lunchBoxes.peek() == students.peek()) { //if the 1st box and student have the same pop both
                lunchBoxes.pop();
                students.pop();
            } else { //else move that student to last of the queue
                if (students.contains(lunchBoxes.peek())) { //this is to break the loop if there is no student's preference that the top of the box has
                    int goToLast = students.peek();
                    students.pop();
                    students.add(goToLast);
                } else break; //break the loop if there is no possible matches in future iterations
            }
        }
        System.out.println(lunchBoxes.size()); //there is the result hurry
    }
}