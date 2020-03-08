package com.study.designpattern.factorypattern.abstractfactory;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-08 21:36
 **/

public class HuaweiFactory implements ProductFactory {
    @Override
    public PhoneProduct phoneProduct() {
        return new HuaweiPhone();
    }

    @Override
    public RouteProduct routeProduct() {
        return new HuaweiRoute();
    }
}
