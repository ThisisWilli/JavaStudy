package com.study.designpattern.singletonpattern;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 20:37
 **/

public class LazyMode {

    private static LazyMode lazyMode;

    private LazyMode(){

    }

    public LazyMode getInstance(){
        if (lazyMode == null){
            lazyMode = new LazyMode();
        }
        return lazyMode;
    }
}
