package com.coding.sword.recursion.jumpFloor;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword.recursion.jumpFloor
 * \* author: Willi Wei
 * \* date: 2020-01-04 12:36:53
 * \* description:一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶，求该青蛙跳上n级台阶总共有多少跳法，先后次序算不同的结果
 * \
 */
public class Solution {
    public int JumpFloor(int target) {
        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().JumpFloor(4));
    }
}