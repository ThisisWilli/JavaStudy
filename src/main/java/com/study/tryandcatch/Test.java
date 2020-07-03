package com.study.tryandcatch;

/**
 * \* project: JavaStudy
 * \* package: com.study.tryandcatch
 * \* author: Willi Wei
 * \* date: 2020-07-03 20:19:09
 * \* description:
 * \
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new Test().division(0));
    }

    public int division(int x){
        try {
            System.out.println("try block....");
            return 10 / x;
        } catch (Exception e) {
            System.out.println("exception occurred");
            e.printStackTrace();
            return -1;
        }
    }
}