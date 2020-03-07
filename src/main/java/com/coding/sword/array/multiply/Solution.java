package com.coding.sword.array.multiply;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-03-07 09:18
 **/

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *                       B[i] = A[0] * A[1] * ... * A[n-i-1]
 *                       n = 4
 *                       B[0] = A[1] * A[2] * A[3]
 *                       B[1] = A[0] * A[2] * A[3]
 *                       B[2] = A[0] * A[1] * A[3]
 */
public class Solution {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        // 计算上三角
        for (int i = 1; i < A.length - 1;i++){
            B[i] = B[i - 1] * A[i - 1];
        }
        // 计算下三角
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--){
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
