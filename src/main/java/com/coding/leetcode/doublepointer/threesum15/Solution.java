package com.coding.leetcode.doublepointer.threesum15;

import java.util.*;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.doublepointer.threesum15
 * \* author: Willi Wei
 * \* date: 2020-05-26 21:14:54
 * \* description:
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *                [-4, -1, -1, 0, 1, 2]
 *
 *                [-2, 0, 1, 1, 2]
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * \
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0){
            return result;
        }
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int start = i + 1, end = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            while (start < end){
                if (nums[i] + nums[start] + nums[end] == 0){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    result.add(temp);
                    while (start < end && nums[start] == nums[start + 1]){
                        start++;
                    }
                    while (start < end && nums[end - 1] == nums[end]){
                        end--;
                    }
                    start++;
                    end--;
                }else if (nums[start] + nums[end] > target){
                    end--;
                }else {
                    start++;
                }

            }
        }
//        result.addAll(set);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 1, 2};
        List<List<Integer>> result = new Solution().threeSum(nums);
        result.forEach(list->{
            list.forEach(num->{
                System.out.print(num + " ");
            });
            System.out.println();
        });
    }
}