package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:31
 **/

public class HuaweiRoute implements RouteProduct {
    @Override
    public void send() {
        System.out.println("huawei route send");
    }

    @Override
    public void receive() {
        System.out.println("huawei route receive");
    }
}
