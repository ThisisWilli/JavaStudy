package com.problemsolve.arraycopy;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.arraycopy
 * \* author: Willi Wei
 * \* date: 2020-07-30 13:46:29
 * \* description:
 * \
 */
public class ArrayTest implements Cloneable{

    Apple apple = new Apple();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayTest test = new ArrayTest();
        ArrayTest clone = (ArrayTest)test.clone();
        System.out.println(test == clone);
        clone.apple = (Apple) test.apple.clone();
        System.out.println(test.apple == clone.apple);
    }
}

class Apple implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
