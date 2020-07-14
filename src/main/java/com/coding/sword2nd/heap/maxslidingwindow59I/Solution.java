package com.coding.sword2nd.heap.maxslidingwindow59I;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-13 14:36
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 * 1 3 -1
 * 1 1 -1
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 **/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++){
            // 保持队列单调递增
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();

        for (int i = k; i < nums.length; i++){
            // 判断队头元素是否为上个窗口的开始元素，也就是要出队的那个元素
            if (nums[i - k] == deque.peekFirst()){
                deque.removeFirst();
            }
            // 如果队尾元素小于当前元素，将队尾元素出列
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ints = new Solution().maxSlidingWindow(nums, 3);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
