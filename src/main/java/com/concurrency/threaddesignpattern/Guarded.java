package com.concurrency.threaddesignpattern;

import java.util.concurrent.TimeUnit;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-16 15:34
 **/

public class Guarded {
    // 线程一等待线程二的下载结果

    public static void main(String[] args) {
        GuardedObject guardedObject = new GuardedObject();
        new Thread(()->{
            Object o = guardedObject.get(2000);
            System.out.println("result =" + o.toString());
        },"t1").start();
        new Thread(()->{
            System.out.println("执行下载。。。");
            try {
                TimeUnit.SECONDS.sleep(1);
                guardedObject.complete("123");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}

class GuardedObject{
    private Object response;

    public Object get(long timeout){
        synchronized (this){
            try {
                long begin = System.currentTimeMillis();
                long passedTime = 0;
                while (response == null){
                    long waitTime = timeout - passedTime;
                    if (waitTime == 0){
                        break;
                    }
                    this.wait(waitTime);
                    passedTime = System.currentTimeMillis() - begin;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return response;
        }
    }

    public void complete(Object response){
        synchronized (this){
            if (this.response == null){
                this.response = response;
                this.notifyAll();
            }
        }
    }
}