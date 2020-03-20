package com.coding.leetcode.heap.getleastnumbers;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-20 09:18
 **/

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || k <= 0){
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            return o2 -o1;
        });

        for (int i = 0; i < arr.length; i++) {
            if (queue.size() < k){
                queue.offer(arr[i]);
            }else if (queue.peek() > arr[i]){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int[] result = new int[queue.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.remove();
        }

//        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().getLeastNumbers(new int[]{0,0,1,3,4,5,0,7,6,7, 9}, 6);
    }

}
