package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:30
 **/

public class XiaomiRoute implements RouteProduct{
    @Override
    public void send() {
        System.out.println("xiaomi route send");
    }

    @Override
    public void receive() {
        System.out.println("xiaomi route receive");
    }
}
