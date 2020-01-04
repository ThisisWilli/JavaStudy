package com.coding.sword.recursion.jumpFloorII;


import java.util.ArrayList;
import java.util.List;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.recursion.jumpFloorII
 * \* author: Willi Wei
 * \* date: 2020-01-04 12:46:38
 * \* description:变态跳台阶，一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，也可以跳上n级台阶，求该青蛙跳上一个n级台阶总共有多少种
 *                          跳法
 * \
 */
public class Solution {
    public int JumpFloorII(int target) {
        List<Integer> results = new ArrayList<Integer>();
        results.add(1);
        results.add(2);
        int sum = 3;
        for (int i = 2; i < target; i++){
            results.add(sum + 1);
            sum += (sum + 1);
        }
        return results.get(target - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloorII(5));
    }
}