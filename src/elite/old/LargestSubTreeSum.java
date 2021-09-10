package com.elite.old;

/*
Problem: Given a binary tree of 7 nodes, find subtree with maximum sum in tree.


	          1
            /   \
           2      3
          / \    / \
         4   5  6   7

Sample Input 1:
1 2 3 4 5 6 7

Sample Output 1:
28

Explanation 1:
As all the tree elements are positive,
the largest subtree sum is equal to
sum of all tree elements.


              1
            /    \
          -2      3
          / \    /  \
         4   5  -6   2

Sample Input 2:
1 -2 3 4 5 -6 2


Sample Output 2:
7

Explanation 2:
Subtree with largest sum is : -2
                             /  \
                            4    5
Also, entire tree sum is also 7.

*/

import java.util.HashMap;
import java.util.Scanner;

class MyBinaryTreeNode {

    public int data;
    public MyBinaryTreeNode left;
    public MyBinaryTreeNode right;

    public MyBinaryTreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public MyBinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(MyBinaryTreeNode left) {
        this.left = left;
    }

    public MyBinaryTreeNode getRight() {
        return right;
    }

    public void setRight(MyBinaryTreeNode right) {
        this.right = right;
    }


}

class BinaryTree {

    // Root of BinaryTree
    MyBinaryTreeNode root;

    public int findLargestSubtreeSum(MyBinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(sum(root), Math.max(findLargestSubtreeSum(root.left), findLargestSubtreeSum(root.right)));

    }


    int sum(MyBinaryTreeNode node) {
        if (node == null)
            return 0;
        return node.getData() + sum(node.getLeft()) + sum(node.getRight());
    }

    public int maxSumInBinaryTreeLevel(MyBinaryTreeNode root) {

        HashMap<Integer, Integer> hp = new HashMap<>();
        maxRec(0, root, hp);
        return hp.values().stream().max(Integer::compareTo).get();
    }

    public MyBinaryTreeNode insertLevelOrder(int[] arr, MyBinaryTreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            MyBinaryTreeNode temp = new MyBinaryTreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);
        }
        return root;
    }

    void maxRec(int level, MyBinaryTreeNode node, HashMap<Integer, Integer> hp) {
        if (node == null) {
            return;
        }
        if (hp.containsKey(level)) {
            hp.put(level, hp.get(level) + node.data);
        } else {
            hp.put(level, node.data);
        }
        maxRec(level + 1, node.right, hp);
        maxRec(level + 1, node.left, hp);
    }


}

public class LargestSubTreeSum {


    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        Scanner sc = new Scanner(System.in);


        //creating a binary tree
        tree.root = new MyBinaryTreeNode(sc.nextInt());
        tree.root.setLeft(new MyBinaryTreeNode(sc.nextInt()));
        tree.root.setRight(new MyBinaryTreeNode(sc.nextInt()));
        tree.root.getLeft().setLeft(new MyBinaryTreeNode(sc.nextInt()));
        tree.root.getLeft().setRight(new MyBinaryTreeNode(sc.nextInt()));
        tree.root.getRight().setLeft(new MyBinaryTreeNode(sc.nextInt()));
        tree.root.getRight().setRight(new MyBinaryTreeNode(sc.nextInt()));

        System.out.println(tree.findLargestSubtreeSum(tree.root));

    }

}

