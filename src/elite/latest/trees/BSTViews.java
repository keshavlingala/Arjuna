package com.elite.latest.trees;

import java.util.*;

//MyBinaryTreeNode Class containing left and right child of current node and data value
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

    static HashMap<Integer, List<Integer>> hp = new HashMap<>();
    // Root of BinaryTree
    MyBinaryTreeNode root;

    static void rec(MyBinaryTreeNode node, int dep) {
        if (node == null)
            return;
        if (!hp.containsKey(dep)) {
            hp.put(dep, new ArrayList<>());
        }
        hp.get(dep).add(node.data);
        rec(node.left, dep + 1);
        rec(node.right, dep + 1);
    }

    // Function to insert nodes in level order
    public MyBinaryTreeNode insertLevelOrder(int[] arr, MyBinaryTreeNode root, int i) {

        // Base case for recursion
        if (i < arr.length) {

            if (arr[i] == -1)
                return null;

            MyBinaryTreeNode temp = new MyBinaryTreeNode(arr[i]);
            root = temp;

            // insert left child
            root.left = insertLevelOrder(arr, root.left, 2 * i + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, 2 * i + 2);

        }
        return root;
    }

    //  function to print left view
    void leftView(MyBinaryTreeNode node) {
        rec(node, 0);
        for (int k : hp.keySet()) {
            System.out.print(hp.get(k).get(0) + " ");
        }
        System.out.println();
    }


    //  function to print right view
    void rightView(MyBinaryTreeNode node) {
        for (int k : hp.keySet()) {
            System.out.print(hp.get(k).get(hp.get(k).size() - 1) + " ");
        }
        System.out.println();
    }

    public void zigzagTreeOrder(MyBinaryTreeNode root) {
        rec(root, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int k : hp.keySet()) {
            if ((k & 1) == 1) {
                Collections.reverse(hp.get(k));
            }
            ans.addAll(hp.get(k));
        }
        ans.forEach(i->System.out.print(i+" "));
    }


    // function should print the topView of
    public void TopView(MyBinaryTreeNode root) {
        MyBinaryTreeNode temp = root;
        ArrayList<Integer> ans = new ArrayList<>();
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.left;
        }
        Collections.reverse(ans);
        ans.forEach(i -> System.out.print(i + " "));
        temp = root.right;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }
}

class LeftRightTopView {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int numOfNodes = sc.nextInt();
        BinaryTree bt = new BinaryTree();
        int arr[] = new int[numOfNodes];
        for (int i = 0; i < numOfNodes; i++)
            arr[i] = sc.nextInt();
        bt.root = new MyBinaryTreeNode(arr[0]);
        bt.root = bt.insertLevelOrder(arr, bt.root, 0);
//        bt.leftView(bt.root);
//        System.out.println();
//        bt.rightView(bt.root);
//        System.out.println();
//        bt.TopView(bt.root);
        bt.zigzagTreeOrder(bt.root);


    }

}
