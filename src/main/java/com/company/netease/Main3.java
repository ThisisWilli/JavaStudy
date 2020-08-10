package com.company.netease;

import java.util.Scanner;

/**
 * @program: netease
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-08-08 15:27
 *
 * n个题目，第i个题目的分数为Si，如果第i题回答正确，得到Si分，否则得0分，如果学生总分有数字5，那么这个学生得0分
 **/

public class Main3 {
    int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] scores = new int[size];
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        System.out.println(new Main3().maxnum(size, scores));
    }

    public int maxnum(int n, int[] nums){
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (panduan(sum)){
            return sum;
        }
        return diu(0, n, nums, sum);
    }

    public int diu(int m, int n, int[] nums, int sum){
        for (int i = m; i < n; i++) {
            if (panduan(sum-nums[i]) && max < sum - nums[i]){
                max = sum - nums[i];
            }
            diu(i + 1, n, nums, sum - nums[i]);
        }
        return max;
    }

    public boolean panduan(int sum){
        while (sum != 0){
            if (sum % 10 == 5) {
                return false;
            }
            sum = sum / 10;
        }
        return true;
    }
}

