package com.coding.sword.dp.cutrope;

/**
 * @program: JavaStudy
 * @description:给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 *              请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到
 *              的最大乘积是18。
 * @author: Hoodie_Willi
 * @create: 2020-01-27 09:34
 **/

public class Solution {
    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }
        int[] results = new int[target + 1];
        results[0] = 0;
        results[1] = 1;
        results[2] = 2;
        results[3] = 3;
        for(int i = 4; i <= target; i++){
            int max = 0;
            for(int j = 1; j <= i / 2; j++){
                if(results[j] * results[i - j] > max){
                    max = results[j] * results[i - j];
                }
            }
            results[i] = max;
        }
        return results[target];
    }
}
