package com.concurrency.synchronizedstudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-19 14:39
 **/

public class ObjectLock implements Runnable{
    // 让每个线程的锁都为同一个对象
    static ObjectLock objectLock = new ObjectLock();

    @Override
    public void run() {
        synchronized (ObjectLock.class){
            try {
                System.out.println(Thread.currentThread().getName() + "开始沉睡");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "结束");

        }
//        fun();
    }
    private synchronized static void fun(){
        System.out.println(Thread.currentThread().getName() + "在静态方法内使用类锁");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "结束了");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            new Thread(objectLock).start();
        }
    }
}
