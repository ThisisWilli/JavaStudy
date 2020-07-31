package com.company.keda;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-31 14:37
 *
 * 编程实现一个从字符串输入提取整数的程序，要求尽量多的考虑异常输入的情况
 * 输入要求：字符串长度大于0
 *
 **/

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean positive = true;
        int minusCnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-'){
                minusCnt++;
            }
        }
        if ((minusCnt & 1) == 1){
            positive = false;
        }
        String digits = str.replaceAll("\\D", "");
        long num = (positive ? 1 : -1) * Long.parseLong(digits);
        System.out.println(num);
    }
}
