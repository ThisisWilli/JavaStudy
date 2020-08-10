package com.company.netease;

import java.util.Scanner;

/**
 * @program: netease
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-08 15:27
 * 有三种选择，E，M，H
 *  E，EM，M，MH，H
 *  三种难度的题目各一道
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
