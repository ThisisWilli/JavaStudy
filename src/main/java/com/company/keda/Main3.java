package com.company.keda;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-31 14:50
 * 使用对角线相连的两个点表示一个矩形，如矩形(0, 0)，(2, 1)表示(0, 0), (2, 0), (2, 1), (0, 1)所围成的矩形区域
 * 编程实现判断输入的两个矩形是否相交
 *
 * 输入描述 0 0 4 2 0 1 5 3
 * 前面4个整数表示第一个矩形的队点坐标，后面4个数字表示两个矩形的队点坐标
 * 相交返回1，不相交输出0
 **/

public class Main3 {
    public boolean isOverLap(Rect rc1, Rect rc2){
        if (rc1.x + rc1.width >= rc2.x &&
        rc2.x + rc2.width >= rc1.x &&
        rc1.y + rc1.height >= rc2.y &&
        rc2.y + rc2.height >= rc1.y){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] r1 = new int[4];
        int[] r2 = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < r1.length; i++) {
            r1[i] = sc.nextInt();
        }

        for (int i = 0; i < r2.length; i++) {
            r2[i] = sc.nextInt();
        }

        boolean overLap = new Main3().isOverLap(new Rect(r1[0], r1[1], Math.abs(r1[0] - r1[2]), Math.abs(r1[1] - r1[3])),
                new Rect(r2[0], r2[1], Math.abs(r2[0] - r2[2]), Math.abs(r2[1] - r2[3])));
        if (overLap){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }
}

class Rect{
    int x;
    int y;
    int width;
    int height;

    public Rect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}