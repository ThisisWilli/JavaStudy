package com.coding.leetcode.array.singlenumbers56;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-04-28 09:09
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 **/

public class Solution {
    /*
    *  1、两个相同数互相异或一定等于0
    *  2、上述情况所有数字相互异或之后，得到的一定是两个只出现一次的数字相互异或的结果
    *   接下来要判断如何分组异或
    *   相互异或肯定有一位为1并且这两个只出现一次的数在这一位上是不同的，那么就以这一位是否为1来判断是否应该分为一组
    *
    */
    public int[] singleNumbers(int[] nums) {
        int[] result = new int[2];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            // 最后得到两个数异或的结果
            temp ^= nums[i];
        }
        int first = 1;
        while ((temp & first) == 0){
            first = first << 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & first) == 0){
                result[0] ^= nums[i];
            }else {
                result[1] ^= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Solution().singleNumbers(new int[]{4, 1, 4, 6});
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
