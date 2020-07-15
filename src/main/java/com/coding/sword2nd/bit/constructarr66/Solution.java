package com.coding.sword2nd.bit.constructarr66;

import java.util.Arrays;

/**
 * \* project: JavaStudy
 * \* package: com.coding.sword2nd.bit.constructarr66
 * \* author: Willi Wei
 * \* date: 2020-07-15 09:46:38
 * \* description:
 * \给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 *
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 */
public class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0){
            return new int[0];
        }
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = 1;
        right[a.length - 1] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
            right[right.length - 1 - i] = right[right.length - i] * a[right.length - i];
        }

//        for (int i = left.length - 2; i >= 0; i--){
//            right[i] = right[i + 1] * a[i + 1];
//        }

        for (int i = 0; i < a.length; i++){
            left[i] *= right[i];
        }

        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().constructArr(new int[]{1,2,3,4,5})));
    }
}