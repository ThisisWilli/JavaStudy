package com.concurrency.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-26 11:27
 **/

public class StudyAtomicStampedReference {
    static AtomicStampedReference<String> ref = new AtomicStampedReference<>("A", 0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main start...");
        // 获取值 A
        String prev = ref.getReference();
        // 获取版本号
        int stamp = ref.getStamp();
        System.out.println("版本 = " + stamp);
        // 如果中间有其它线程干扰，发生了 ABA 现象
        other();
        Thread.sleep(2000);
        // 尝试改为 C
        System.out.println("change A->C  " + ref.compareAndSet(prev, "C", stamp, stamp + 1));
    }

    private static void other() throws InterruptedException {
        new Thread(() -> {
            System.out.println("change A->B   " +  ref.compareAndSet(ref.getReference(), "B", ref.getStamp(), ref.getStamp() + 1));
            System.out.println("更新版本为 " + ref.getStamp());
        }, "t1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            System.out.println("change B->A  " + ref.compareAndSet(ref.getReference(), "A", ref.getStamp(), ref.getStamp() + 1));
            System.out.println("更新版本为 " +  ref.getStamp());
        }, "t2").start();
    }
}
