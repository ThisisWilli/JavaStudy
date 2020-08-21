package com.concurrency.readwritelock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.readwritelock
 * \* author: Willi Wei
 * \* date: 2020-08-21 11:33:41
 * \* description:
 * \
 */
public class StudyReadWriteLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReadThread rt1 = new ReadThread("rt1", lock);
        ReadThread rt2 = new ReadThread("rt1", lock);
        WriteThread wt1 = new WriteThread("rt2", lock);
        rt1.start();
        rt2.start();
        wt1.start();
    }
}
class ReadThread extends Thread{
    private ReentrantReadWriteLock rrwLock;

    public ReadThread(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " try to lock");
            rrwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "lock successfully");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rrwLock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}

class WriteThread extends Thread{
    private ReentrantReadWriteLock rrwLock;

    public WriteThread(String name, ReentrantReadWriteLock rrwLock) {
        super(name);
        this.rrwLock = rrwLock;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " try to lock");
            rrwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "lock successfully");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rrwLock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock successfully");
        }
    }
}