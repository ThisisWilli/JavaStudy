package com.concurrency.reentrantlockstudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-21 14:26
 **/

public class SolvePhilosophy {
    public static void main(String[] args) {
        Chopsticks c1 = new Chopsticks("c1");
        Chopsticks c2 = new Chopsticks("c2");
        Chopsticks c3 = new Chopsticks("c3");
        Chopsticks c4 = new Chopsticks("c4");
        Chopsticks c5 = new Chopsticks("c5");


        new Philosopher("一号", c1, c2).start();
        new Philosopher("二号", c2, c3).start();
        new Philosopher("三号", c3, c4).start();
        new Philosopher("四号", c4, c5).start();
        new Philosopher("五号", c5, c1).start();
    }
}

class Philosopher extends Thread{
    Chopsticks left;
    Chopsticks right;

    public Philosopher(String name, Chopsticks left, Chopsticks right){
        super(name);
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true){
            if (left.tryLock()){
                try {
                    if (right.tryLock()){
                        try {
                            eat();
                        }finally {
                            right.unlock();
                        }
                    }
                }finally {
                    left.unlock();
                }
            }
        }
    }

    public void eat(){
        try {
            System.out.println(Thread.currentThread().getName() + " eating..");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Chopsticks extends ReentrantLock {
    String name;

    public Chopsticks(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chopsticks{" +
                "name='" + name + '\'' +
                '}';
    }
}