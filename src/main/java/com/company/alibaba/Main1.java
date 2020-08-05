package com.company.alibaba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-05 08:49
 * 扑克牌去掉大小王由数字1-13各四种花色组成，小强创建一张牛牌，牛牌由数字1-n各四种花色组成，但是小强只有黑色水笔画不出四种花色，因此他只能
 * 创造出1-n各四张牌，他想知道，当他手上有m张牌时，这m张牌一共有多少牌型（两种牌型不同当且仅当某个数字在两种牌型中的数量不同）
 *
 * 3 2
 *
 * 6
 *
 * 9 14
 * 118800
 **/

public class Main1 {
    public int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 范围1 - n
        int n = sc.nextInt();
        // 手牌数量
        int m = sc.nextInt();
        boolean[] visited = new boolean[m];


    }
}
