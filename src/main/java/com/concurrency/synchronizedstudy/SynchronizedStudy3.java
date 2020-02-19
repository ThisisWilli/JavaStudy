package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-19 13:07
 **/

public class SynchronizedStudy3 {
    public static int count = 0;
    public synchronized static void m(){
        count++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }

    public synchronized static void mm(){
        synchronized (SynchronizedStudy3.class){
            count++;
        }
    }
}
