package com.study.InnerClass;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * \* project: JavaStudy
 * \* package: com.study.InnerClass
 * \* author: Willi Wei
 * \* date: 2019-12-26 19:31:25
 * \* description:
 *      成员内部类时定义在类内部，是作为类成员的类
 *      特点如下：
 *      1、成员内部类可以被权限修饰符所修饰  ---✔
 *      2、成员内部类可以访问内部类的所有成员，包括private成员,static成员 ----✔
 *      3、成员内部类时默认包含了一个指向外部类对象的引用 ----✔
 *      4、如同使用this一样，当成员名或方法名发生覆盖时，可以使用外部类的名字加.this指定访问外部类成员Outer.this.name
 *      5、成员内部类不可以定义static成员-----✔
 *      6、成员内部类创建语法
 *              Outer outer=new Outer();
 *              Outer.Inner inner=outer.new Inner();
 * \
 */
public class MemberInnerClass {

    private int num = 100;
    private String str = "OutClass";
    private static int a = 300;
    public MemberInnerClass(int num, String str) {
        this.num = num;
        this.str = str;
    }

    // 成员内部类可以被访问修饰符修饰
    private class InnerClass{
//        static 成员内部类中不能定义static变量
        private int num;
        private void innerChangeNumAndStr(){
// public int num3;      错误！！ 权限修饰符是定义只用于修饰属性和方法，方法中定义的局部变量在方法调用完之后就不存在了，不需要用修饰符修饰

            // 成员变量默认包含一个指向外部类对象的引用
            if (MemberInnerClass.this.num == 100){
                MemberInnerClass.this.num = 200;
            }
            if (str.equals("OutClass")){
                str = "InnerClass";
                this.num = 300;
            }
        }
    }

    public static void main(String[] args) {
        MemberInnerClass outClass = new MemberInnerClass(100, "OutClass");
        InnerClass innerClass = outClass.new InnerClass();
        System.out.println(outClass.num + " " + outClass.str + " " + innerClass.num);
        innerClass.innerChangeNumAndStr();
        System.out.println(outClass.num + " " + outClass.str + " " + innerClass.num);;
    }
}

