package com.study.designpattern.factorypattern.methodfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:02
 **/

public class TeslaCarFactory implements CarFactory {
    @Override
    public Car getCar() {
        return new Tesla();
    }
}
