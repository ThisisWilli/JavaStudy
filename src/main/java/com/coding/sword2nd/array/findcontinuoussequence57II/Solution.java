package com.coding.sword2nd.array.findcontinuoussequence57II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-07-13 14:12
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 **/

public class Solution {
    public int[][] findContinuousSequence(int target) {
        LinkedList<LinkedList<Integer>> lists = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        int sum = 0;
        for (int i = target / 2 + 1; i >= 1; i--){
            if (sum + i == target){
                sum += i;
                temp.addFirst(i);
                lists.addFirst(new LinkedList<Integer>(temp));
                sum -= temp.removeLast();
            }else if (sum + i < target){
                sum += i;
                temp.addFirst(i);
            }else {
                sum -= temp.removeLast();
                temp.addFirst(i);
                sum += i;
            }
        }

        int[][] result = new int[lists.size()][];
        for (int i = 0; i < lists.size(); i++) {
            result[i] = lists.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] results = new Solution().findContinuousSequence(9);
        for (int[] result : results) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
