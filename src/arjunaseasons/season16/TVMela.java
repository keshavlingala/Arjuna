package com.arjuna.season16;

import java.util.ArrayList;
import java.util.Scanner;

public class TVMela {


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int TvsWithMechanic = scanner.nextInt();
        int noOfOffers = scanner.nextInt();
        ArrayList<Integer> mechanicworth = new ArrayList<Integer>();
        ArrayList<Offer> offers = new ArrayList<Offer>();
        for (int i = 0; i < TvsWithMechanic; i++) {
            mechanicworth.add(scanner.nextInt());
        }
        for (int i = 0; i < noOfOffers; i++) {
            offers.add(new Offer(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        }
//        System.out.println(mechanicworth.toString());
//        System.out.println(offers.toString());

        //algorithm starts from here
        int MaxValue = 0;
        for (int day = 1; day <= offers.get(offers.size() - 1).getDay(); day++) {

            ArrayList<Offer> offersinaday = new ArrayList<Offer>();
            for (Offer offer : offers) {
                if (offer.getDay() == day) {
                    offersinaday.add(offer);
                }
            }
//            System.out.println("Offers in a Day= "+offersinaday.toString());
            for (int i = 0; i < mechanicworth.size(); i++) {
                int valueschanged = 1;
                for (int k = 0; k < valueschanged; k++) {
                    for (int j = 0; j < offersinaday.size(); j++) {
                        if (mechanicworth.get(i).equals(offersinaday.get(j).getA()) || mechanicworth.get(i).equals(offersinaday.get(j).getB())) {
                            //if offer had a match of pair mechanic had
                            //if it worth more then replace else move on
//                            System.out.println("i= " + i + " j= " + j + " " + offersinaday.get(j));
                            int mechanicHad = mechanicworth.get(i);
                            int offerprice = mechanicworth.get(i).equals(offersinaday.get(j).getA()) ? offersinaday.get(j).getB() : offersinaday.get(j).getA();
//                            System.out.println("Mech had " + mechanicHad + " offer  Price= " + offerprice);
                            if (mechanicHad <= offerprice) {
                                mechanicworth.set(i, offerprice);
                                //Machanic Replaced Item
                                valueschanged++;
                            }
                        }
                    }
                }
            }
//            System.out.println("Finally Mechaniv had" + mechanicworth.toString());


            offersinaday.clear();
        }
        //Allgorithm Ends Here

        //caculateing total worth of mechanic
        int TotalWorth=0;
        for(int i=0;i<mechanicworth.size();i++){
            TotalWorth+=mechanicworth.get(i);
        }
        System.out.println(TotalWorth);


    }
}

class Offer {
    private int day;
    private int A;
    private int B;

    public int getDay() {
        return day;
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setA(int a) {
        A = a;
    }

    public void setB(int b) {
        B = b;
    }

    public Offer(int day, int a, int b) {
        this.day = day;
        A = a;
        B = b;
    }

    @Override
    public String toString() {
        return "" + day + " " + A + " " + B;
    }
}