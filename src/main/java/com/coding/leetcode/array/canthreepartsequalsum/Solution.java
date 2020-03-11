package com.coding.leetcode.array.canthreepartsequalsum;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-11 09:32
 **/

import java.util.Arrays;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *
 */
public class Solution {

    // 也可以左右夹逼，因为左右部分分别为sum / 3 的话，那么剩下中间那部分一定等于sum/3，因为是分成3等分！
    public boolean canThreePartsEqualSum(int[] A) {
        // 先计算数组所有元素的长度，如果数组之和不能被3整除，直接返回false，以及数组长度，然后从头开始遍历数组，如果先记录数组1/3的长度
        if (A.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        int target = sum / 3, currentSum = 0, currentNum = 0;
        if (sum % 3 != 0) {
            target = 0;
        }
        for (int i = 0; i < A.length; i++) {
            currentSum += A[i];
            if (currentSum == target) {
                currentSum = 0;
                currentNum++;
            }
        }
        if (currentNum == 3 && target != 0) {
            return true;
        } else {
            if (target == 0 && currentNum > 3){
                return true;
            }else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().canThreePartsEqualSum(new int[]{10,-10,10,-10,10,-10,10,-10}));
    }
}
