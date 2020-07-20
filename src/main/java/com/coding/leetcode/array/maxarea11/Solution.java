package com.coding.leetcode.array.maxarea11;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.maxarea11
 * \* author: Willi Wei
 * \* date: 2020-07-20 16:11:40
 * \* description:
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * \
 */
public class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        while (left <= right){

            if (height[left] >= height[right]){
                result = Math.max(result, height[right] * (right - left));
                right--;
            }else {
                result = Math.max(result, height[left] * (right - left));
                left++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}