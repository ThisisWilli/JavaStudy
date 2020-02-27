package com.concurrency.producerandconsumer;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-27 16:57
 **/

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 上一道题，能够配合reentrantlock + Condition来实现，可以精确指定哪些线程被叫醒
 */
public class MyContainer2 <T>{
    final private LinkedList<T> lists = new LinkedList<>();
    private static int MAX = 10;
    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    private void put(T t){
        try {
            lock.lock();
            while (lists.size() == MAX){
                // 容器是满的，生产者先不要生产
                producer.await();
            }
            lists.add(t);
            count++;
            // 容器中已经被新加进去东西，消费者赶紧来消费
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private T get(){
        T t = null;
        try {
            lock.lock();
            while (lists.size() == 0){
                consumer.await();
            }
            t = lists.removeFirst();
            count--;
            producer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return t;
    }

    public static void main(String[] args) {
        MyContainer2<String> c = new MyContainer2<>();

        // 生产者系统启动
        for (int i = 0; i < 10; i++){
            new Thread(()->{
                for (int j = 0; j < 5; j++){
                    System.out.println(c.get());
                }
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 消费者线程启动
        for (int i = 0; i < 2; i++){
            new Thread(()->{
                for (int j = 0; j < 25; j++){
                    c.put(Thread.currentThread().getName() + " " + j);
                }
            }, "p" + i).start();
        }

    }
}
