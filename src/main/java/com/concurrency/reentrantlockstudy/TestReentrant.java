package com.concurrency.reentrantlockstudy;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-21 13:38
 **/

public class TestReentrant {
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        try {
            lock.lock();
            System.out.println("enter main");
            m1();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void m1(){
        try {
            lock.lock();
            System.out.println("enter m1");
            m2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void m2(){
        try {
            lock.lock();
            System.out.println("enter m2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
