package com.concurrency.threadpoolstudy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-02 15:39
 **/

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
    }
}
