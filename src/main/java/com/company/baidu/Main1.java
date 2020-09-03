package com.company.baidu;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-03 19:33
 * 牛牛有n张卡片。要么是0，要么是5，选出若干卡片组成一些数字，牛牛请你找出所有可能数字中能整除90的最大整数
 * 第一行 输入数字n
 * 第二行 n个整数，0或5
 * 11
 * 5 5 5 5 5 5 5 5 0 0 5 5
 **/

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numFive = 0;
        int numZero = 0;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 5){
                numFive++;
            }
            if (num == 0){
                numZero++;
            }
        }

        int count = numFive / 9;
        if (count == 0){
            System.out.println(0);
        }else {
            for (int i = 0; i < count * 9; i++){
                System.out.print(5 + "");
            }
            for (int i = 0; i < numZero; i++){
                System.out.print(0 + "");
            }
        }
    }
}
