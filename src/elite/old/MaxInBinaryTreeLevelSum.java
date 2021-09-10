package com.elite.old;

import java.util.Scanner;
/*
Problem: Given a Binary Tree having positive and negative nodes,
the task is to find maximum sum level in it.

		              4
                    /   \
                   2    -5
                  / \    /\
                -1   3 -2  6

Sample Input :
7
4 2 -5 -1 3 -2 6

Output:
6

Explanation :
Sum of all nodes of 0'th level is 4
Sum of all nodes of 1'th level is -3
Sum of all nodes of 2'th level is 6
Hence maximum sum is 6

*/


public class MaxInBinaryTreeLevelSum {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int numOfNodes = sc.nextInt();
        BinaryTree bt = new BinaryTree();
        int arr[] = new int[numOfNodes];
        for (int i = 0; i < numOfNodes; i++)
            arr[i] = sc.nextInt();
        bt.root = new MyBinaryTreeNode(arr[0]);
        bt.root = bt.insertLevelOrder(arr, bt.root, 0);

        System.out.println(bt.maxSumInBinaryTreeLevel(bt.root));

    }

}