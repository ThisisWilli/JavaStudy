package com.company.netease;

import java.util.Collections;
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
E,EM,M,MH,H
2 2 1 2 2
输出
3
说明
三组分别是
E + EM + H
E + MH + H
EM + M + MH

E,EM,M,MH,H
5 1 0 2 1
思路：
二分查找，不断探索符合条件的最大 target 值。

先对 e,h 进行分析，是否满足 target 个方案，不够的话， e 用 em 补充，h 用 mh 补充

最后判断 e,h, 和 m +em + mh 三个级别的个数是否满足条件，
即 e >= target && h >= target && m + em + mh >= target
如果满足条件，增大target 值，继续探索。

此处用二分查找来缩小每一步探索的范围，满足的话 left = mid +1

不满足的话，right = mid -1
 *
 **/

public class Main2 {
    private static int score;
    private static int max;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] arr = sc.nextLine().trim().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        max = 0;
        int res = EMH(nums);
        System.out.println(res);
    }

    private static int EMH(int[] nums) {

        int e = nums[0];
        int m = nums[2];
        int h = nums[4];
        int em = nums[1];
        int mh = nums[3];

        int maxval = (e + m + h + em + mh) / 3;
        int left = 0, right = maxval + 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (binarySearch(mid, e, m, h, em, mh)) {
                //若满足
                left = mid + 1;
                max = Math.max(max, mid);
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
    private static boolean binarySearch(int mid, int e, int m, int h, int em, int mh) {
        //1.先处理 e, e 与要求的 mid 相比,少几个就从 em 中拿几个,假设 em是充足的
        if(mid > e){
            int cur = Math.min(mid - e,em);
            e += cur;
            em -= cur;
        }
        //2 处理 h ,h 与要求的 mid 相比,少几个就从 mh 中拿几个,假设 mh 是充足的
        if(mid > h){
            int cur = Math.max(mid - h ,mh);
            h += cur;
            mh -= cur;
        }
        // 3 判断拿完之后是否符合条件
        return e >= mid && h >= mid && (m + em + mh) >= mid;

    }
}


