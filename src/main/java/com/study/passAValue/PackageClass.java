package com.study.passAValue;

/**
 * \* project: JavaStudy
 * \* package: com.study.passAValue
 * \* author: Willi Wei
 * \* date: 2020-01-08 19:32:11
 * \* description:
 * \
 */
public class PackageClass {
    public static void main(String[] args) {
        Integer obj1 = new Integer(1);
        Integer obj2 = new Integer(2);
        System.out.println("修改之前obj1和obj2的值 " + "obj1 = " + obj1.intValue() + " " + "obj2 = " + obj2.intValue());
        modifyWrappers(obj1, obj2);
        System.out.println("修改之后obj1和obj2的值 " + "obj1 = " + obj1.intValue() + " " + "obj2 = " + obj2.intValue());
    }

    /**
     * 包装类存储在堆中，在堆栈中有一个指向它的引用，当调用该方法时，在堆栈中为每个引用创建了一个拷贝，这些拷贝被传递到了方法里，任何
     * 方法里的修改都只是改变了引用的拷贝，而不是原始的引用
     * @param x
     * @param y
     */
    private static void modifyWrappers(Integer x, Integer y){
        x = new Integer(5);
        y = new Integer(10);
    }
}