package com.elite.old;

/*
 *
 Suppose you are given the following code:

class FootBall {
  public void foot() {
    for (int i = 0; i < n; i++) {
      print("foot");
    }
  }

  public void ball() {
    for (int i = 0; i < n; i++) {
      print("ball");
    }
  }
}
The same instance of FootBall will be passed to two different threads.
Thread A will call foot() while thread B will call ball().
Modify the given program to output "football" n times.



Example 1:

Input: n = 1
Output: "football"
Explanation: There are two threads being fired asynchronously.
One of them calls foot(), while the other calls ball(). "football" is being output 1 time.
Example 2:

Input: n = 2
Output: "footballfootball"
Explanation: "football" is being output 2 times.


 */


import java.util.Scanner;
import java.util.concurrent.Semaphore;

class FootBall {
    static int n = 1;
    Semaphore ball = new Semaphore(0);
    Semaphore foot = new Semaphore(0);
    int i = 0;
    Runnable f = () -> {
        while (i < n) {
            try {
                foot.acquire();
                System.out.print("foot");
                i++;
                ball.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    Runnable b = () -> {
        while (i < n) {
            try {
                ball.acquire();
                System.out.print("ball");
                foot.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public FootBall() {
        foot.release();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        FootBall fb = new FootBall();
        new Thread(fb.f).start();
        new Thread(fb.b).start();
        System.out.println(fb.foot.availablePermits());
    }


}
