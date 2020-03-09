package com.study.designpattern.factorypattern.simplefactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-09 19:43
 **/

public class Consumer {
    public static void main(String[] args) {
        Car tesla = new CarFactory().buyCar("Tesla");
        tesla.name();
    }
}
