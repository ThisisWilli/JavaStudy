package com.study.InnerClass;

/**
 * \* project: JavaStudy
 * \* package: com.study.InnerClass
 * \* author: Willi Wei
 * \* date: 2019-12-26 20:02:14
 * \* description:
 *          特点如下：
 *              1、局部内部类不能有访问权限修饰符(和变量不能有访问修饰符的原理一样)
 *              2、局部内部类不能被定义为static
 *              3、局部内部类不能定义static成员
 *              4、局部内部类默认包含了外部类对象的引用
 *              5、局部内部类也可以使用Outer.this语法制定访问外部类成员
 *              6、局部内部类想要使用方法或域中的变量，该变量必须是final
 * \
 */
public class LocalInnerClass {

    private int outNumber = 100;

    public void test(){
        class InnerClass{
            int innerNum = 200;
            public void innerFunc(){
                outNumber = 200;
            }
        }
        InnerClass innerClass = new InnerClass();
        innerClass.innerFunc();
    }

    public static void main(String[] args) {
        LocalInnerClass OuterClass = new LocalInnerClass();
        System.out.println(OuterClass.outNumber);
        OuterClass.test();
        System.out.println(OuterClass.outNumber);
    }
}