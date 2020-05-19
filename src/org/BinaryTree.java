package org;


import java.util.Arrays;
import java.util.Scanner;

class BTNode {
    BTNode left, right;
    int data;

    public BTNode() {
        left = null;
        right = null;
        data = 0;
    }

    public BTNode(int n) {
        left = null;
        right = null;
        data = n;
    }

}

class BT {
    public BTNode root;

    public BT() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private BTNode insert(BTNode node, int data) {
        if (node == null)
            node = new BTNode(data);
        else {
            if (node.right == null)
                node.right = insert(node.right, data);
            else
                node.left = insert(node.left, data);
        }
        return node;
    }

    public int countNodes(BTNode r) {
        if (r == null)
            return 0;
        else {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    public boolean search(BTNode r, int val) {
        if (r.data == val)
            return true;
        if (r.left != null)
            if (search(r.left, val))
                return true;
        if (r.right != null)
            return search(r.right, val);
        return false;
    }

    void display(BTNode node) {
        if (node != null) {
            if (node.left != null) display(node.left);
            System.out.print(node.data + " ");
            if (node.right != null) display(node.right);
        }
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BT bt = new BT();
        System.out.println("Binary Tree Operations\n");
        char ch;
        do {
            System.out.println("Current Binary Tree Elements :");
            bt.display(bt.root);
            System.out.println("\nBinary Tree Operations\n 1. Insert Elements\n 2. search \n 3. count nodes \n 4. check empty\n 5. Quit");
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("Enter integer element to insert");
                scan.nextLine();
                for (int num : Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray())
                    bt.insert(num);
            } else if (choice == 2) {
                System.out.println("Enter integer element to search");
                System.out.println("Search result : " + bt.search(bt.root, scan.nextInt()));
            } else if (choice == 3) System.out.println("Nodes = " + bt.countNodes(bt.root));
            else if (choice == 4) System.out.println("Empty status = " + bt.isEmpty());
            else if (choice == 5) break;
            else System.out.println("Wrong Entry");
        } while (true);
    }
}
