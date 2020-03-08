package com.study.designpattern.factorypattern.methodfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 20:49
 **/

public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}
