package com.concurrency.threaddesignpattern.alternatelyprint;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-22 13:42
 **/

public class UseParkUnpark {

    static Thread a;
    static Thread b;
    static Thread c;
    public static void main(String[] args) {
        ParkUnpark pu = new ParkUnpark(5);
        a = new Thread(() -> {
            pu.print("a", b);
        });

        b = new Thread(() -> {
            pu.print("b", c);
        });

        c = new Thread(() -> {
            pu.print("c", a);
        });
        a.start();
        b.start();
        c.start();

        LockSupport.unpark(a);
    }

}

class ParkUnpark{
    private int loopNumber;

    public void print(String str, Thread next){
        for (int i= 0; i < loopNumber; i++){
            LockSupport.park();
            System.out.println(str);
            LockSupport.unpark(next);
        }
    }

    public ParkUnpark(int loopNumber) {
        this.loopNumber = loopNumber;
    }
}
