package com.coding.sword.ary.getuglynumber;

/**
 * @program: JavaStudy
 * @description:
 * @author: Hoodie_Willi
 * @create: 2020-02-24 09:33
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index < 7){
            return index;
        }
        int[] result = new int[index];
        result[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++){
            // 每次从丑数中选择一个最小的丑数加到结果中，比这个丑数大的因数原地不动
            result[i] = Math.min(result[t2] * 2, Math.min(result[t3] * 3, result[t5] * 5));
            if (result[i] == result[t2] * 2){
                t2++;
            }
            if (result[i] == result[t3] * 3){
                t3++;
            }
            if (result[i] == result[t5] * 5){
                t5++;
            }
        }
        return result[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(20));
    }
}
