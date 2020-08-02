package com.study.reflection;

import com.study.inherit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: JavaStudy
 * @description: 熟悉有几种方式可以加载类
 * @author: Hoodie_Willi
 * @create: 2020-08-01 09:59
 **/

public class Test06 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//        Class<TestClassLoad> dotClass = TestClassLoad.class;
        @SuppressWarnings("rawtypes")
        Class<?> forNameClass = Class.forName("com.study.reflection.TestClassLoad");
        Object o = forNameClass.newInstance();
        System.out.println(forNameClass.getMethod("invokeMethod", int.class).invoke(o, 2));
//        TestClassLoad newClass = new TestClassLoad();
    }
}
