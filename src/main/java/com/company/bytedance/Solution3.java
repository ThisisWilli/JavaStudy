package com.company.bytedance;

/**
 * \* project: JavaStudy
 * \* package: com.company.bytedance
 * \* author: Willi Wei
 * \* date: 2020-07-25 11:00:33
 * \* description: 连续数字组成的数组，每个数组和为0的数组，问一个连续数组中有多少个非零数组
 * \
 */
public class Solution3 {
    /**
     * -1, 0, 2
     * @param nums
     * @return
     */
    public int findNotZeroArray(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempSum = 0;
            for (int j = i; j < nums.length; j++){
                tempSum += nums[i];
                if (tempSum == 0){
                    result += (j - i + 1);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().findNotZeroArray(new int[]{-1, 0, 2}));
    }

}