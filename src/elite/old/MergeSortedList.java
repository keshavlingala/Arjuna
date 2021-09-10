package com.elite.old;

/*
 * Problem:(Problem No.32 from Linked List)
 * Given two sorted Linked Lists, we need to merge them into the third list in sorted order.
 *
 *
	Sample Input :
    10 20 30 40 50 -1
	15 25 35 45 -1

	Sample Output :
	10 15 20 25 30 35 40 45 50
 *
 *
 */

import java.util.Scanner;

class MyListNode {
    public MyListNode next;
    public int data;

    // Creates an empty node.
    public MyListNode() {
        next = null;
        data = Integer.MIN_VALUE;
    }

    // Creates a node storing the specified data.
    public MyListNode(int data) {
        next = null;
        this.data = data;
    }

    // Returns the node that follows this one.
    public MyListNode getNext() {
        return next;
    }

    // Sets the node that follows this one.
    public void setNext(MyListNode node) {
        next = node;
    }

    // Returns the data stored in this node.
    public int getData() {
        return data;
    }

    // Sets the data stored in this node.
    public void setdata(int elem) {
        data = elem;
    }

    // Sets the data stored in this node.
    public String toString() {
        return Integer.toString(data);
    }
}

class MyLinkedList {
    // This class has a default constructor:
    public MyLinkedList() {
        length = 0;
    }

    // Length of the linked list
    private int length = 0;
    // This is the only field of the class. It holds the head of the list
    MyListNode head;

    // Insert a node at the end of the list
    public synchronized void insertAtEnd(MyListNode node) {
        if (head == null)
            head = node;
        else {
            MyListNode p, q;
            for (p = head; (q = p.getNext()) != null; p = q)
                ;
            p.setNext(node);
        }
        length++;
    }


    // Return the current length of the list.
    public int length() {
        return length;
    }

    @Override
    public String toString() {
        String s = "";
        MyListNode node = this.head;
        while (node.getNext() != null) {
            s += node.getNext()+" ";
            node = node.getNext();
        }
        return s;
    }
}

class MergeSortedLists {


    // static ListNode head;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int tempData = -1;

        // create a linked list
        MyLinkedList list1 = new MyLinkedList();

        // add nodes one by one till you find end of the character
        while ((tempData = sc.nextInt()) != -1) {
            // add nodes to the linked list
            list1.insertAtEnd(new MyListNode(tempData));
        }

        // create a linked list
        MyLinkedList list2 = new MyLinkedList();

        // add nodes one by one till you find end of the character
        while ((tempData = sc.nextInt()) != -1) {
            // add nodes to the linked list
            list2.insertAtEnd(new MyListNode(tempData));
        }

        // create a linked list
        MyLinkedList mergedList = new MyLinkedList();

        // call merge two lists iterative function
        mergedList.head = mergeTwoLists(list1.head, list2.head);

        System.out.println(mergedList.toString());

    }


    public static MyListNode mergeTwoLists(MyListNode head1, MyListNode head2) {
        MyListNode dummy = new MyListNode();
        MyListNode head = dummy;
        while (head1 != null && head2 != null) {
            if (head1.getData() < head2.getData()) {
                dummy.setNext(head1);
                head1 = head1.getNext();
                dummy=dummy.getNext();
            } else {
                dummy.setNext(head2);
                head2 = head2.getNext();
                dummy=dummy.getNext();
            }
        }
        if (head1 == null) {
            dummy.setNext(head2);
        } else {
            dummy.setNext(head1);
        }
        return head;
    }
}
