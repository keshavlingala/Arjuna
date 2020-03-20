package com.elite.old;

/*
Write fizz program that outputs the string representation of numbers from 1 to n, however:

If the number is divisible by 3, output "fizz".
If the number is divisible by 5, output "buzz".
If the number is divisible by both 3 and 5, output "fizzbuzz".
For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Suppose you are given the following code:

class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}
Implement fizz multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:

Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
Thread D will call number() which should only output the numbers.

Sample :
Input:  15
Output: 1
        2
        fizz
        4
        buzz
        fizz
        7
        8
        fizz
        buzz
        11
        fizz
        13
        14
        fizzbuzz

*/

import java.util.Scanner;

class FizzBuzz {
    int n = 1;
    int limit;

    public FizzBuzz(int limit) {
        this.limit = limit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FizzBuzz fb = new FizzBuzz(scanner.nextInt());
        new Thread(new One(fb)).start();
        new Thread(new Two(fb)).start();
        new Thread(new Three(fb)).start();
        new Thread(new Number(fb)).start();
    }

    public synchronized void fizz() {

        while (n <= limit) {
            if (n % 3 == 0 && n % 5 != 0) {
                System.out.println("fizz");
                n++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (n <= limit) {
            if (n % 5 == 0 && n % 3 != 0) {
                System.out.println("buzz");
                n++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (n <= limit) {
            if (n % 3 == 0 && n % 5 == 0) {
                System.out.println("fizzbuzz");
                n++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void number() {
        while (n <= limit) {
            if (n % 3 != 0 && n % 5 != 0) {
                System.out.println(n);
                n++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class One implements Runnable {
    FizzBuzz common;

    public One(FizzBuzz common) {
        this.common = common;
    }

    @Override
    public void run() {
        common.fizz();
    }
}

class Two implements Runnable {
    FizzBuzz common;

    public Two(FizzBuzz common) {
        this.common = common;
    }

    @Override
    public void run() {
        common.buzz();
    }
}

class Three implements Runnable {
    FizzBuzz common;

    public Three(FizzBuzz common) {
        this.common = common;
    }

    @Override
    public void run() {
        common.fizzbuzz();
    }
}

class Number implements Runnable {
    FizzBuzz common;

    public Number(FizzBuzz common) {
        this.common = common;
    }

    @Override
    public void run() {
        common.number();
    }
}