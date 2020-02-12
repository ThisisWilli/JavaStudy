package com.jvm;



/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-11 15:57
 **/

public class Student {
    // 双亲委派机制
    //1。APP-->EXC-->BOOT(最终程序)

    @Override
    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) {
        String s = new String();
        System.out.println(s.getClass().getClassLoader());
        s.toString();
    }
}
