package com.company.alibaba;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-05 09:02
 * 两个序列，由相同的无重复数字集合组成，把a变成b序列，只能进行以下操作
 * 1、从a中选择第一个或者最后一个数字插入a中的任意位置
 * 至少需要几次操作将a 变成b
 *
 * 4
 *
 *  4 2 3 1
 *  1 2 3 4
 **/

public class Main2 {
//    public static void main(String[] args) {
//        int size = 0;
//        Scanner sc = new Scanner(System.in);
//        size = sc.nextInt();
//
//        int[] a = new int[size];
//        int[] b = new int[size];
//
//        for (int i = 0; i < size; i++) {
//            a[i] = sc.nextInt();
//        }
//        for (int i = 0; i < size; i++) {
//            b[i] = sc.nextInt();
//        }
//
//
//
//
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] a = new int[cnt];
        int[] index = new int[cnt];
        HashMap<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < cnt; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < cnt; i++) {
            bMap.put(sc.nextInt(), i);
        }
        for (int i = 0; i < cnt; i++) {
            index[i] = bMap.get(a[i]);
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int maxLen = 0;
        int curLen = 1;
        int prior = index[0];
        for (int i = 1; i < cnt; i++) {
            if (index[i] - prior == 1){
                curLen++;
            }else {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
            }
            prior = index[i];
        }

        System.out.println(cnt - maxLen);
    }
}
