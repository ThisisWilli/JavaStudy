package com.company.bilibili;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-13 19:39
 * 面值1，4，16，64 4种硬币，以及面值1024的纸币，用1024购买价值为N的商品，最少他会收到多少硬币
 * 200 --》 17
 **/

public class Main3 {
    static int m1 = 1;
    static int m2 = 4;
    static int m3 = 16;
    static int m4 = 64;
    static int money = 1024;
    /**
     *
     * @param N int整型
     * @return int整型
     */
    public int GetCoinCount (int N) {
        // write code here
        money -= N;
        int n4 = money / m4;
        money = money % m4;
        int n3 = money / m3;
        money = money % m3;
        int n2 = money / m2;
        money = money % m2;
        int n1 = money / m1;
        money = money % m1;
        return n1 + n2 + n3 + n4;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Main3().GetCoinCount(sc.nextInt()));
    }
}
