package com.jvm;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-11 15:16
 **/

public class Car {

    private int age;

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();

        car1.age = 1;
        car2.age = 2;
        car3.age = 3;
//
//        System.out.println(car1.hashCode());
//        System.out.println(car2.hashCode());
//        System.out.println(car3.hashCode());

        // 变回class
        Class<? extends Car> aClass1 = car1.getClass();
        ClassLoader classLoader = aClass1.getClassLoader();
        System.out.println(classLoader); //AppClassLoader
        System.out.println(classLoader.getParent()); //ExtClassLoader \jre\lib\ext,里面有很多扩展类jar包
        System.out.println(classLoader.getParent().getParent()); // null 1、不存在  2、java程序获取不到, rt.jar
    }
}
