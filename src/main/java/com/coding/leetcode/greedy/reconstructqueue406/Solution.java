package com.coding.leetcode.greedy.reconstructqueue406;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * \* project: JavaStudy
 * \* package: com.coding.leetcode.greedy.reconstructqueue406
 * \* author: Willi Wei
 * \* date: 2020-08-26 11:26:07
 * \* description:
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 *
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数
 * 排序这个字典,使之位置符合h,k
 * 输出list
 *
 * \
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        LinkedList<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }
        int n = people.length;
        return output.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        for (int[] ints : new Solution().reconstructQueue(new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        })) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
        System.out.println();
    }
}