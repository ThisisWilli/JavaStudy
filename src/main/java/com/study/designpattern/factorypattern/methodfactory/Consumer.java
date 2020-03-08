package com.study.designpattern.factorypattern.methodfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:03
 **/

public class Consumer {
    public static void main(String[] args) {
        Car wuling = new WuLingFactory().getCar();
        Car tesla = new TeslaCarFactory().getCar();
        wuling.name();
        tesla.name();

        // 结构复杂度
        // 管理复杂度
        // 代码复杂度
        // 编程复杂度
        // 根据设计模式选择 工厂方法模式，业务上使用简单方法模式
    }
}
