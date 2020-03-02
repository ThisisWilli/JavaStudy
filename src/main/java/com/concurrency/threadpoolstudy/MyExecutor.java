package com.concurrency.threadpoolstudy;

import java.util.concurrent.Executor;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-02 14:43
 **/

public class MyExecutor implements Executor {

    public static void main(String[] args) {
        new MyExecutor().execute(()->{
            System.out.println("hello command");
        });
    }

    @Override
    public void execute(Runnable command) {
        // 新起一个线程去调用这个方法
//        new Thread(command).run();
        // 调用run方法
        command.run();
    }
}
