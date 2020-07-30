package com.problemsolve.polymorphisms;

/**
 * \* project: JavaStudy
 * \* package: com.problemsolve.polymorphisms
 * \* author: Willi Wei
 * \* date: 2020-07-30 09:24:19
 * \* description:
 * \
 */
public class OverLoad {
    public int eat(int a, int b){
        return a + b;
    }

    public int eat(double a, int b){
        return (int)a + b;
    }

    public int eat(String a, int b){
        return Integer.parseInt(a) + b;
    }

    public static void main(String[] args) {
        new OverLoad().eat(1, 2);
    }
}