package com.study.passAValue;

/**
 * \* project: JavaStudy
 * \* package: com.study.passAValue
 * \* author: Willi Wei
 * \* date: 2020-01-08 19:28:09
 * \* description:
 * \
 */
public class BasicParameter {

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        System.out.println("修改之前x，y的值" + "x = " + x + " y = " + y);
        modifyPrimitiveTypes(x, y);
        System.out.println("修改之后x，y的值" + "x = " + x + " y = " + y);
    }

    /**
     * x，y这两个参数是基本类型，所以存储在堆栈中，当调用该方法的时，在堆栈中创建了这2个参数的拷贝，实际上是这两个拷贝被传递到了方法中
     * ，在方法中的任何修改只作用于参数的两个拷贝
     * @param x
     * @param y
     */
    private static void modifyPrimitiveTypes(int x, int y){
        x = 5;
        y = 10;
    }
}