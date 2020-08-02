package com.study.reflection;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-01 10:49
 **/

public class TestClassLoad {
    public static final int a = 2;
    public static int b = 3;
    static {
        System.out.println("静态代码块......");
    }



    {
        System.out.println("普通代码块......");
    }

    public TestClassLoad() {
        System.out.println("无参构造函数");
    }

    public String invokeMethod(int a){
        return "invoke..." + a;
    }

    public static void staticMethod(){
        System.out.println("静态方法");
    }
}
