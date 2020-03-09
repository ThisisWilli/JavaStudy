package com.study.designpattern.factorypattern.simplefactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 20:49
 **/

public class CarFactory {
    // 方法一
    static Car buyCar(String car){
        if (car.equals("WuLing")){
            return new WuLing();
        }else if (car.equals("Tesla")){
            return new Tesla();
        }else {
            return null;
        }
    }
}
