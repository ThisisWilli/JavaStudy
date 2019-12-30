package com.study.thread.bank.synch2;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.bank.synch2
 * \* author: Willi Wei
 * \* date: 2019-12-28 21:42:18
 * \* description:
 * \
 */
public class Bank {
    private final double[] accounts;

    /**
     * 创建银行实例
     * @param n
     * @param initialBalance
     */
    public Bank(int n, double initialBalance) {
        this.accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * 账户之间互相转账
     * @param from
     * @param to
     * @param amount
     */
    public synchronized void transfer(int from, int to, double amount) throws InterruptedException {
        while (accounts[from] < amount){
            wait();
        }
        System.out.println(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d", amount, from, to);
        accounts[to] += amount;
        System.out.printf("Total Balance: %10.2f%n", getTotalBalance());
    }

    /**
     * 统计银行中所有账户的余额总额
     * @return
     */
    public double getTotalBalance(){
        double sum = 0;
        for(double a : accounts){
            sum += a;
        }
        return sum;
    }

    /**
     * 返回银行中的账户总额
     * @return
     */
    public int size(){
        return accounts.length;
    }
}