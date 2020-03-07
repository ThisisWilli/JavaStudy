package com.study.designpattern.singletonpattern;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 21:21
 **/

public class LazyModeStaticClass {
    private LazyModeStaticClass(){

    }

    private static class setInstance{
        private static LazyModeStaticClass INSTANCE = new LazyModeStaticClass();
    }

    public LazyModeStaticClass getInstance(){
        return setInstance.INSTANCE;
    }
}
