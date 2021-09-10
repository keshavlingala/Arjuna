/*
 * 
Given two numbers represented by two lists, 
write a function that returns sum list. 
The sum list is list representation of addition of two input numbers.

Sample Input : 
5 6 3 -1
8 4 2 -1

Sample Output : 
3 1 6

Explanation:
  First List: 5->6->3  // represents number 365
  Second List: 8->4->2 //  represents number 248

  Resultant list: 3->1->6  // represents number 613


=======TestCases==========
case =1
input =7 5 6 3 -1
4 8 4 2 -1
output =1 4 1 6

case =2
input =7 5 6 3 -1
4 8 4 7 -1
output =1 4 1 1 1

case =3
input =9 3 5 2 9 -1
1 6 4 7 0 -1
output =0 0 0 0 0 1

case =4
input =1 2 3 4 -1
3 4 5 6 -1
output =4 6 8 0 1

case =5
input =9 9 9 9 9 -1
2 3 4 5 -1
output =1 3 4 5 0 1



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

	// Return a string representation of this collection, in the form
	// "str1" "str2" ....
	public String toString() {
		String result = "";
		if (head == null) {
			return result + "";
		}
		result = result + head.getData();
		MyListNode temp = head.getNext();
		while (temp != null) {
			result = result + " " + temp.getData();
			temp = temp.getNext();
		}
		return result + "";
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

}

public class AddTwoNumbers {

	// static ListNode head;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tempData = -1;

		// create a linked list
		MyLinkedList list1 = new MyLinkedList();
		MyLinkedList list2 = new MyLinkedList();

		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list1.insertAtEnd(new MyListNode(tempData));
		}
		// add nodes one by one till you find end of the character
		while ((tempData = sc.nextInt()) != -1) {
			// add nodes to the linked list
			list2.insertAtEnd(new MyListNode(tempData));
		}

		// create a linked list
		MyLinkedList resultList = new MyLinkedList();

		resultList.head = addTwoReversedNumbers(list1.head, list2.head);

		System.out.println(resultList.toString());

	}

	public static MyListNode addTwoReversedNumbers(MyListNode l1, MyListNode l2) {
		int carry = 0;
		MyListNode head = new MyListNode(0);
		MyListNode sum = head;
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				carry += l1.getData();
				l1 = l1.getNext();
			}
			if (l2 != null) {
				carry += l2.getData();
				l2 = l2.getNext();
			}
			sum.setNext(new MyListNode(carry % 10));
			sum = sum.getNext();
			carry /= 10;
		}
		sum.setNext(carry == 1 ? new MyListNode(1) : null);
		return head.next;
	}
}
