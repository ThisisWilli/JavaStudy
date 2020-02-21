package com.coding.sword.array.findgreatestsumofsubArray;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-21 09:36
 **/

/**
 * 找出数组中的最大子序列的和
 * 6,-3,-2,7,-15,1,2,2 最大和为 8   6，-3，-2，7
 * 1，-2，3，10，-4，7，2，-5  最大和为1，-2，3，10
 */
public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length <= 0){
            return 0;
        }
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++){
            // 如果当前数相加最大和后小于当前数本身，那么前面的序列被抛弃，最大和为当前数本身
            if (currentSum + array[i] <= array[i]){
                currentSum = array[i];
            }else {
                // 如果当前数加上最大和后小于之前的最大和，那么最大和不变，当前序列之和要加上当前数的值
                currentSum += array[i];
            }
            if (maxSum < currentSum){
                maxSum = currentSum;
            }
        }
        return maxSum;
    }
}
