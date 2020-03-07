package com.study.designpattern.singletonpattern;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 20:47
 **/

public class LazyModeSingleLock {
    private static LazyModeSingleLock lazyModeSingleLock;

    private LazyModeSingleLock() {

    }

    public synchronized  LazyModeSingleLock getInstance(){
        if (lazyModeSingleLock == null){
            lazyModeSingleLock = new LazyModeSingleLock();
        }
        return lazyModeSingleLock;
    }
}
