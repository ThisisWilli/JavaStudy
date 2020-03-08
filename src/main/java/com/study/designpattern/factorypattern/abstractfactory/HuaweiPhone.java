package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:29
 **/

public class HuaweiPhone implements PhoneProduct{
    @Override
    public void call() {
        System.out.println("huawei call");
    }

    @Override
    public void send() {
        System.out.println("huawei send");
    }
}
