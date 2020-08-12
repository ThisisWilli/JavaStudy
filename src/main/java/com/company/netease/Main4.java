package com.company.netease;

import java.util.Scanner;

/**
 * \* project: JavaStudy
 * \* package: com.company.netease
 * \* author: Willi Wei
 * \* date: 2020-08-09 13:24:39
 * \* description:
 * 给出n个物品，每个物品都有自己的价值，每个物品只有一件，这些物品需要分给两个人，要求分配完之后，
 * 两个人的物品价值相同。分配完成之后，会丢弃剩下的物品，求最少要丢弃多少物品。
 *
 * 输入
 * 输入第一行为总的测试数据个数，第二行为物品个数n，第三行为n个物品的价值。
 * 1
 * 5
 * 30 60 5 15 30
 * 输出
 * 20 丢弃5和15，把60分配给第一个人，2个30分配给第二个人。
 * \
 */
public class Main4 {
    int res;
    public static void main(String[] args) {
        Main4 main = new Main4();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            main.res = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            main.dfs(nums, 0, 0, 0, 0);
            System.out.println(main.res);
        }
    }

//    public void dfs(int[] nums, int index, int sum_1, int sum_2, int r){
//        if (index == nums.length){
//            System.out.println(r);
//            if (sum_1 == sum_2){
////                System.out.println("sum_1 = " + sum_1 + ", sum_2 = " + ", r = " + r);
//                res = Math.min(r, res);
//            }
//            return;
//        }
//        dfs(nums, index + 1, sum_1 + nums[index], sum_2, r);
//        dfs(nums, index + 1, sum_1, sum_2 + nums[index], r);
//        dfs(nums, index + 1, sum_1, sum_2, r + nums[index]);
//    }
//
    public void dfs(int[] nums, int index, int sum_1, int sum_2, int r){
        if (index == nums.length){
            System.out.println(r);
            if (sum_1 == sum_2){
                res = Math.min(r, res);
            }
            return;
        }
        dfs(nums, index + 1, sum_1 + nums[index], sum_2, r);
        dfs(nums, index + 1, sum_1, sum_2 + nums[index], r);
        dfs(nums, index + 1, sum_1, sum_2, r + nums[index]);
    }
}