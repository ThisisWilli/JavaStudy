package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:20
 **/

public class XiaomiPhone implements PhoneProduct {
    @Override
    public void call() {
        System.out.println("xiaomi call");
    }

    @Override
    public void send() {
        System.out.println("xiaomi send");
    }
}
