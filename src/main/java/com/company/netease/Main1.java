package com.company.netease;

import java.util.Scanner;

/**
 * \* project: JavaStudy
 * \* package: com.company.netease
 * \* author: Willi Wei
 * \* date: 2020-08-09 13:12:28
 * \* description:
 * 牛牛现在有一个包含n个正整数得数组a，牛牛可以将其中的每个数a[i]都拆成若干个和为a[i]的正整数，牛牛想知道拆后(也可以不拆)这个数组中最多
 * 能有多少个素数
 * \ 最多素数 拆分方法 即看这个数中有多少个2，当a[i] > 1时，素数的个数为a[i] / 2
 * 3
 * 1 1 1
 * 输出
 * 0 1不可拆分
 * 输入
 * 1 3 5 7
 * 6 1为0个，3为1个，5为（2,3），7为（2,2,3）
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        long result = 0;
        for (int i = 0; i < size; i++) {
            result += sc.nextInt() / 2;
        }
        System.out.println(result);
    }
}