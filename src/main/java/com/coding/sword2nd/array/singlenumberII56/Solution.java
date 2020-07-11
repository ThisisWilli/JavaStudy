package com.coding.sword2nd.array.singlenumberII56;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.array.singlenumberII56
 * \* author: Willi Wei
 * \* date: 2020-07-11 15:52:33
 * \* description:
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * \
 */
public class Solution {
    public int singleNumber(int[] nums) {//本算法同样适用于数组nums中存在负数的情况
        if (nums.length == 0){
            return -1;
        }

        int[] bitSum = new int[32];
        for (int num : nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--){
                if ((num & bitMask) != 0){
                    bitSum[i]++;
                }

                // 比较位左移
                bitMask = bitMask << 1;
            }
        }

        int res = 0;

        for (int i = 0; i < 32; i++) {
            res = res << 1;
            res += bitSum[i] % 3;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{3, 4, 3, 3}));
    }
}