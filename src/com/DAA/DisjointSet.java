package com.DAA;

import java.io.*;
import java.util.*;

public class DisjointSet {
    public static void main(String[] args) throws IOException {
        int[][] a = new int[][]
                {
                        {1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
                };
        System.out.println("Number of Islands are: " + countIslands(a));
    }

    static int countIslands(int a[][]) {
        int colSize = a[0].length;
        int rowSize = a.length;
        int count = 0;
        DisjointUnionSets disjointSet = new DisjointUnionSets(colSize * rowSize);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (a[i][j] == 1) {
                    if (j + 1 < colSize && a[i][j + 1] == 1) {
                        disjointSet.union(i * colSize + j, i * colSize + (j + 1));
                    }
                    if (j - 1 > 0 && a[i][j - 1] == 1) {
                        disjointSet.union(i * colSize + j, i * colSize + (j - 1));
                    }
                    if (i + 1 < rowSize && a[i + 1][j] == 1) {
                        disjointSet.union(i * colSize + j, (i + 1) * colSize + j);
                    }
                    if (i - 1 > 0 && a[i - 1][j] == 1) {
                        disjointSet.union(i * colSize + j, (i - 1) * colSize + j);
                    }

                    if (j + 1 < colSize && i + 1 < rowSize && a[i + 1][j + 1] == 1) {
                        disjointSet.union(i * colSize + j, (i + 1) * colSize + (j + 1));
                    }
                    if (j - 1 > 0 && i - 1 > 0 && a[i - 1][j - 1] == 1) {
                        disjointSet.union(i * colSize + j, (i - 1) * colSize + (j - 1));
                    }
                    if (i + 1 < rowSize && j - 1 > 0 && a[i + 1][j - 1] == 1) {
                        disjointSet.union(i * colSize + j, (i + 1) * colSize + j - 1);
                    }
                    if (i - 1 > 0 && j + 1 < rowSize && a[i - 1][j + 1] == 1) {
                        disjointSet.union(i * colSize + j, (i - 1) * colSize + j + 1);
                    }
                }
            }
        }
        int noOfIslands = 0;
        int[] children = new int[rowSize * colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (a[i][j] == 1) {
                    int parent = disjointSet.find(i * colSize + j);
                    if (children[parent] == 0) {
                        noOfIslands++;
                        children[parent]++;
                    } else
                        children[parent]++;
                }
            }
        }
        return noOfIslands;
    }
}

class DisjointUnionSets {
    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n) {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }

    void makeSet() {
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return x;
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot)
            return;
        if (rank[xRoot] < rank[yRoot])
            parent[xRoot] = yRoot;
        else if (rank[yRoot] < rank[xRoot])
            parent[yRoot] = xRoot;
        else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
