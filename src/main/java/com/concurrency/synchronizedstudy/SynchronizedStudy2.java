package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-19 13:01
 **/

public class SynchronizedStudy2 {
    private int count = 0;

    // 等同于在方法代码执行时要synchronized(this)，执行代码时锁定当前对象
    public synchronized void m(){
        count++;
        System.out.println(Thread.currentThread().getName() + " count = " + count);
    }
}
