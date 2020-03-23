package com.concurrency.threaddesignpattern.balking;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-23 10:41
 **/

public class Solution {
    private volatile boolean starting;

    public void start(){
        synchronized (this){
            if (starting){
                return;
            }
            starting = true;
        }
        // 启动真正的线程
    }
}
