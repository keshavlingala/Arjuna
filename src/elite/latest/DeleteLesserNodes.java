package elite.latest;

/*
 * Given a singly linked list, remove all the nodes which have a greater value
 on right side.

Examples:
a) The list 12->15->10->11->5->6->2->3->NULL should be changed
to 15->11->6->3->NULL.
Note that 12, 10, 5 and 2 have been deleted because there is a greater
value on the right side.

When we examine 12, we see that after 12 there is one node with value greater
than 12 (i.e. 15), so we delete 12.
When we examine 15, we find no node after 15 that has value greater than 15
so we keep this node.
When we go like this, we get 15->11->6->3

	Sample Input :
    12 15 10 11 5 6 2 3 -1

	Sample Output :
	15 11 6 3
 *
 *
 */

import java.util.Scanner;


public class DeleteLesserNodes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tempData = -1;
        com.elite.latest.MyLinkedList list = new MyLinkedList();
        while ((tempData = sc.nextInt()) != -1) {
            list.insertAtEnd(new MyListNode(tempData));
        }
        com.elite.latest.MyLinkedList remainingNodes = new MyLinkedList();
        remainingNodes.head = delLesserNodes(list.head);
        System.out.println(remainingNodes.toString());
    }

    static MyListNode delLesserNodes(MyListNode head) {
        head = reverse(head);
        MyListNode ans = new MyListNode(head.data);
        MyListNode res = ans;
        MyListNode temp = head.next;
        while (temp != null) {
            if (ans.data < temp.data) {
                ans.next = new MyListNode(temp.data);
                ans = ans.next;
            }
            temp = temp.next;
        }
        return reverse(res);
    }

    static MyListNode reverse(MyListNode head) {
        MyListNode curr = head;
        MyListNode prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

