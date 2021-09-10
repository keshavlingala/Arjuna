package com.arjuna.season18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PhotoFrames {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfFrames = scanner.nextInt();
        int noOfFriends = scanner.nextInt();

        ArrayList<Integer> costOfFramesList = new ArrayList<>();
        for (int i = 0; i < noOfFrames; i++) {
            costOfFramesList.add(scanner.nextInt());
        }
        int totalCost = 0;
        List<Friend> friends = new ArrayList<Friend>();
        for (int i = 0; i < noOfFriends; i++) {
            friends.add(new Friend(i));
        }

        for (int i = 0; i < noOfFrames / noOfFriends + 1; i++) {
            for (Friend f : friends) {
                if (costOfFramesList.isEmpty()) {
                    System.out.println(totalCost);
                    return;
                }
                int currmax = Collections.max(costOfFramesList);
                totalCost += f.buy(currmax);
                costOfFramesList.remove(costOfFramesList.indexOf(currmax));
            }
        }
    }
}

class Friend {
    private int previousPusrchases;
    private int id;

    public Friend(int id) {
        this.id = id;
        previousPusrchases = 0;
    }

    public int buy(int actualCost) {
        int boughtCost = (previousPusrchases + 1) * actualCost;
        previousPusrchases++;
        return boughtCost;
    }

    @Override
    public String toString() {
        return "Friend: " + id + " Previous Purchases: " + previousPusrchases;
    }
}
