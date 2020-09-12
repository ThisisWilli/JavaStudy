package com.company.xiaohongshu;

import java.util.Scanner;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-09-12 10:10
 *
 * 给定一个非空的字符串s ，将s切割成若干个非空子串，要求每个子串头尾是相同字符 ，给出切割的子串的数量最少的方法。
 *
 * 输入描述
 * 一个非空的字符串s
 *
 * 输出描述
 * 满足要求的切割结果的子串数量
 * abaccd
 * 3
 *
 * 1、字符串有很多种切割的方法，使得切割出来的子串头尾是相同字符，本题要求找出其中一种切割的方法，
 * 使得它切割之后的子串数量是最少的。并把这个切割方法的子串数量作为输出
 *
 * 2、比如一个字符串为"abaccd",那么切割成"aba"、"cc"、"d"3个子串是满足条件的，输出结果就是 3
 **/

public class Main2 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/

    static int solution(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int i = 1;
        while (i < s.length()) {
            int max = dp[i - 1] + 1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)){
                    min = dp[j];
                    break;
                }
            }
            dp[i] = Math.min(max, min);
            i++;
        }
        return dp[s.length() - 1];
    }

    static boolean judge(String s){
        return s.charAt(0) == s.charAt(s.length() - 1);
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        res = solution(_s);
        System.out.println(String.valueOf(res));

    }

}
