package com.arjuna.season18;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pandavas {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfAllies = scanner.nextInt();
        int noOfPairs = scanner.nextInt();
        List<Integer> goldRequestedList = new ArrayList<Integer>();
        for (int i = 0; i < noOfAllies; i++) {
            goldRequestedList.add(scanner.nextInt());
        }
    }
}

class KingDom {
    private int minrequested;
    private List<Integer> allies;
    private List<Integer> goldRequested;

    public KingDom(List<Integer> allies, List<Integer> goldRequested) {
        this.allies = allies;
        this.goldRequested = goldRequested;
    }

    public void addKingDom(int allie) {
        allies.add(allie);

    }

    public boolean contains(int allie) {
        if (allies.contains(allie)) {
            return true;
        } else return false;
    }
}