package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:34
 **/

public class XiaomiFactory implements ProductFactory{
    @Override
    public PhoneProduct phoneProduct() {
        return new XiaomiPhone();
    }

    @Override
    public RouteProduct routeProduct() {
        return new XiaomiRoute();
    }
}
