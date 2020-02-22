package com.concurrency.volatilestudy;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-22 10:52
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 不能保证多个线程共同修改一个值时所带来的不一致问题
 */
public class V1 {
    // volatile不能保证多个线程共同修改一个值时所带来的不一致问题，如下这种情况可能会出现重复加的情况
//    /*volatile*/ int count = 0;
    AtomicInteger count = new AtomicInteger(0);
    public /*synchronized*/ void method(){
        for (int i = 0; i < 10000; i++){
//            count++;
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        V1 v1 = new V1();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            threads.add(new Thread(v1::method, "thread" + i));
        }
        threads.forEach(Thread::start);
        threads.forEach(thread->{
            try {
                // join过后，主线程必须等其他线程执行完毕之后才能继续执行
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(v1.count);
    }
}
