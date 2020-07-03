package com.concurrency.producerandconsumer;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * \* project: JavaStudy
 * \* package: com.concurrency.producerandconsumer
 * \* author: Willi Wei
 * \* date: 2020-07-03 19:49:36
 * \* description:
 * \
 */
public class UseSynchronized<T> {

    final LinkedList<T> blockingQueue = new LinkedList<>();
    final int queueSize = 10;

    /**
     * 生产者向队列中放置泛型T，需要判断队列是否为满，如果队列是满的，那么对象需要wait
     * @param t
     */
    public synchronized void put(T t){
        while (blockingQueue.size() >= 10){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        blockingQueue.addLast(t);
        this.notifyAll();
    }

    public synchronized T get(){

        while (blockingQueue.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T t = blockingQueue.removeFirst();
        this.notifyAll();
        return t;
    }

    private synchronized int getCount(){
        return blockingQueue.size();
    }

    public static void main(String[] args) throws InterruptedException {
        UseSynchronized<String> useSynchronized = new UseSynchronized<>();

        // 消费者线程
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    String s = useSynchronized.get();
                    if (useSynchronized.getCount() > 10){
                        System.out.println("错误");
                    }
//                    System.out.println(s);
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(3);

        // 生产者线程
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    useSynchronized.put(Thread.currentThread().getName());
                    if (useSynchronized.getCount() > 10){
                        System.out.println("错误");
                    }
                }
            }).start();
        }

    }
}