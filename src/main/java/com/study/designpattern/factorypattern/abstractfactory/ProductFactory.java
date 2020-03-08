package com.study.designpattern.factorypattern.abstractfactory;

public interface ProductFactory {
    PhoneProduct phoneProduct();
    RouteProduct routeProduct();
}
