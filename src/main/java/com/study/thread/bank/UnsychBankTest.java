package com.study.thread.bank;

/**
 * \* project: JavaStudy
 * \* package: com.study.thread.bank
 * \* author: Willi Wei
 * \* date: 2019-12-28 11:12:11
 * \* description:有可能几个账户同时有钱进账，当两个线程试图同时更新一个账户，就会出现问题
 * \
 */
public class UnsychBankTest {
    public static final int NACCOUNTS = 100;
    public static final double INITIAL_BALANCE = 1000;
    public static final double MAX_AMOUNT =1000;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        for (int i = 0; i < NACCOUNTS; i++){
            int fromAccount = i;
            // 实现run方法
            Runnable r = ()->{
                try {
                    while(true){
                        int toAccount = (int) (bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}