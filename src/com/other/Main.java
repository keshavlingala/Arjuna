package com.other;

class XYZ {
    int A = 5;

    XYZ() {
//        ABC AB = new ABC();
    }
}

class ABC extends XYZ {
    int A = 7;

    ABC() {
//        System.out.println(A);
    }
}

public class Main {
    public static void main(String[] args) {
        XYZ AB = new ABC();
        System.out.println(AB.A);
    }
}
