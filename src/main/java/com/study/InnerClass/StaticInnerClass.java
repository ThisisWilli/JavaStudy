package com.study.InnerClass;

/**
 * \* project: JavaStudy
 * \* package: com.study.InnerClass
 * \* author: Willi Wei
 * \* date: 2019-12-26 20:36:10
 * \* description:如果不需要内部类对象与其外围类对象之间有联系，那么可以将内部类声明为static，这通常成为嵌套类，普通内部类对象隐含地
 *                保存了一个引用，指向创建它的外围类对象，然后，当内部类是static时，就不是这样，嵌套类意味着：
 *                1、要创建嵌套类的对象，并不需要器外围类的对象
 *                2、不能从嵌套类的对象中访问非静态的外围类对象
 * \
 */
public class StaticInnerClass {
    private static int i = 1;
    private int j = 10;

    public static void outerF1(){

    }

    public void outerF2(){

    }

    public void outerF3(){
        // 外部类访问内部类的静态成员：内部类.静态成员
        System.out.println(InnerClass.Inneri);
        InnerClass.innerFunc();

        // 外部类访问静态内部类非静态成员变量；实例化内部类即可
        InnerClass innerClass = new InnerClass();
        innerClass.innerFunc2();
    }

    public static class InnerClass{
        static int Inneri = 100;
        int innerJ = 200;

        static void innerFunc(){
            System.out.println("OuterClass.i = " + i);

        }

        public void innerFunc2(){
            //静态内部类不能访问外部类的非静态成员（包括非静态变量和非静态方法）
//            System.out.println("OutClass.j = " + j);
        }
    }

    public static void main(String[] args) {
        new StaticInnerClass().outerF3();
    }
}