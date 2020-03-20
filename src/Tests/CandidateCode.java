package Tests;

import java.io.*;
import java.util.*;

public class CandidateCode {
    public static void main(String args[]) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Node(i + 1));
        }
        Node root = list.get(0);
        for (int i = 0; i < n - 1; i++) {
            Node x = list.get(scanner.nextInt() - 1);
            Node y = list.get(scanner.nextInt() - 1);
            x.addChild(y);
        }
        List<String> result = new ArrayList();
        for (Node node : list) {
            result.add(""+findLeafs(node));
        }
        System.out.print(String.join(" ", result));
    }

    static int findLeafs(Node node) {
        int count = 0;
        if (node.isLeaf()) {
            return 1;
        }
        for (Node temp : node.childs) {
            count += findLeafs(temp);
        }
        return count;
    }
}

class Node {
    int data;
    ArrayList<Node> childs;

    Node(int item) {
        data = item;
        childs = new ArrayList<>();
    }

    void addChild(Node n) {
        childs.add(n);
    }

    boolean isLeaf() {
        return childs.isEmpty();
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", childs=" + childs +
                '}';
    }
}
