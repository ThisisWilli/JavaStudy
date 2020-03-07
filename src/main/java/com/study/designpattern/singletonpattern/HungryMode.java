package com.study.designpattern.singletonpattern;

/**
 * @program: JavaStudy
 * @description: 单例模式饿汉式实现
 * @author: Hoodie_Willi
 * @create: 2020-03-07 20:15
 **/

public class HungryMode {
    // 在类加载时直接创建实例
    private static HungryMode hungryMode = new HungryMode();

    private HungryMode() {

    }

    public static HungryMode getInstance(){
        return hungryMode;
    }

    public void say(){
        System.out.println("hungry mode");
    }

    public static void main(String[] args) {
        HungryMode.getInstance().say();
    }
}
