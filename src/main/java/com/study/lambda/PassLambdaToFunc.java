package com.study.lambda;

/**
 * \* project: JavaStudy
 * \* package: com.study.lambda
 * \* author: Willi Wei
 * \* date: 2019-12-26 16:42:44
 * \* description:使用lambda表达式的重点是延迟执行，毕竟一般可以立即执行代码，主要分为一下几种情况
 *              1、在一个单独的线程中运行代码
 *              2、多次运行代码
 *              3、在算法的适当位置运行代码
 *              4、发生某种情况时执行代码
 *              5、只在必要时执行代码
 * \
 */

public class PassLambdaToFunc {
    private interface IntConsumer{
        void accept(int value);
    }
    public static void repeat(int n, IntConsumer action){
        for (int i = 0; i < n; i++){
            action.accept(i);
        }
    }
    public static void main(String[] args) {
        repeat(10, i-> System.out.println("计数" + i));
    }
}