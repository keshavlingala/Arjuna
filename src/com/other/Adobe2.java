package com.other;

import java.util.*;

class Node {
    int data;
    Node left = null, right = null;

    Node(int data) {
        this.data = data;
    }
}

public class Adobe2 {
    static List<Integer> inor = new ArrayList<>();
    static List<Integer> preorder = new ArrayList<>();
    static List<Integer> postorder = new ArrayList<>();

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
//        System.out.print(root.data + " ");
        inor.add(root.data);
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        preorder.add(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        postorder.add(root.data);
    }

    public static Node createTree(int[] parent) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            map.put(i, new Node(i));
        }
        Node root = null;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1) {
                root = map.get(i);
            } else {
                Node ptr = map.get(parent[i]);
                if (ptr.left != null) {
                    ptr.right = map.get(i);
                } else {
                    ptr.left = map.get(i);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] parent = new int[n + 1];
        parent[0] = -1;
        for (int i = 1; i < n + 1; i++) {
            parent[i] = scanner.nextInt();
        }

        Node root = createTree(parent);
        inorder(root);
        postorder(root);
        preorder(root);
        long sum = 0;
        for (int i = 0; i < inor.size(); i++) {
            Integer a = inor.get(i);
            Integer b = preorder.get(i);
            Integer c = postorder.get(i);
            sum += Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
        }
        System.out.println();
        System.out.println(inor);
        System.out.println(preorder);
        System.out.println(postorder);
    }
}