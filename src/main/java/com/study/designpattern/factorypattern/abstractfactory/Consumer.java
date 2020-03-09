package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-09 21:30
 **/

public class Consumer {
    public static void main(String[] args) {
        HuaweiFactory huaweiFactory = new HuaweiFactory();
        PhoneProduct huaweiPhone = huaweiFactory.phoneProduct();
        huaweiPhone.call();
    }
}
