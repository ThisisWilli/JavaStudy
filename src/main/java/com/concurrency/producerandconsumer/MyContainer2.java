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

    private ReentrantLock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();
    private LinkedList<T> lists = new LinkedList<>();
    private final static int MAX = 10;
    private int count = 0;


    // producer先成产，生产完之后提醒consumer开始工作
    private void put(T t){
        // 先拿锁
        try {
            // producer先拿锁
            lock.lock();
            // 要注意container中可能已经满了的情况
            while (lists.size() == MAX){
                // prodcuer线程进入condition队列等待
                producer.await();
            }
            lists.add(t);
            count++;
            // 注意不是notify而是signalAll
            consumer.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // consumer先消费，消费完之后提醒producer开始生产
    private T get(){
        T t = null;
        // consumer先拿锁
        try {
            lock.lock();
            while (lists.size() == 0){
                // 容器容量为0，consumer进入condition队列等待，避免拿空
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
