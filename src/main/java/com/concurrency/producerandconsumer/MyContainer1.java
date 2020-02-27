package com.concurrency.producerandconsumer;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-27 13:51
 **/

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个容器该容器拥有put和get以及getCount方法，能够支持2个生产者线程和10个消费者线程阻塞调用
 * 注意，wait一定要和while一起配合使用，notify()一定不能用，要用notifyAll()
 */

public class MyContainer1<T> {
    final private LinkedList list = new LinkedList();
    final private static int MAX = 10;
    private int count = 0;
    /**
     * 加入生产者，相当于生产者程序，是往里面放的
     */
    private synchronized void put(T t){
        while (list.size() == MAX){
            try {
                // 注意wait会释放锁
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(t);
        count++;
        // 通知消费者线程进行消费
        this.notifyAll();
    }

    /**
     * 从中取得一个消费者，相当于消费者程序，需要注意容器为空的情况
     * @return
     */
    private synchronized T get(){
        T t = null;
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = (T) list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    private synchronized int getCount(){
        return count;
    }

    public static void main(String[] args) {
        MyContainer1<String> c = new MyContainer1<>();
        // 启动消费者线程
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                for (int j = 0; j < 5; j++){
                    c.get();
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 启动生产者线程
        for (int i = 0; i < 2; i++){
            new Thread(()->{
                for (int j = 0; j < 25; j++){
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }
    }
}
