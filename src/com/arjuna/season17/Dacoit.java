package com.arjuna.season17;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dacoit {
    public static boolean listContained(List<Road> roadList, Road road) {
        for (Road r : roadList) {
            if (r.isEqual(road)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int noOfVillages = scanner.nextInt();
        List<Village> villageList = new ArrayList<Village>();
//        creating n number of village objects
        for (int i = 0; i < noOfVillages; i++) {
            villageList.add(new Village(Integer.toString(i + 1)));
        }
        int noOfMainRoads = scanner.nextInt();
        List<Road> roadsList = new ArrayList<Road>();
//        taking all the main road connections
        for (int i = 0; i < noOfMainRoads; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
//            marking main roads length as 900
//            as we are calculating shortest paths assuming mainroads and very long should ignore the road condition
            roadsList.add(new Road(900, villageList.get(a), villageList.get(b)));
        }
//        All possible connecctions to all villages - ( main road connections)
        for (int i = 0; i < noOfVillages; i++) {
            for (int j = 0; j < noOfVillages; j++) {
                if (i == j) continue;
//                chosing kacha road length as 1
                Road r = new Road(1, villageList.get(i), villageList.get(j));
//                if this is already a main road
                if (listContained(roadsList, r)) continue;
                roadsList.add(r);
            }
        }
//        path from which the dacoit escaped
//        indexing from 0 so 1st village is 0th village
        int chooseStartingVillage = scanner.nextInt() - 1;
        for (int i = 0; i < villageList.size(); i++) {
            Logic logic = new Logic(villageList, roadsList);
//           if it tries to calculate the shortest path to itself the skipping the step
            if (chooseStartingVillage == i) continue;
//            printing the shortest paths from the remaining villages in order with a space
            System.out.print(logic.shortestPath(villageList.get(chooseStartingVillage), villageList.get(i)) + " ");
        }
    }
}

// created a village class for the which we create that many number of village objects in the main program
class Village {
    private String name;
    private boolean visited = false;
    private List<Village> adjacenciesList;
    private int minDistance = 900;
    private Village previousVertex;

    // most of the methods and variables are defined for fine understanding and easy debugging
//  this is an abstract class for which i pesonally use for all shortest path problems to reduce complexity
    @Override
    public String toString() {
        return name + "Min Dist: " + minDistance;
    }

    // getters and setters some of them are not used but i prefer not to remove them
    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setAdjacenciesList(List<Village> adjacenciesList) {
        this.adjacenciesList = adjacenciesList;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public void setPreviousVertex(Village previousVertex) {
        this.previousVertex = previousVertex;
    }

    public Village(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    public void addEdge(Village Village) {
        this.adjacenciesList.add(Village);
    }


    public List<Village> getAdjacenciesList() {
        return adjacenciesList;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public Village getPreviousVertex() {
        return previousVertex;
    }
}

// created a road class that hold or joins the two vilages which containes of two Village class object refereces
// and holds the weight of the path or the road distance in real life
class Road {
    private int weight;
    private Village startVertex;
    private Village targetVertex;

    public Road(int weight, Village startVertex, Village targetVertex) {
        this.weight = weight;
        this.startVertex = startVertex;
        this.targetVertex = targetVertex;
    }

    // to check if two road objects are same or not
//    if they share same starting and ending point then the road referes to same even thought they don't share same memory ( why list.containes(road)) dont' work? )
//    simple just comparing
    public boolean isEqual(Road r) {
        if (this.targetVertex == r.targetVertex && this.startVertex == r.startVertex || this.targetVertex == r.startVertex && this.startVertex == r.targetVertex) {
            return true;
        } else {
            return false;
        }
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Village getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Village startVertex) {
        this.startVertex = startVertex;
    }

    public Village getTargetVertex() {
        return targetVertex;
    }

    public void setTargetVertex(Village targetVertex) {
        this.targetVertex = targetVertex;
    }

    public String toString() {
        return startVertex.getName() + "-" + targetVertex.getName() + " Weight: " + this.weight;
    }
}

// My Algorithm Inspired from BellMan ford Algorithm to find single source shortest path using dots and lines with negative weights acceptable
class Logic {
    private List<Village> villageList;
    private List<Road> roadList;

    //    algorithm is constructed with initializing the villages dots list references and roadlist references to be used in shortest path class
    public Logic(List<Village> villageLis, List<Road> roadList) {
        this.villageList = villageLis;
        this.roadList = roadList;
    }

    //    finding the shortest path from two willages
//    taking start and end village reference objects
    public int shortestPath(Village startVillage, Village targetVillage) {
//        setting the initial point 's minimum distance to zera
        startVillage.setMinDistance(0);
//        accourting to bellman ford if there are n number of dots then n-1 iterations to be done to find the minimum distances of every dot from one initial dot
        int length = this.villageList.size();
//        looping n-1 times
        for (int i = 0; i < length - 1; i++) {
//            looping through all the roads and mark the minimum distances of all the possible points
            for (Road road : roadList) {


//                if the road is a main road then skip the path
                if (road.getWeight() == 900)
                    continue; //why 900 ? : just a random hightest number as a minimum distance and same 900 is used as a mix number
                Village v = road.getStartVertex();
                Village u = road.getTargetVertex();
//                if the newly went path is less than the path it used to be the update the min distance of the reached vertex
                int newLengtha = v.getMinDistance() + road.getWeight();
                if (newLengtha < u.getMinDistance()) {
                    u.setMinDistance(newLengtha);
                    u.setPreviousVertex(v);
                }
                int newLengthb = u.getMinDistance() + road.getWeight();
                if (newLengthb < v.getMinDistance()) {
                    v.setMinDistance(newLengthb);
                    v.setPreviousVertex(v);
                }
            }
        }
//        finally return the minimum distance
        return targetVillage.getMinDistance();
    }
}