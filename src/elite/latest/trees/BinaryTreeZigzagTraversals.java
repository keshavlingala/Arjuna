package elite.latest.trees;

import org.BinaryTree;

import java.util.*;

/*
Problem: Write a program to display Zigzag order traversal of a given n nodes tree.

		       	  1
		       /	 \
		      /       \
		     /   	   \
		    2      	    3
		  /   \    	  /   \
		 4     5  	 6     7
	    / \   / \   / \   / \
       8  9  10 11  12 13 14 15

Sample Input:15
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15

Sample Output:
1 3 2 4 5 6 7 15 14 13 12 11 10 9 8

*/
// MyBinaryTreeNode Class containing left and right child of current node and data value


public class BinaryTreeZigzagTraversals {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int numOfNodes = sc.nextInt();
        BinaryTree bt = new BinaryTree();
        int arr[] = new int[numOfNodes];
        for (int i = 0; i < numOfNodes; i++)
            arr[i] = sc.nextInt();
//        bt.root = new com.elite.old.MyBinaryTreeNode(arr[0]);
//        bt.root = bt.insertLevelOrder(arr, bt.root, 0);
//        bt.zigzagTreeOrder(bt.root);

    }

}
