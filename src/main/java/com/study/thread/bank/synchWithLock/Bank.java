package com.study.thread.bank.synchWithLock;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.bank.synchWithLock
 * \* author: Willi Wei
 * \* date: 2019-12-28 11:33:09
 * \* description:引入了重入锁(reentrant)，线程可以重复获得已拥有的锁，线程每次调用了lock都要调用unlock来释放锁，
 *                1、避免一个线程再对一个账户进行操作时，另一个线程也对账户进行操作，余额会出错
 *                2、账户中余额不足，需要等待另一个线程转账，因为这个线程刚刚获得了对banklock的排他性访问权，因此别的线程没有存款的机
 *                会。这个就要引入条件对象
 *
 *                条件对象，线程进入临界区后却发现只有满足某个条件之后才能执行，可以使用一个条件对象来管理那些已经获得了锁但却没有办法
 *                工作的线程，--->成为条件对象
 * \
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;
    /**
     * 创建银行实例
     * @param n
     * @param initialBalance
     */
    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        // 创建一个重入锁
        bankLock = new ReentrantLock();
        // 一个锁对象可以拥有多个相关联的条件对象
        sufficientFunds = bankLock.newCondition();
    }

    /**
     * 账户之间互相转账
     * @param from
     * @param to
     * @param amount
     */
    public void transfer(int from, int to, double amount){
        bankLock.lock();
        try {
            while (accounts[from] < amount){
                // 当前线程暂停，并放弃锁，就允许另外一个线程执行，增加账户的余额
                sufficientFunds.await();
            }
            System.out.println(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total Balance %10.2f%n", getTotalBalance());
            // 让转账线程重新转账
            // 这个调用激活等待这个条件的所有线程，当这些线程从等待中移出时，他们再次成为可运行的线程，调度器再次将他们激活。同时，他们
            // 会尝试重新进入对象，一旦锁可用，他们的其中一个线程将从await调用返回，得到这个锁，并从之前暂停的地方继续执行
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bankLock.unlock();
        }
    }

    /**
     * 统计银行中所有账户的余额总额
     * @return
     */
    public double getTotalBalance(){
        bankLock.lock();
        try {
            double sum = 0;
            for(double a : accounts){
                sum += a;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }

    /**
     * 返回银行中的账户总额
     * @return
     */
    public int size(){
        return accounts.length;
    }
}