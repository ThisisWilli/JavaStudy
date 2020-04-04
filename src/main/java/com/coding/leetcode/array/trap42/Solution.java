package com.coding.leetcode.array.trap42;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-04 19:24
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 先找到数组中的最大值，从左右两边分别向最大值遍历，保存左右两边的最大值
 **/

public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0){
            return 0;
        }
        int maxIndex = 0, max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max){
                maxIndex = i;
                max = height[i];
            }
        }
        int leftMax = height[0], rightMax = height[height.length - 1], result = 0;

        for (int i = 0; i < maxIndex; i++){
            if (height[i] > leftMax){
                leftMax = height[i];
            }
            result += leftMax - height[i];
        }

        for (int i = height.length - 1; i > maxIndex; i--){
            if (height[i] > rightMax){
                rightMax = height[i];
            }
            result += rightMax - height[i];
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
