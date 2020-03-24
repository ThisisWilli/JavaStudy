package com.coding.leetcode.dp.massage1716;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-24 09:20
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约
 * 。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。

 **/

public class Solution {
    // 使用dfs解题
    private int result = Integer.MIN_VALUE;
    public int massage(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        for (int i = 0; i < nums.length; i++){
            dfs(nums, i, 0);
        }
        return result;
    }

    private void dfs(int[] nums, int loc, int temp){
        temp += nums[loc];
        if (temp > result){
            result = temp;
        }
        for (int i = loc + 2; i < nums.length; i++){
            dfs(nums, i, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().massage(new int[]{2,1,4,5,3,1,1,3}));
    }
}
