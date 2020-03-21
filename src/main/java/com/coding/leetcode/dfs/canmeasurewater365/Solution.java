package com.coding.leetcode.dfs.canmeasurewater365;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-21 09:44
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 **/

public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0){
            return true;
        }
        if (x + y < z){
            return false;
        }
        List<visitedArray> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x + y, 0, 0});
        list.add(new visitedArray(new int[]{x + y, 0, 0}));

        while (!queue.isEmpty()){
            int[] nums = queue.poll();
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            if (nums[1] == z || nums[2] == z || nums[1] + nums[2] == z){
                return true;
            }

            // g --> x
            if (nums[0] != 0 && (nums[0] - x) >= 0 && nums[1] + x <= x && !isVisited(list, new int[]{nums[0] - x, nums[1] + x, nums[2]})){
                list.add(new visitedArray(new int[]{nums[0] - x, nums[1] + x, nums[2]}));
                queue.offer(new int[]{nums[0] - x, nums[1] + x, nums[2]});
            }

            // g --> y
            if (nums[0] != 0 && (nums[0] - y) >= 0 && nums[2] + y <= y && !isVisited(list, new int[]{nums[0] - y, nums[1], nums[2] + y})){
                list.add(new visitedArray(new int[]{nums[0] - y, nums[1], nums[2] + y}));
                queue.offer(new int[]{nums[0] - y, nums[1], nums[2] + y});
            }

            // x --> y   x倒空了，y没满， x没到完，y满了
            if (nums[1] > 0){
                // x倒空了，y没满
                if (nums[2] + nums[1] <= y && !isVisited(list, new int[]{nums[0], 0, nums[1] + nums[2]})){
                    list.add(new visitedArray(new int[]{nums[0], 0, nums[1] + nums[2]}));
                    queue.offer(new int[]{nums[0], 0, nums[1] + nums[2]});
                }

                // x没到完，y满了
                if (nums[2] + nums[1] > y && !isVisited(list, new int[]{nums[0], nums[1] - (y - nums[2]), y})){
                    list.add(new visitedArray(new int[]{nums[0], nums[1] - (y - nums[2]), y}));
                    queue.offer(new int[]{nums[0], nums[1] - (y - nums[2]), y});
                }
            }

            // y--> x   y倒空了，x没满， y没到完，x满了
            if (nums[2] > 0){
                // y倒空了，x没满
                if (nums[2] + nums[1] <= x && !isVisited(list, new int[]{nums[0], nums[1] + nums[2], 0})){
                    list.add(new visitedArray(new int[]{nums[0], nums[1] + nums[2], 0}));
                    queue.offer(new int[]{nums[0], nums[1] + nums[2], 0});
            }

                // y没到完，x满了
                if (nums[2] + nums[1] > x && !isVisited(list, new int[]{nums[0], x, nums[2] - (x - nums[1])})){
                    list.add(new visitedArray(new int[]{nums[0], x, nums[2] - (x - nums[1])}));
                    queue.offer(new int[]{nums[0], x, nums[2] - (x - nums[1])});
                }
            }

            // x --> g
            if (nums[0] + nums[1] <= x + y &&nums[1] >=0 && !isVisited(list, new int[]{nums[0] + nums[1], 0, nums[2]})){
                list.add(new visitedArray(new int[]{nums[0] + nums[1], 0, nums[2]}));
                queue.offer(new int[]{nums[0] + nums[1], 0, nums[2]});
            }

            // y --> g
            if (nums[0] + nums[2] <= x + y && nums[2] >=0 && !isVisited(list, new int[]{nums[0] + nums[2], nums[1], 0})){
                list.add(new visitedArray(new int[]{nums[0] + nums[2], nums[1], 0}));
                queue.offer(new int[]{nums[0] + nums[2], nums[1], 0});
            }
        }

        return false;
    }

    private boolean isVisited(List<visitedArray> list, int[] nums){
        return list.contains(new visitedArray(nums));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(22003, 31237, 1));
    }

}
class visitedArray{
    int[] nums;

    public visitedArray(int[] nums) {
        this.nums = nums;
    }

    @Override
    public int hashCode() {
        return this.nums.length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        else {
            obj = (visitedArray)obj;
            for (int i = 0; i < this.nums.length; i++){
                if (((visitedArray) obj).nums[i] != this.nums[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
