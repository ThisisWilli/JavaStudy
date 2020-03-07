package com.study.designpattern.singletonpattern;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 20:59
 **/

public class LazyModeDCL {
    private volatile static LazyModeDCL lazyModeDCL;

    private LazyModeDCL() {
    }

    public LazyModeDCL getInstance(){
        if (lazyModeDCL == null){
            synchronized (LazyModeDCL.class){
                if (lazyModeDCL == null){
                    lazyModeDCL = new LazyModeDCL();
                }
            }
        }
        return lazyModeDCL;
    }
}
