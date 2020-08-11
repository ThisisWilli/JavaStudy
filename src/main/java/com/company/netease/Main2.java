package com.company.netease;

import java.util.Scanner;

/**
 * @program: netease
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-08 15:27
题目：
有三种难度的题目分别为Easy/Medium/Hard，现在你总共有E+EM+M+MH+H道题，各个字符串的含义如下：
E表示有E道题目难度为Easy
EM表示有EM道题目难度为Easy或者Medium
M表示有M道题目难度为Medium
MH表示有MH道题目难度为Medium或者Hard
H表示有H道题目难度为Hard
你要用这些题目出尽量多的模拟赛，为了保证题目质量且含有一定的区分量，每场模拟赛需要包含Easy Medium Hard三种难度的题目各一道，求你最多能出多少场模拟赛

输入描述
一行五个整数,E,EM,M,MH,H
0 <= E+EM+M+MH+H <= 10^18
输出描述
输出你最多能出多少场模拟赛
示例1
输入
2 2 1 2 2
输出
3
说明
三组分别是
E + EM + H
E + MH + H
EM + M + MH

思路：
就像一根绳子，共5个部分，只能在第二部分和第四部分各切一刀，分3段，使得最短的那段最长。
那我们直接返回(E+EM+M+MH+H)/3，（E+EM+M+MH)/2，（EM+M+MH+H)/2，E+EM,MH+H，EM+M+MH六者的最小值不就好了？（5部分分3段，4部分分2段，2~3部分分一段）
 *
 **/

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] nums = new long[5];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextLong();
        }


        System.out.println(new Main2().getResult(nums));
    }
    public long getResult(long[] nums){
        long sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += nums[i];
        }
        long sum1 = sum /3;
        long sum2 = Math.min(nums[0] + nums[1], nums[1] + nums[2] + nums[3]);
        return Math.min(sum1, sum2);
    }
}
