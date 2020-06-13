package com.coding.leetcode.array.dailytemperatures739;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.array.dailytemperatures739
 * \* author: Willi Wei
 * \* date: 2020-06-13 13:39:35
 * \* description:
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * \
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < T.length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]){
                int preIndex = stack.pop();
                result[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})) {
            System.out.print(i + " ");
        }
    }
}