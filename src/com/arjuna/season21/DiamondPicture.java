package com.arjuna.season21;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//friend class with name ,visited and his friends circle
class Friend {
    int name;
    boolean visited = false;
    List<Link> friendLinks;

    //    to string for debugging puspose
    @Override
    public String toString() {
        return "Friend{" +
                "name=" + name +
                ", visited=" + visited +
                '}';
    }

    //    just after creating a friend create a friend's link circle for him
    Friend(int name) {
        this.name = name;
        friendLinks = new ArrayList<>();
    }

    //    visited him
    public void setvisited() {
        this.visited = true;
    }

    //adding new friend to his friends list
    void addFriend(Link link) {
        this.friendLinks.add(link);
    }
}

//link class is edge in the graph with two friends at both ends with their bond length
class Link {
    Friend f1;
    Friend f2;
    int bondLength;


    @Override
    public String toString() {
        return "Link{" +
                "f1=" + f1 +
                ", f2=" + f2 +
                ", bondLength=" + bondLength +
                '}';
    }

    //    creating a link with constructor
    public Link(Friend f1, Friend f2, int bondLength) {
        this.f1 = f1;
        this.f2 = f2;
        this.bondLength = bondLength;
//        with this link both are friends so both friends have this link in their circle
//        this means the current link object storing in friend's circle list
        f1.addFriend(this);
        f2.addFriend(this);
    }

    public Friend getF1() {
        return f1;
    }

    public Friend getF2() {
        return f2;
    }
}

class DiamondPicture {
    static ArrayList<Friend> friends;
    static ArrayList<Link> links;
    static int maxBondLength;
    static int count = 0;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfFriends = scanner.nextInt();
        int noOfLinks = scanner.nextInt();

        //creating friend objects of given size
        friends = IntStream.range(0, noOfFriends).mapToObj(i -> new Friend(i + 1)).collect(Collectors.toCollection(ArrayList::new));
        //initializing friendlinks list
        links = new ArrayList<>();

        //storing link objects to links ArrayList above declared
        IntStream.range(0, noOfLinks).forEach(i -> links.add(new Link(friends.get(scanner.nextInt() - 1), friends.get(scanner.nextInt() - 1), scanner.nextInt())));

        //no of frnds aditi shown the pic to
        int aditiTold = scanner.nextInt();

        //bond strength of the friend with whom aditi told to (or) the secrete strength
        maxBondLength = scanner.nextInt();

        //for each friend aditi told the news spread to many friends which is spreaded by method sharePic
        for (int i = 0; i < aditiTold; i++) {
            sharePic(scanner.nextInt() - 1);
        }
//        count is no of friends got to know the pic or is visited
//        count value is changed in the method called above
        System.out.println(count);
    }

    private static void sharePic(int fIndex) {
        //if she told someone then that person has known so count ++
        friends.get(fIndex).setvisited();
        count++;
//        now that friend also got a friend circle adding that circle links to queue
        LinkedList<Link> queue = new LinkedList<>(friends.get(fIndex).friendLinks);

//        while queue links no empty run the loop
        while (!queue.isEmpty()) {
//            if the link's bond length is lesser than the maxbond length then go inside else pop that link of the queue
            if (queue.peek().bondLength <= maxBondLength) {
//                in a link there are 2 friends on both sides so if the friend is not visited already then go to that friend
                if (!queue.peek().getF1().visited) {
//                    now set that friend as visited and add all his friend circle to the queue
                    queue.peek().getF1().setvisited();
                    count++;
//                    no of friends known + 1
                    queue.addAll(queue.peek().getF1().friendLinks);
                }
//                same as above with the other side of the friend
                if (!queue.peek().getF2().visited) {
                    queue.peek().getF2().setvisited();
                    count++;
                    queue.addAll(queue.peek().getF2().friendLinks);
                }
//                after traversing both ends of the link pop it from the queue
                queue.pop();
            } else
                queue.pop();
        }
    }
}