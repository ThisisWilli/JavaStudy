package com.concurrency.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-02 11:51
 **/

public class CreateAQS {
    public static void main(String[] args) {
        MyLock lock = new MyLock();
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("locking...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                System.out.println("unlocking...");
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("locking...");
            }finally {
                System.out.println("unlocking...");
                lock.unlock();
            }
        }).start();
    }
}

// 自定义锁 不可重入锁
class MyLock implements Lock{

    /**
     * 锁大部分功能都是由同步器类来完成的
     * 实现一个独占锁，类似synchronized，reentrantLock
     */
    class MySync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)){
                // j加锁成功
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            setExclusiveOwnerThread(null);
            // 利用volatile的禁止指令重排序，让前面代码对属性的修改对其他线程可见
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        public Condition newCondition(){
            return new ConditionObject();
        }
    }

    private MySync sync = new MySync();

    // 加锁，不成功会进入等待队列
    @Override
    public void lock() {
        sync.acquire(1);
    }

    // 加锁，可打断
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    // 尝试加锁，只会尝试一次
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    // 带超时的尝试加锁
    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    // 创建一个条件变量
    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
