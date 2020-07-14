package com.coding.sword2nd.math.twosum60;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.math.twosum60
 * \* author: Willi Wei
 * \* date: 2020-07-14 16:33:24
 * \* description:
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 *  
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.0833
 *
 * \
 */
public class Solution {
    public double[] twoSum(int n) {
        if(n==0) return new double[0];
        int code =6;//每个骰子有6个数字
        int[][] count = new int[2][n*code+1];
        int flag = 0;
        //i为骰子数,j为点数,k为移动的位数(1=<k<=6)
        for(int j=1;j<=code;j++) count[flag][j] =1;//第1枚骰子,i=1
        for(int i=2;i<=n;i++){//第2枚到第n枚骰子
            for(int j=1;j<i;j++) count[1-flag][j]=0;//第1~i-1置0,第0位没有进行修改过，始终为初始值0;
            for(int j=i;j<=i*code;j++){
                count[1-flag][j]=0;//这里必须有清空操作,否则后面的+=操作会基于上上次循环的初始值累加
                for(int k=1;k<=6&&j-k>=1;k++){
                    count[1-flag][j]+=count[flag][j-k];
                }
            }
            flag = 1-flag;
        }
        double base = Math.pow(code,n);
        double[] p = new double[n*code-n+1];
        for(int j= 0;j<p.length;j++) p[j] = count[flag][n+j]/base;//base已经是double类型了，这里前面可不用加(double)转换了
        return p;

    }
}