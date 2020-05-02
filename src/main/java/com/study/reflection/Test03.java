package com.study.reflection;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-05-02 10:20
 **/

public class Test03 {

    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        // 主动引用
//         Son son = new Son();
        // 反射也会产生主动引用
//        Class.forName("com.study.reflection.Son");
//        Class<Son> sonClass = Son.class;

        // 不会产生类引用的方法
//        System.out.println(Son.b);

//        Son[] sons = new Son[5];
//        System.out.println(Son.M);
        System.out.println(Son.m);
    }
}

class Father{

    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;

    static final int M = 1;
}
