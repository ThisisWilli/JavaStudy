package com.concurrency.threadpoolstudy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-30 10:56
 **/

public class CreateAThreadpool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(2, 1000, TimeUnit.MILLISECONDS, 1, ((queue, task) -> {
            // 死等
            //queue.put(task);
             queue.offer(task, 1000, TimeUnit.MILLISECONDS); // 在一段时间内尝试将任务放入等待队列
//            System.out.println("give up...");
//            new Thread(task, "救火队员").start();
        }));
        for (int i = 0; i < 5; i++) {
            int j = i;
            threadPool.execute(()->{
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + j);
            });
        }
    }
}

class ThreadPool{

    // 任务队列
    private BlockQueue<Runnable> taskQueue;

    // 任务集合
    private HashSet<Worker> workers = new HashSet<>();

    // 核心线程数
    private int coreSize;

    // 获取任务的超时时间
    private long timeout;

    private TimeUnit timeUnit;

    private RejectPolicy<Runnable> rejectPolicy;

    public ThreadPool(int coreSize, long timeout, TimeUnit timeUnit, int queueCapcity, RejectPolicy<Runnable> rejectPolicy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockQueue<>(queueCapcity);
        this.rejectPolicy = rejectPolicy;
    }


    class Worker extends Thread{
        private Runnable task;
        public Worker(Runnable task) {
            this.task = task;
        }

        @Override
        public void run() {
            // 当task不为空，执行任务
            // 当task执行完毕，在接着看任务队列中是否有任务，有则获取任务并执行
//            while (task != null || (task = taskQueue.take()) != null){
            while (task != null || (task = taskQueue.poll(timeout, timeUnit)) != null){
                try{
                    System.out.println(Thread.currentThread().getName() + "正在执行：" + task);
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task = null;
                }
            }

            // 主线程会拿到锁
            synchronized (workers){
                System.out.println("worker被移除" + this);
                workers.remove(this);
            }
        }
    }



    // 执行任务
    public void execute(Runnable task){
        synchronized (workers){
            // 任务数没有超过coreSize时，直接交给worker对象执行
            if (workers.size() < coreSize){
                System.out.println("新增一个worker: " + workers + " " + task);
                Worker worker = new Worker(task);
                workers.add(worker);
                // 启动线程
                worker.start();
            }else {
                // 如果超过则交给bk
                System.out.println(Thread.currentThread().getName() + "将" + task + "加入任务队列：" );
//                taskQueue.put(task);
                taskQueue.tryPut(rejectPolicy, task);
            }
        }
    }
}


@FunctionalInterface
interface RejectPolicy<T>{
    void reject(BlockQueue<T> queue, T task);
}


class BlockQueue<T>{
    // 1.任务队列
    private Deque<T> queue = new ArrayDeque<>();

    // 2.锁
    private ReentrantLock lock = new ReentrantLock();

    // 3.生产者条件变量，消费者条件变量
    private Condition fullWaitSet = lock.newCondition();

    // 4.消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    // 5.容量
    private int capcity;

    public BlockQueue(int queueCapcity) {
        this.capcity = queueCapcity;
    }

    // 6.阻塞获取，消费者从队列中去拿任务
    public T take(){
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signalAll();
            return t;
        }finally {
            lock.unlock();
        }
    }

    // 带超时的阻塞获取，虚假唤醒，消费者从队列中去拿数据
    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (queue.isEmpty()){
                try {
                    if (nanos <= 0){
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = queue.removeFirst();
            fullWaitSet.signalAll();
            return t;
        }finally {
            lock.unlock();
        }
    }

    // 生产者往集合中去放数据
    public void put(T task){
        lock.lock();
        try {
            while (queue.size() == capcity){
                try {
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.addLast(task);
            emptyWaitSet.signalAll();
        }finally {
            lock.unlock();
        }
    }

    // 带超时阻塞时间添加，生产者往队列中生产数据
    public boolean offer(T task, long timeout, TimeUnit timeUnit){
        lock.lock();
        try {
            long nanos = timeUnit.toNanos(timeout);
            while (queue.size() == capcity){
                try {
                    System.out.println("等待加入任务队列" + task);
                    if (nanos <= 0){
                        return false;
                    }
                    nanos = fullWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("加入任务队列" + task);
            queue.addLast(task);
            emptyWaitSet.signalAll();
            return true;
        }finally {
            lock.unlock();
        }
    }

    // 7.获取大小
    public int size(){
        lock.lock();
        try {
            return queue.size();
        }finally {
            lock.unlock();
        }
    }

    // 任务数已经超过coreSize，需要将任务放入任务队列中，生产者将任务放入队列中
    public void tryPut(RejectPolicy<T> rejectPolicy, T task){
        lock.lock();
        try {
            // 判断队列是否满
            if (queue.size() == capcity){
                rejectPolicy.reject(this, task);
            }else {
                // 有空闲
                System.out.println("加入任务队列" + task);
                queue.addLast(task);
                emptyWaitSet.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }
}
