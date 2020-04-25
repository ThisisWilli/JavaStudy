package com.coding.leetcode.backtrack.permute46;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-25 09:02
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 **/
public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0 || nums == null){
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                visited[i] = true;
                helper(nums, temp, visited);
                visited[i] = false;
            }
        }
        return result;
    }

    private void helper(int[] nums, List<Integer> temp, boolean[] visited){
        if (temp.size() == nums.length){
            ArrayList<Integer> list = new ArrayList<>(temp);
            result.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]){
                temp.add(nums[i]);
                visited[i] = true;
                helper(nums, temp, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new Solution().permute(new int[]{1, 2, 3, 4});
        results.forEach(list->{
            list.forEach(num->{
                System.out.print(num + " ");
            });
            System.out.println();
        });
    }
}
