package com.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] temp = br.readLine().split(" ");
            int M = Integer.parseInt(temp[0]);
            int N = Integer.parseInt(temp[1]);
            int[] U = new int[M];
            int[] V = new int[M];
            int[] W = new int[N];
            int[] X = new int[N];

            for (int i = 0; i < M; i++) {
                temp = br.readLine().split(" ");
                U[i] = Integer.parseInt(temp[0]);
                V[i] = Integer.parseInt(temp[1]);
            }

            for (int i = 0; i < N; i++) {
                temp = br.readLine().split(" ");
                X[i] = Integer.parseInt(temp[0]);
                W[i] = Integer.parseInt(temp[1]);
            }
            temp = br.readLine().split(" ");
            int G = Integer.parseInt(temp[0]);
            int H = Integer.parseInt(temp[1]);

            String out_ = solve(X, U, W, V, G, H);
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static String solve(int[] X, int[] U, int[] W, int[] V, int G, int H) {
        int goods = 0;
        int greats = 0;
        for (int i = 0; i < U.length; i++) {
            int good = 0;
            int great = 0;
            for (int j = 0; j < W.length; j++) {
                if (U[i] == W[j]) {
                    good = 1;
                }
                if (V[i] == W[j]) {
                    great = 1;
                }
            }
            if (good == 1) {
                goods++;
            }
            if (good == 1 && great == 1) {
                greats++;
            }
        }
        System.out.println("Goods" + goods);
        System.out.println("Greats" + greats);
        if (goods >= G && greats >= H) {
            return "Great";
        } else if (goods >= G) {
            return "Good";
        } else {
            return ":(";
        }
    }
}