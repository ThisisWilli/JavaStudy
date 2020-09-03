package com.company.baidu;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-03 20:10
 * n头奶牛，将奶牛编号1-n
 * 质检员检查奶牛质量，列出m个特性，只有满足所有特性，才能算优质奶牛
 * 牛牛只知道对于某条特性，某几段连续区间内奶牛是满足条件的，但如果这样一次排查，会浪费很多时间，由于牛妹时间很急，需要赶下一个牧场，
 * 所以，牛牛请你帮他筛选优质奶牛。
 *
 * 第一行正整数n，m 代表奶牛数量和需要满足的特性数量
 * 接下来对于每个特性，一行输入一个正整数k，代表这个特性在奶牛中满足的区间数量，
 * 接着k行，每行输入两个正整数 l, r代表[l, r]区间内的奶牛满足这一特性
 * 1             1组数据
 * 10 2          10只奶牛 满足两个特性
 * 3
 * 1 2
 * 4 5
 * 8 8
 *
 * 2
 * 1 4
 * 6 8
 *
 **/

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int niu = sc.nextInt();
            int condition = sc.nextInt();
            int[] ans = new int[niu];
            int count = 0;
            for (int j = 0; j < condition; j++) {
                boolean[] flag = new boolean[niu];
                int partition = sc.nextInt();
                for (int k = 0; k < partition; k++) {
                    int l = sc.nextInt();
                    int r = sc.nextInt();
                    while (l <= r){
                        if (!flag[l]){
                            ans[l]++;
                            flag[l] = true;
                        }
                        if (ans[l] == condition){
                            count++;
                        }
                        l++;
                    }
                }
            }
            System.out.println(count);
            for (int j = 0; j < ans.length; j++) {
                if (ans[j] == condition) System.out.println(j + " ");
            }
        }
    }
}
