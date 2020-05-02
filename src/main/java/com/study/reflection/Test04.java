package com.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-02 14:14
 **/

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c = Class.forName("com.study.reflection.User");
        // 本质上调用无参构造器
//        User user = (User) c.newInstance();
//        System.out.println(user);

        // 通过构造器创建对象
        Constructor<?> constructor = c.getDeclaredConstructor(int.class, String.class);
        User willi = (User) constructor.newInstance(1, "willi");
        System.out.println(willi);

        // 通过反射调用方法
        User user3 = (User) c.newInstance();

        // 通过反射获取一个方法并传参调用
        Method setName = c.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "传参调用");
        System.out.println(user3);

        // 通过反射操作属性
        User user4 = (User) c.newInstance();
        Field name = c.getDeclaredField("name");
        // 不能直接操作私有属性，需要关闭权限
        name.setAccessible(true);
        name.set(user4, "通过反射操作属性");
        System.out.println(user4);
    }
}
