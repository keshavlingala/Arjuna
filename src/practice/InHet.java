package practice;

import java.util.ArrayList;
import java.util.List;

interface DI {
    int asj();
}

public class InHet {
    public static void main(String[] args) {
        C o = new C();
        A a = new A();
        String s = "Hi";
        s = "High";
        String s1 = "High";
        System.out.println(s == s1);
        String s2 = "High";
        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        System.out.println(o.b);
        System.out.println(a.getB());
        List l = new ArrayList();
        Runnable r = () -> {
            System.out.println("Check");
        };
        Runnable g = new run();
        ArrayList<C> l1 = new ArrayList<C>();
        l1.add(o);
        l1.forEach(A::check);
    }
}

class run implements Runnable {
    @Override
    public void run() {
        System.out.println("Checked ");
    }
}

class A {
    private final int b = 10;

    void check() {
        System.out.println(b);
    }

    public int getB() {
        return b;
    }
}

class C extends A {
    int b = 20;

    void check() {
        System.out.println(b);
    }

    void check(int k) {

    }
}

abstract class D {
    int b = 10;
}